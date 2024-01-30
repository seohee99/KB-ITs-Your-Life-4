--SELF ���� :: �ϳ��� ���̺��� ��ü������ ������
-- Ư�� ��� ����� �̸��� �˻�
SELECT empno, ename, mgr
FROM emp;

/* 
                                            EMP E
1. Ư�� ����� ename�� ��ȸ�ؼ� emp ���̺��� ã�´�..SMITH
2. SMITH�� ����ȣ mgr�� ��ȸ..������ ��ȣ�� ã�´�..7902
-------------------------------------------------------------------------------------
                                            EMP M
3. �ٽ� 7902�� empno�� ã�´�
4. empno�� 7902���� ����� �̸� ename�� ã�´�..FORD

*/

-- 1 step
SELECT empno, ename, mgr FROM emp; -- e ����� ��� ��ȣ�� ã��
SELECT empno, ename FROM emp; -- m ����� �̸��� ã��

SELECT * FROM (SELECT empno, ename, mgr FROM emp) e, 
(SELECT empno, ename FROM emp) m;



-- 2 step 
SELECT * FROM
(SELECT empno, ename, mgr FROM emp) e, 
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;



-- 3 step, Alias ����, �����ȣ, ����̸�, ����̸�
SELECT e.empno �����ȣ, e.ename ����̸�, m.ename ����̸� 
FROM emp e, emp m
WHERE e.mgr = m.empno
ORDER BY 1;



-- 4 step Ư�� ���(BLAKE)�� ����̸��� �˻�
SELECT e.empno �����ȣ, e.ename ����̸�, m.ename ����̸� 
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'BLAKE';



-- OUTER JOIN
SELECT DISTINCT(deptno) FROM emp;
SELECT deptno FROM dept;

SELECT e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM emp e, dept d
WHERE d.deptno = e.deptno(+);

SELECT  e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND e.sal > 2000; -- ��� �ȳ��� -> ���������ǿ��� (+)����!!


-- Sub Query(Inner Query)

-- ?�� �ش��ϴ� �κ��� ( )�ȿ� ������ ���� �����ϰ�, �� ����� main �������� ����
-- CLARK�� �޿�(?) ���� �� ���� �޿��� �޴� ����� �̸��� �޿�, ������ �˻�
-- 1row, 1column : ��Į�� ��������
SELECT ename, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK');


SELECT ename, ename, job, sal, hiredate
FROM emp
WHERE job = (SELECT job FROM emp WHERE empno = 7521) 
AND
                sal > (SELECT sal FROM emp WHERE empno = 7934);
                
                
SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

-- WHERE �� �ڿ����� ������
SELECT ename, sal, deptno
FROm emp
WHERE sal > (SELECT AVG(sal) FROM emp);

-- job�� ���� ���� ��ձ޿��� �˻�...����, ��� �޿�, ���
-- Having�� �ڿ� ���� ���� ����
-- �׷��Լ� ��ø
SELECT job,AVG(sal)
FROM emp
GROUP BY job
HAVING AVG(sal)  = (SELECT MIN(AVG(sal))  FROM emp GROUP BY job);
 
 
 -- from�� �ڿ� ���� ���� ����
 -- �ä��� ������ �޿��� ���� ���� �޴� ��� ��ŷ 3�� ���˻�
 SELECT ename, sal, rownum
 FROM emp
 ORDER BY sal DESC;
 
 -- �޿� ���� 
 -- �׷��Լ��� ��ø�� �����ϴ�(����Ŭ) <-> MySQL�� �ȵ�
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SCOTT�� �޿����� �� ���� �޿��� �޴� ��� �˻�(���� �������� ��������..? �ذ�.. where��)
-- STEP 1
SELECT ename, job, sal FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- STEP 2 (�������� ��ü�� b)
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename = 'SCOTT' ) b
WHERE a.sal > b.sal;

 -- ���� �߻�
 --  ������ ������������ ������ ������ ���
 -- ������ �������������� ������ �����ڸ� ��� 
SELECT empno, ename 
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno); -- 800, 950, 1300 ( ������ ��������)
--�ذ�
SELECT empno, ename 
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);



-- ����2)������ SALESMAN�� �ּ� �Ѹ��̻��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' 
AND sal > ANY (SELECT sal FROM emp WHERE job = 'SALESMAN');

-- �׷��Լ��� �ۼ� ����(��� ����!)
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' 
AND sal >  (SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN');


-- ���� 3) ������ SALESMAN�� ��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ����, �Ի���, �μ���ȣ�� ��ȸ
SELECT ename, sal, job, hiredate, deptno
FROM emp
WHERE job != 'SALESMAN' AND
sal > ALL (SELECT sal FROM emp
WHERE job = 'SALESMAN');

-- �׷��Լ�
SELECT ename, sal, job, hiredate, deptno
FROM emp
WHERE job != 'SALESMAN' AND
sal >  (SELECT MAX(sal) FROM emp
WHERE job = 'SALESMAN');



-- �μ� ��ȣ�� 30���� ����� �޿� �߿��� ���� ���� �޿�(950)���� �� ���� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ ���
-- �׷��Լ�
SELECT ename, sal, deptno
FROM emp
WHERE sal > (
SELECT MIN(sal)  FROM emp WHERE deptno = '30')
ORDER BY 1;

-- ������ ������
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY (
SELECT sal FROM emp WHERE deptno = '30')
ORDER BY 1;


-- �������������� NULL ��
-- EMP ���̺��� ���������� �Ŵ����� ��� �˻�
SELECT DISTINCT m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND (e.mgr IS NOT NULL);

SELECT * FROM emp WHERE empno IN(SELECT mgr FROM EMP);


-- EMP ���̺��� ���������� �Ŵ����� �ʴ� ��� �˻�
-- NOT IN -> NVL�� ġȯ�ؼ� Null�� ó��!!
SELECT * FROM emp WHERE empno NOT IN(SELECT NVL(mgr,0) FROM EMP);











