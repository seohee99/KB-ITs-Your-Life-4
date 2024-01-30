--SELF 조인 :: 하나의 테이블을 자체적으로 조인함
-- 특정 사원 상사의 이름을 검색
SELECT empno, ename, mgr
FROM emp;

/* 
                                            EMP E
1. 특정 사원의 ename을 조회해서 emp 테이블에서 찾는다..SMITH
2. SMITH의 상사번호 mgr을 조회..관리자 번호를 찾는다..7902
-------------------------------------------------------------------------------------
                                            EMP M
3. 다시 7902의 empno를 찾는다
4. empno가 7902번인 사원의 이름 ename을 찾는다..FORD

*/

-- 1 step
SELECT empno, ename, mgr FROM emp; -- e 사원의 상사 번호를 찾고
SELECT empno, ename FROM emp; -- m 사원의 이름을 찾고

SELECT * FROM (SELECT empno, ename, mgr FROM emp) e, 
(SELECT empno, ename FROM emp) m;



-- 2 step 
SELECT * FROM
(SELECT empno, ename, mgr FROM emp) e, 
(SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;



-- 3 step, Alias 지정, 사원번호, 사원이름, 상사이름
SELECT e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
FROM emp e, emp m
WHERE e.mgr = m.empno
ORDER BY 1;



-- 4 step 특정 사원(BLAKE)의 상사이름을 검색
SELECT e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
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
WHERE e.deptno(+) = d.deptno AND e.sal > 2000; -- 결과 안나옴 -> 비조인조건에도 (+)해줘!!


-- Sub Query(Inner Query)

-- ?에 해당하는 부분을 ( )안에 쿼리를 먼저 수행하고, 그 결과가 main 쿼리에서 실행
-- CLARK의 급여(?) 보다 더 많은 급여를 받는 사원의 이름과 급여, 업무를 검색
-- 1row, 1column : 스칼라 서브쿼리
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

-- WHERE 절 뒤에오는 서브쿠리
SELECT ename, sal, deptno
FROm emp
WHERE sal > (SELECT AVG(sal) FROM emp);

-- job별 가장 작은 평균급여를 검색...업무, 평균 급여, 출력
-- Having절 뒤에 오는 서브 쿼리
-- 그룹함수 중첩
SELECT job,AVG(sal)
FROM emp
GROUP BY job
HAVING AVG(sal)  = (SELECT MIN(AVG(sal))  FROM emp GROUP BY job);
 
 
 -- from절 뒤에 오는 서브 쿼리
 -- 시ㅏ원 증에서 급여를 제일 많이 받는 사원 링킹 3를 ㄹ검색
 SELECT ename, sal, rownum
 FROM emp
 ORDER BY sal DESC;
 
 -- 급여 순위 
 -- 그룹함수의 중첩이 가능하다(오라클) <-> MySQL은 안됨
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

-- //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-- SCOTT의 급여보다 더 많은 급여를 받는 사원 검색(가장 전형적인 서브쿼리..? 해결.. where절)
-- STEP 1
SELECT ename, job, sal FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- STEP 2 (서브쿼리 자체를 b)
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename = 'SCOTT' ) b
WHERE a.sal > b.sal;

 -- 에러 발생
 --  다중행 서브쿼리에서 단일행 연산자 사용
 -- 다중행 서브쿼리에서는 다중행 연산자를 사용 
SELECT empno, ename 
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno); -- 800, 950, 1300 ( 다중행 서브쿼리)
--해결
SELECT empno, ename 
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);



-- 예제2)업무가 SALESMAN인 최소 한명이상의 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' 
AND sal > ANY (SELECT sal FROM emp WHERE job = 'SALESMAN');

-- 그룹함수로 작성 가능(결과 같음!)
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' 
AND sal >  (SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN');


-- 예제 3) 업무가 SALESMAN인 모든 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무, 입사일, 부서번호를 조회
SELECT ename, sal, job, hiredate, deptno
FROM emp
WHERE job != 'SALESMAN' AND
sal > ALL (SELECT sal FROM emp
WHERE job = 'SALESMAN');

-- 그룹함수
SELECT ename, sal, job, hiredate, deptno
FROM emp
WHERE job != 'SALESMAN' AND
sal >  (SELECT MAX(sal) FROM emp
WHERE job = 'SALESMAN');



-- 부서 번호가 30번인 사원의 급여 중에서 가장 낮은 급여(950)보다 더 높은 급여를 받는 사원의 이름, 급여, 부서번호 출력
-- 그룹함수
SELECT ename, sal, deptno
FROM emp
WHERE sal > (
SELECT MIN(sal)  FROM emp WHERE deptno = '30')
ORDER BY 1;

-- 다중행 연산자
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY (
SELECT sal FROM emp WHERE deptno = '30')
ORDER BY 1;


-- 서브쿼리에서의 NULL 값
-- EMP 테이블에서 부하직원을 거느리는 사원 검색
SELECT DISTINCT m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND (e.mgr IS NOT NULL);

SELECT * FROM emp WHERE empno IN(SELECT mgr FROM EMP);


-- EMP 테이블에서 부하직원을 거느리지 않는 사원 검색
-- NOT IN -> NVL로 치환해서 Null값 처리!!
SELECT * FROM emp WHERE empno NOT IN(SELECT NVL(mgr,0) FROM EMP);











