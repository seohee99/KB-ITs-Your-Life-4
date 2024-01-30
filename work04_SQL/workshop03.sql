-- ##################  �׷� �Լ� �ǽ� ######################

-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT ROUND(AVG(sal),2) ���,MAX(empno) �ְ��ο���,MIN(empno) �����ο���
FROM emp
WHERE deptno=30;
-- 2) �� �μ��� �޿��� ���(�Ҽ����� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal)) ���,MAX(empno) �ְ��ο���,MIN(empno) �����ο���
FROM emp
GROUP BY deptno;


-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT deptno,job, COUNT(empno) �ο���
FROM emp
GROUP BY deptno,job;

-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
SELECT deptno,job, COUNT(empno) �ο���
FROM emp
GROUP BY deptno,job
HAVING COUNT(empno)>= 2 ;


-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
SELECT deptno, ROUND(AVG(SAL)) ���, SUM(SAL) ��ü����, MAX(SAL) �ְ����, MIN(SAL) ��������
FROM emp
GROUP BY deptno
ORDER BY 2;


-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �޿��� �Ұ�� ������ ����϶�.
-- �μ��� �����Ѵ�.
SELECT deptno,  job,SUM(SAL) �հ�
FROM emp
GROUP BY ROLLUP(deptno,job);




-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno,  COUNT(empno) �ο���
FROM emp
GROUP BY deptno
HAVING   COUNT(empno) >= 5;

-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧����    ��ȸ������� ���ܽ�Ų��.
SELECT deptno,  MIN(sal), MAX(sal)
FROM emp
GROUP BY deptno
HAVING   MIN(sal) != MAX(sal);


/* 9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
   ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
   �μ����� ��µǵ��� �ؾ� �Ѵ�. */
SELECT deptno,  AVG(sal)
FROM emp
WHERE (deptno IN (10,20,30)) AND (sal BETWEEN 2500 AND 5000)
GROUP BY deptno
HAVING AVG(sal) >= 2000
ORDER BY AVG(sal);



 -- 10)