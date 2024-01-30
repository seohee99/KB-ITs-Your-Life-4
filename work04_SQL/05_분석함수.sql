-- �м��Լ�
-- OVER()�Լ��� ORDER BY�� �ڿ� �۵��Ѵ�
SELECT empno, ename, deptno, sal, RANK() over (ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal, DENSE_RANK() over (ORDER BY sal DESC) "RANK"
FROM emp;

-- PARTITION BY / GROUP BY :  
-- PARTITION BY : ��� �࿡ ���� ���� ����
SELECT empno, ename, deptno, sal, RANK() over (PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;

-- �м��Լ��� OVER HEAD�� �ٿ��ش�.. ������ ����... JOIN/SUBQUERY�� �پ���
-- step1
SELECT ename, sal, rownum FROM emp ORDER BY sal DESC;

--step2
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;


--step3 ROW_NUMBER() OVER()�Բ� ����ؼ� setp2�� ������ ��� ���
SELECT ename, sal, ROW_NUMBER() OVER (ORDER BY sal DESC) "RANK"
FROM emp
WHERE rownum <= 3;



-- ROW_NUMBER()
-- GROUP BY��, ORDER BY ������ ������ ���� ������ �Ҵ��ϴ� �м��Լ�
-- ����ũ�ϰ� ��������
SELECT ename, sal, hiredate,
ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) ����
FROM emp;



SELECT ename, sal, hiredate,
ROW_NUMBER() OVER(ORDER BY sal DESC) ����
FROM emp;




















