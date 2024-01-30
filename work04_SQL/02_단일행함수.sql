--------------------------------------------------
--------------------- �����Լ�---------------------
--------------------------------------------------

---------------------- ROUND ---------------------

2��° ���ڰ� 2�� �ǹ̴¼Ҽ��� ���� 2�ڸ����� ���ڸ� ��Ÿ����� ��
�̷��� �Ǳ� ���ؼ��� �Ҽ��� ���� ��°�ڸ����� ���������� �ݿø��� ����ȴ�!!

*/
SELECT ROUND(45.923,2) FROM dual; -- �Ҽ��� ��°�ڸ����� ǥ��

SELECT ROUND(45.923,0) FROM dual; -- ���� ǥ�� / ����Ʈ
SELECT ROUND(45.923) FROM dual;

/*

2���� ���ڰ��� ������ ���� .(��)�� �������� ��, ��, �� .. ������ �Ž��� �ö�
����� ���� �޸� �ش� �ڸ����� �ٷ� �ݿø��� �Ͼ��

*/

SELECT ROUND(45.923,-1) FROM dual; -- 50


---------------------- FLOOR() ---------------------
-- ���� (�Ҽ��� �Ʒ��� ����)
SELECT FLOOR(45.923) FROM dual;
--SELECT FLOOR(45.923,2) FROM dual; �ڸ��� ������ �ȵ�

SELECT FLOOR(7.6) FROM dual;

---------------------- TRUNC() ---------------------
-- �ڸ����� ����, ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923) FROM dual;
SELECT TRUNC(45.923,0) FROM dual;
SELECT TRUNC(45.923,2) FROM dual;


---------------------- CEIL() ---------------------
-- ������ �ø�, FLOOR()�� �ݴ�, �ڸ��� ���� �ȵ� -> ������ ��Ÿ���ڵ�!
SELECT CEIL(45.923) FROM dual;
SELECT CEIL(45.923,2) FROM dual;

SELECT GREATEST(45.923,2) FROM dual;
SELECT LEAST(1,2,3) FROM dual;

--------------------------------------------------
--------------------- ��¥�Լ�---------------------
--------------------------------------------------

-- ��¥ + ���� = ��¥
-- ��¥ - ���� = ��¥
-- ��¥ + ��¥ = �Ⱓ(�ϼ�)
-- ��¥ - ��¥ = �Ⱓ(�ϼ�)

SELECT SYSDATE FROM dual;
SELECT SYSTIMESTAMP FROM dual;

-- ���÷κ��� 100���� �Ǵ� ��
SELECT SYSDATE+100 FROM dual;

-- ����
SELECT SYSDATE+1 ���� FROM dual;
SELECT SYSDATE-1 ���� FROM dual;

-- �׵��� ��ƿ��� ����
-- ���� - ����
SELECT FLOOR((SYSDATE - TO_DATE('99/12/07'))) "������ ��ƿ³�" FROM dual;

-- EXTRACT
SELECT extract(day from sysdate) ��,  extract(month from sysdate) ��,  extract(year from sysdate)�� FROM dual;

-- ����� �̸�, �Ի���, �Ի�⵵, �Ի� �� ������ ��ȸ�϶�
SELECT ename, hiredate, EXTRACT(year FROM hiredate) "year", EXTRACT(day FROM hiredate) "day" 
FROM emp
WHERE deptno = 20;

-- EMP���̺��� 10�� �μ����� ��������� �ٹ� ������ ����Ͽ� ��ȸ�Ѵ�
SELECT ename, hiredate, sysdate, months_between(sysdate, hiredate) m_between, trunc(months_between(sysdate, hiredate),0) t_between
FROM emp
WHERE deptno = 10
ORDER BY 4 DESC;

-- EMP ���̺��� 10�� �μ����� �Ի����ڷκ��� ���ƿ��� �ݿ���, ������� ����Ѵ�
SELECT ename, hiredate, next_day(hiredate, '�ݿ���') "���ƿ��� �ݿ���", next_day(hiredate,7) "���ƿ��� �����"
FROM emp
ORDER BY hiredate DESC;


-- ��¥�� ��¥ ������ ������ :: MONTHS_BETWEEN(DAY1, DAY2)
-- EMP���̺��� �Ի��� ���κ��� '2023/07/25'�ϱ����� ������
-- ��¥�� �ڵ� ����ȯ ��
SELECT ABS(TRUNC(MONTHS_BETWEEN('2023/07/25', hiredate))) "�Ի��ѳ��κ��� ������"
FROM emp;

-- ** EMP ���̺��� 20�� �μ� �� �޿��� 3�ڸ� ���� ,�� ���
SELECT empno, ename, job, sal, to_char(sal, '999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

-- ** EMP ���̺��� 20�� �μ��� �Ի����ڸ� 1998�� 1�� 1�̐l ���·� ����ض�
SELECT ename, hiredate, to_char(hiredate, 'YYYY"��" MM"��" DD"��"') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate DESC;

--------------------------------------------------
---------------------�Ϲ� �Լ�---------------------
--------------------------------------------------

---------------------DECODE()---------------------
-- EMP���̺��� ������ PRESIDENT / ����,
--                    MANAGER / ������
--                    ANALYST / ����
--                    ��Ÿ / ����
--                    ���� �з�
SELECT empno, ename, sal, job,
    DECODE(job, 'ANALYST', '����',
                'PRESIDENT', '����',
                'MANAGER', '������',
                 '����'
                ) "���� �з�"
FROM emp;



SELECT empno, ename, sal, job,
    DECODE(sal, 5000, 'OWNER �޿�',
                3000, '��� �޿�',
                 '�Ϲ� �޿�'
                ) "�޿� ����"
FROM emp;



---------------------CASE()---------------------
SELECT empno, ename, sal, job,
    CASE    WHEN  sal =  5000 THEN 'OWNER �޿�'
                    WHEN  sal =  3000 THEN '��� �޿�'
                   ELSE  '�Ϲ� �޿�' -- esle ���ϸ� NULL�� ó����
               END  "�޿� ����"
FROM emp;




























