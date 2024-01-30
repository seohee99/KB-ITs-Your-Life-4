-------------------------------------------------------
--------------------- 그룹 함수---------------------
-------------------------------------------------------
/*

COUNT, SUM, AVG, MAX, MIN

SUM, AVG -> 숫자를 대상으로만, 날짜/문자 안됨!!

COUNT, MAX, MIN

*/


--------------------- COUNT---------------------
-- 전체 사원 수를 조회
SELECT COUNT(*) 전체사원수 FROM emp;
SELECT COUNT(deptno) 전체사원수 FROM emp;
SELECT COUNT(-1) 전체사원수 FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;

-- 입사한 지 가장 오래된 사원의 입사일과 가장 최근에 입사한 사원의 입사일을 검색
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

-- 부서 번호가 10번 이거나 20번인 부서의 사원수를 검색
SELECT COUNT(empno)
FROM emp
WHERE deptno IN(10,20);


-- EMP테이블에서 부서번호 수를 검색
SELECT COUNT( DISTINCT deptno)
FROM emp;


-- 모든 사원의 보너스의 평균
-- step 1
SELECT AVG(comm) FROM emp;

-- step 2
SELECT ROUND(AVG(NVL(comm,0))) 뽀나쓰 FROM emp;

-- 사원 급여의 평균값
-- STEP 1
-- 그룹 함수에 포함되지 않은 컬럼이 SELECT절에 나열될 수 없다
-- GROUP BY절 뒤에 명시되어져야 함다
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
-- 부서별 급여의 평균을 검색... 10번 부서는 제외하고 검색... 정렬은 부서번호
-- from -> where -> group by -> select -> order by 
SELECT deptno, ROUND(AVG(sal))
FROM emp
WHERE deptno!=10
GROUP BY deptno
ORDER BY deptno; 

-- 입사년도별 사원수 검색
SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

-- step 1
SELECT EXTRACT(YEAR FROM hiredate) as 입사년도, COUNT(*) 인원수
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

-- step 2
SELECT to_char(hiredate,'YY') FROM emp;

SELECT to_char(hiredate,'YY') 년도별 , COUNT(empno) 사원수
FROM emp
GROUP BY hiredate
ORDER BY 1;

-- STEP 1
-- WHERE절에 그룹함수 쓸 수 없음
-- WHERE절에 alias 안됨 
-- ERROR !!!!!!!
SELECT deptno, ROUND(AVG(sal))
FROM emp
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

-- STEP 2
-- GROUPING한 다음에 추려서 디스플레이한다 :: HAVING
-- 그룹 함수 조건은 무조건 HAVING절에 들어간다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
SELECT deptno, ROUND(AVG(sal))
FROM emp
HAVING ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

-- STEP 3
-- GROUPING한 다음에 추려서 디스플레이한다 :: HAVING
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- 최대 급여가 2900달러가 넘는 부서들의 최대 급여를 출력
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
통계, 쿼리 작성 시 동일한 쿼리문을 Group By절에 작성하고 변경되는 부분들을 일일이 작성한 후
UNION ALL로 결합하는 방식과 (STEP3,4,5)
GROUPING SETS를 사용하는 방식이 있는데(step1)

GROUPING SETS를 사용한 방식이 훨씬 속도가 빠르다.
*/





-- JOIN
-- 여러 테이블로부터 데이터를 가져올 때 사용되는 기법

-- 직원에 대한 정보를 가져옴
SELECT * FROM emp;
SELECT * FROM dept;

-- 직원, 부서에 대한 정보를 가져옴
SELECT * FROM emp, dept;

/*

위처럼 나온 결과를 Cartesian Product라고 한다
emp와 dept 테이블의 수평적인 결합 결과
15 * 4 = 56

Cartesian Product가 도출되는 경우
1) join 조건을 주지 않은 경우
2) 
*/


-- step 1
-- 1. 조인 조건은 양쪽 테이블의 공통적인 컬럼이 조인 조건이 되는 컬럼이다
-- 2. 조인 조건은 where 절에 지정 = 를 사용해서 명시

-- * 표현은 자제해야한다. Projection 요구됨
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- step 2
-- 모든 테이블을 다 뒤적거리기 때문에 성능에 치명적인 영향을 끼친당
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

-- 사원 이름, 급여, 부서번호, 부서이름, 부서위치를 검색
-- where절에서 조인 조건과 함께 비조인조건이 같이 나온다
SELECT  e.ename, e.sal, e.deptno, d.dname , d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno and e.sal >= 2000 and e.deptno = 30;

-- 뉴욕에서 근무하는 사원의 이름과 급여를 검색
SELECT  e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND d.loc = 'NEW YORK';




















