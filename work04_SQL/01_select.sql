
-- 주석입니다
/*

여러 라인 주석입니다

*/
select * from emp;

-- SELECT :: Projection | Selection
--  Projection 원하는 컬럼만 가져옴
--  Selection 원하는 행만 가져옴.. 조건 부여


SELECT empno, ename, job, deptno FROM emp;

-- emp 테이블에서 모든 사원의 이름과 입사일을 검색
SELECT ename, hiredate from emp;

-- selection + project
SELECT ename, hiredate 
from emp
where job = 'SALESMAN';

-- emp 테이블에서 부서번호가 10번 부서인 사원의 이름, 업무 ,급여, 부서번호를 검색
SELECT ename, job,sal,deptno 
from emp
where deptno= 10;

-- 급여순으로 정렬(내림차순)
SELECT ename, job,sal,deptno 
from emp
where deptno= 10
order by sal desc;

-- projection 순서(첫번째가 1), 정수로 정렬 가능
SELECT ename, job,sal,deptno 
from emp
where deptno= 10
order by 3 desc;

-- 별칭 정렬 가능
SELECT ename, job,sal 급여,deptno 
from emp
where deptno= 10
order by sal desc;

-- 사원 중에서 입사일이 가장 빠른 사원 순으로 검색
SELECT ename, job, hiredate
FROM emp
ORDER BY 3;

-- 사원 중에서 급여를 많이 받는 순으로 정렬, 이름, 급여 업무를 검색
SELECT ename, sal, job
FROM emp
ORDER BY sal DESC;

-- 행을 나타내는 키워드 :: rownum
-- 행을 제한할 때 사용
-- Order by가 오라클에서는 가장 마지막에 실행, rownum이 그 전에 실행된다

-- 우리가 원하는 급여 많이 받는 상위 3인의 결과가 아니다
SELECT ename, sal, job, rownum
FROM emp
where rownum <= 3
ORDER BY sal DESC;

-- 정렬을 강제적으로 먼저 시킨 다음, rownum 호출
SELECT ename, sal, job, rownum as Ranking
FROM (select * from emp order by sal desc)
where rownum <= 3
ORDER BY sal DESC;

/*
SELECT 구문의 서버 안에서의 실행순서
FROM(테이블) --> WHERE(행) -> SELECT(컬럼 제한) -> ROW_NUM -> ORDER BY

MySQL
FROM(테이블) --> WHERE(행) -> SELECT(컬럼 제한) - ORDER BY -> LIMIT

AIias

NULL
1. o도 아니고 공뱁도 아니다
2. 나름의 의미를 가지는 값이다
3. 자격 없음, 미확정(Unknown)을 뜻하는 값일 때 주로 사용된다
4. 연산 적용(+,-,*,/)이 안되고 비교(=,!=,><,>=)가 불가능하다
5. null 값을 가지고 연산을 해야할 때는 다른 값으로 치환시켜서 연산한다...NVL() 함수를 사용
6. 오라클에서 null값은 가장 큰 값으로 취급된다(MySQL은 반대)



*/

-- 모든 사원의 급여르 기존 급여에서 100을 더한값의 두배로 증가
SELECT ename, sal, (sal+100)*2 "증가 급여", job
from emp
order by 3;

-- 사원 급여에서 세금을 제외하고 수령한 급여를 검색(세금을 급여의 10%로 간주)
-- 이름, 업무, 급여, 실제 수령한 급여
SELECT ename, job ,sal, sal-(sal*0.1) as  "실제수령"
from emp
order by 4 desc;

select ename, sal, sal * 12 + comm "AunnalSalary" 
from emp
order by sal * 12+comm;

SELECT job, comm From emp ORDER BY comm DESC;

--해결
SELECT ename, sal ,sal*12+NVL(comm,0) "AnnualSalary"
FROm emp;

--EMP 사원 중에서 COMM이 NULL인 사원의 이름과 업무, 급여를 검색
-- Record 없음.. nulll 값은 비교 불가
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

-- emp 테이블에서 업무가 salesman인 사원의 이름, 급여, 연봉을 검색
-- 이때 연봉이 높은 순에서 낮은 순으로 정렬되도록
SELECT ename, sal, sal*12+NVL(comm,0) "연봉"
from emp
where job = 'SALESMAN'
ORDER BY sal*12;


-- COMM을 가장 많이 받는 사원 순으로 검색(사번, 이름, 업무, COMM)
SELECT deptno, ename, job, comm
FROM emp
WHERE comm is not null
ORDER BY 4 DESC;

-- emp 테이블에서 부서 번호 검색
-- 1 정렬이 안된 채 나옴
SELECT distinct DEPTNO FROM emp;
-- 2 
SELECT DISTINCT deptno FROM emp ORDER BY 1;

/*

DISTINCT
중복을 벗겨내는 키워드
1. SELECT절 바로 뒤에 온다
2. 10G 버전부터 정렬 기능이 빠져 있어서 별도로 정렬을 해야함 

3. 중복값을 제거하는 연산은 많은 시간이 걸린다
만약에 불가피하게 사용해야하는 상황이라면 DISTINCT 연산을 대체하는 방법이나 혹은 연산의 대상이 되는 테이블의 크기를 최소화하는 방법을 제안한다!

가장 대표적인 대체방법으로 EXISTS를 활용하는 방법이 있다


*/
SELECT deptno FROM dept d
WHERE EXISTS(
SELECT * FROM emp e
WHERE d.deptno = e.deptno);


/*

LIKE 연산자와 와일드카드 (%,_)

*/

SELECT ename FROM emp WHERE ename LIKE 'S%';

-- 사원의 이름 중에서 S가 포함된 이름의 사원을 검색
SELECT ename FROM emp
WHERE ename LIKE '%S%';
-- 2번째 문자에 A가 들어가있는 이름의 사원을 검색
SELECT ename FROM emp
WHERE ename LIKE '_A%';
-- 81년도에 입사한 사원을 검색
SELECT * FROM emp
WHERE hiredate LIKE '81%';

