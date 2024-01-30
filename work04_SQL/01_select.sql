
-- �ּ��Դϴ�
/*

���� ���� �ּ��Դϴ�

*/
select * from emp;

-- SELECT :: Projection | Selection
--  Projection ���ϴ� �÷��� ������
--  Selection ���ϴ� �ุ ������.. ���� �ο�


SELECT empno, ename, job, deptno FROM emp;

-- emp ���̺��� ��� ����� �̸��� �Ի����� �˻�
SELECT ename, hiredate from emp;

-- selection + project
SELECT ename, hiredate 
from emp
where job = 'SALESMAN';

-- emp ���̺��� �μ���ȣ�� 10�� �μ��� ����� �̸�, ���� ,�޿�, �μ���ȣ�� �˻�
SELECT ename, job,sal,deptno 
from emp
where deptno= 10;

-- �޿������� ����(��������)
SELECT ename, job,sal,deptno 
from emp
where deptno= 10
order by sal desc;

-- projection ����(ù��°�� 1), ������ ���� ����
SELECT ename, job,sal,deptno 
from emp
where deptno= 10
order by 3 desc;

-- ��Ī ���� ����
SELECT ename, job,sal �޿�,deptno 
from emp
where deptno= 10
order by sal desc;

-- ��� �߿��� �Ի����� ���� ���� ��� ������ �˻�
SELECT ename, job, hiredate
FROM emp
ORDER BY 3;

-- ��� �߿��� �޿��� ���� �޴� ������ ����, �̸�, �޿� ������ �˻�
SELECT ename, sal, job
FROM emp
ORDER BY sal DESC;

-- ���� ��Ÿ���� Ű���� :: rownum
-- ���� ������ �� ���
-- Order by�� ����Ŭ������ ���� �������� ����, rownum�� �� ���� ����ȴ�

-- �츮�� ���ϴ� �޿� ���� �޴� ���� 3���� ����� �ƴϴ�
SELECT ename, sal, job, rownum
FROM emp
where rownum <= 3
ORDER BY sal DESC;

-- ������ ���������� ���� ��Ų ����, rownum ȣ��
SELECT ename, sal, job, rownum as Ranking
FROM (select * from emp order by sal desc)
where rownum <= 3
ORDER BY sal DESC;

/*
SELECT ������ ���� �ȿ����� �������
FROM(���̺�) --> WHERE(��) -> SELECT(�÷� ����) -> ROW_NUM -> ORDER BY

MySQL
FROM(���̺�) --> WHERE(��) -> SELECT(�÷� ����) - ORDER BY -> LIMIT

AIias

NULL
1. o�� �ƴϰ� ���� �ƴϴ�
2. ������ �ǹ̸� ������ ���̴�
3. �ڰ� ����, ��Ȯ��(Unknown)�� ���ϴ� ���� �� �ַ� ���ȴ�
4. ���� ����(+,-,*,/)�� �ȵǰ� ��(=,!=,><,>=)�� �Ұ����ϴ�
5. null ���� ������ ������ �ؾ��� ���� �ٸ� ������ ġȯ���Ѽ� �����Ѵ�...NVL() �Լ��� ���
6. ����Ŭ���� null���� ���� ū ������ ��޵ȴ�(MySQL�� �ݴ�)



*/

-- ��� ����� �޿��� ���� �޿����� 100�� ���Ѱ��� �ι�� ����
SELECT ename, sal, (sal+100)*2 "���� �޿�", job
from emp
order by 3;

-- ��� �޿����� ������ �����ϰ� ������ �޿��� �˻�(������ �޿��� 10%�� ����)
-- �̸�, ����, �޿�, ���� ������ �޿�
SELECT ename, job ,sal, sal-(sal*0.1) as  "��������"
from emp
order by 4 desc;

select ename, sal, sal * 12 + comm "AunnalSalary" 
from emp
order by sal * 12+comm;

SELECT job, comm From emp ORDER BY comm DESC;

--�ذ�
SELECT ename, sal ,sal*12+NVL(comm,0) "AnnualSalary"
FROm emp;

--EMP ��� �߿��� COMM�� NULL�� ����� �̸��� ����, �޿��� �˻�
-- Record ����.. nulll ���� �� �Ұ�
-- 1
SELECT ename, sal, job
FROM emp
WHERE comm = null;

-- 2
SELECT ename, sal, job
FROM emp
WHERE comm  is null;

-- 3
SELECT ename, sal, job
FROM emp
WHERE comm is NOT null;

-- emp ���̺��� ������ salesman�� ����� �̸�, �޿�, ������ �˻�
-- �̶� ������ ���� ������ ���� ������ ���ĵǵ���
SELECT ename, sal, sal*12+NVL(comm,0) "����"
from emp
where job = 'SALESMAN'
ORDER BY sal*12;


-- COMM�� ���� ���� �޴� ��� ������ �˻�(���, �̸�, ����, COMM)
SELECT deptno, ename, job, comm
FROM emp
WHERE comm is not null
ORDER BY 4 DESC;

-- emp ���̺��� �μ� ��ȣ �˻�
-- 1 ������ �ȵ� ä ����
SELECT distinct DEPTNO FROM emp;
-- 2 
SELECT DISTINCT deptno FROM emp ORDER BY 1;

/*

DISTINCT
�ߺ��� ���ܳ��� Ű����
1. SELECT�� �ٷ� �ڿ� �´�
2. 10G �������� ���� ����� ���� �־ ������ ������ �ؾ��� 

3. �ߺ����� �����ϴ� ������ ���� �ð��� �ɸ���
���࿡ �Ұ����ϰ� ����ؾ��ϴ� ��Ȳ�̶�� DISTINCT ������ ��ü�ϴ� ����̳� Ȥ�� ������ ����� �Ǵ� ���̺��� ũ�⸦ �ּ�ȭ�ϴ� ����� �����Ѵ�!

���� ��ǥ���� ��ü������� EXISTS�� Ȱ���ϴ� ����� �ִ�


*/
SELECT deptno FROM dept d
WHERE EXISTS(
SELECT * FROM emp e
WHERE d.deptno = e.deptno);


/*

LIKE �����ڿ� ���ϵ�ī�� (%,_)

*/

SELECT ename FROM emp WHERE ename LIKE 'S%';

-- ����� �̸� �߿��� S�� ���Ե� �̸��� ����� �˻�
SELECT ename FROM emp
WHERE ename LIKE '%S%';
-- 2��° ���ڿ� A�� ���ִ� �̸��� ����� �˻�
SELECT ename FROM emp
WHERE ename LIKE '_A%';
-- 81�⵵�� �Ի��� ����� �˻�
SELECT * FROM emp
WHERE hiredate LIKE '81%';

