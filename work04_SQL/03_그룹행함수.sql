-------------------------------------------------------
--------------------- �׷� �Լ�---------------------
-------------------------------------------------------
/*

COUNT, SUM, AVG, MAX, MIN

SUM, AVG -> ���ڸ� ������θ�, ��¥/���� �ȵ�!!

COUNT, MAX, MIN

*/


--------------------- COUNT---------------------
-- ��ü ��� ���� ��ȸ
SELECT COUNT(*) ��ü����� FROM emp;
SELECT COUNT(deptno) ��ü����� FROM emp;
SELECT COUNT(-1) ��ü����� FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;

-- �Ի��� �� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� �˻�
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

-- �μ� ��ȣ�� 10�� �̰ų� 20���� �μ��� ������� �˻�
SELECT COUNT(empno)
FROM emp
WHERE deptno IN(10,20);


-- EMP���̺��� �μ���ȣ ���� �˻�
SELECT COUNT( DISTINCT deptno)
FROM emp;


-- ��� ����� ���ʽ��� ���
-- step 1
SELECT AVG(comm) FROM emp;

-- step 2
SELECT ROUND(AVG(NVL(comm,0))) �ǳ��� FROM emp;

-- ��� �޿��� ��հ�
-- STEP 1
-- �׷� �Լ��� ���Ե��� ���� �÷��� SELECT���� ������ �� ����
-- GROUP BY�� �ڿ� ��õǾ����� �Դ�
SELECT deptno, AVG(sal) FROM emp;

-- STEP 2
SELECT  deptno, ROUND(AVG(sal)) "AvgSalary"
FROM emp
GROUP BY deptno;

-- STEP 3
SELECT  deptno, ROUND(AVG(sal)) "AvgSalary"
FROM emp
GROUP BY deptno
ORDER BY 2;

-- STEP 4
SELECT  deptno, ROUND(AVG(sal)) "AvgSalary" -- 3
FROM emp -- 1
GROUP BY deptno -- 2
ORDER BY 2; -- 4

-- STEP 5
-- �μ��� �޿��� ����� �˻�... 10�� �μ��� �����ϰ� �˻�... ������ �μ���ȣ
-- from -> where -> group by -> select -> order by 
SELECT deptno, ROUND(AVG(sal))
FROM emp
WHERE deptno!=10
GROUP BY deptno
ORDER BY deptno; 

-- �Ի�⵵�� ����� �˻�
SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

-- step 1
SELECT EXTRACT(YEAR FROM hiredate) as �Ի�⵵, COUNT(*) �ο���
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

-- step 2
SELECT to_char(hiredate,'YY') FROM emp;

SELECT to_char(hiredate,'YY') �⵵�� , COUNT(empno) �����
FROM emp
GROUP BY hiredate
ORDER BY 1;

-- STEP 1
-- WHERE���� �׷��Լ� �� �� ����
-- WHERE���� alias �ȵ� 
-- ERROR !!!!!!!
SELECT deptno, ROUND(AVG(sal))
FROM emp
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

-- STEP 2
-- GROUPING�� ������ �߷��� ���÷����Ѵ� :: HAVING
-- �׷� �Լ� ������ ������ HAVING���� ����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
SELECT deptno, ROUND(AVG(sal))
FROM emp
HAVING ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

-- STEP 3
-- GROUPING�� ������ �߷��� ���÷����Ѵ� :: HAVING
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- �ִ� �޿��� 2900�޷��� �Ѵ� �μ����� �ִ� �޿��� ���
SELECT deptno,MAX(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > 2900;

--------------------- ROLLUP()---------------------
-- STEP 1
SELECT deptno,COUNT(*),SUM(sal)
FROM emp
GROUP BY deptno;

-- STEP 2
SELECT deptno,COUNT(*),SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno);

-- STEP 3
SELECT deptno,job ,SUM(sal) 
FROM emp
GROUP BY ROLLUP(deptno, job);

SELECT deptno,job ,SUM(sal) 
FROM emp
GROUP BY ROLLUP(job, deptno);

-- STEP 4
SELECT deptno,job ,mgr, SUM(sal) 
FROM emp
GROUP BY ROLLUP(deptno, job,mgr);


--------------------- GROUPING SETS()---------------------

-- STEP 1
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);

--STEP 2
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;

--STEP 3
SELECT to_char(deptno), SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;

-- STEP 4
SELECT deptno ||' ', SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;

-- STEP 5
SELECT deptno , NULL job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal)
FROM emp
GROUP BY job;

/*
���, ���� �ۼ� �� ������ �������� Group By���� �ۼ��ϰ� ����Ǵ� �κе��� ������ �ۼ��� ��
UNION ALL�� �����ϴ� ��İ� (STEP3,4,5)
GROUPING SETS�� ����ϴ� ����� �ִµ�(step1)

GROUPING SETS�� ����� ����� �ξ� �ӵ��� ������.
*/





-- JOIN
-- ���� ���̺�κ��� �����͸� ������ �� ���Ǵ� ���

-- ������ ���� ������ ������
SELECT * FROM emp;
SELECT * FROM dept;

-- ����, �μ��� ���� ������ ������
SELECT * FROM emp, dept;

/*

��ó�� ���� ����� Cartesian Product��� �Ѵ�
emp�� dept ���̺��� �������� ���� ���
15 * 4 = 56

Cartesian Product�� ����Ǵ� ���
1) join ������ ���� ���� ���
2) 
*/


-- step 1
-- 1. ���� ������ ���� ���̺��� �������� �÷��� ���� ������ �Ǵ� �÷��̴�
-- 2. ���� ������ where ���� ���� = �� ����ؼ� ���

-- * ǥ���� �����ؾ��Ѵ�. Projection �䱸��
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- step 2
-- ��� ���̺��� �� �����Ÿ��� ������ ���ɿ� ġ������ ������ ��ģ��
SELECT empno, ename, sal, deptno, dname 
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- step 3
SELECT emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname 
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- step 4
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- ��� �̸�, �޿�, �μ���ȣ, �μ��̸�, �μ���ġ�� �˻�
-- where������ ���� ���ǰ� �Բ� ������������ ���� ���´�
SELECT  e.ename, e.sal, e.deptno, d.dname , d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno and e.sal >= 2000 and e.deptno = 30;

-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� �˻�
SELECT  e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND d.loc = 'NEW YORK';




















