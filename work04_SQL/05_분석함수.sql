-- 분석함수
-- OVER()함수는 ORDER BY절 뒤에 작동한다
SELECT empno, ename, deptno, sal, RANK() over (ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal, DENSE_RANK() over (ORDER BY sal DESC) "RANK"
FROM emp;

-- PARTITION BY / GROUP BY :  
-- PARTITION BY : 모든 행에 대해 값이 나옴
SELECT empno, ename, deptno, sal, RANK() over (PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;

-- 분석함수가 OVER HEAD를 줄여준다.. 성능이 좋다... JOIN/SUBQUERY가 줄어든다
-- step1
SELECT ename, sal, rownum FROM emp ORDER BY sal DESC;

--step2
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;


--step3 ROW_NUMBER() OVER()함께 사용해서 setp2와 동일한 결과 출력
SELECT ename, sal, ROW_NUMBER() OVER (ORDER BY sal DESC) "RANK"
FROM emp
WHERE rownum <= 3;



-- ROW_NUMBER()
-- GROUP BY절, ORDER BY 절에서 지정된 행의 순서를 할당하는 분석함수
-- 유니크하게 나오도록
SELECT ename, sal, hiredate,
ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) 순번
FROM emp;



SELECT ename, sal, hiredate,
ROW_NUMBER() OVER(ORDER BY sal DESC) 순번
FROM emp;




















