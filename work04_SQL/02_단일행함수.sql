--------------------------------------------------
--------------------- 숫자함수---------------------
--------------------------------------------------

---------------------- ROUND ---------------------

2번째 인자값 2의 의미는소수점 이하 2자리까지 숫자를 나타내라는 뜻
이렇게 되기 위해서는 소수점 이하 둘째자리에서 실질적으로 반올림이 진행된다!!

*/
SELECT ROUND(45.923,2) FROM dual; -- 소수점 둘째자리까지 표시

SELECT ROUND(45.923,0) FROM dual; -- 정수 표시 / 디폴트
SELECT ROUND(45.923) FROM dual;

/*

2번재 인자값이 음수일 때는 .(점)을 기준으로 일, 십, 백 .. 단위로 거슬러 올라감
양수일 때와 달리 해당 자리에서 바로 반올림이 일어난다

*/

SELECT ROUND(45.923,-1) FROM dual; -- 50


---------------------- FLOOR() ---------------------
-- 내림 (소수점 아래를 버림)
SELECT FLOOR(45.923) FROM dual;
--SELECT FLOOR(45.923,2) FROM dual; 자리수 지정이 안됨

SELECT FLOOR(7.6) FROM dual;

---------------------- TRUNC() ---------------------
-- 자리수를 지정, 지정된 자리수 이하를 버림
SELECT TRUNC(45.923) FROM dual;
SELECT TRUNC(45.923,0) FROM dual;
SELECT TRUNC(45.923,2) FROM dual;


---------------------- CEIL() ---------------------
-- 무조건 올림, FLOOR()의 반대, 자리수 지정 안됨 -> 정수만 나타내겠따!
SELECT CEIL(45.923) FROM dual;
SELECT CEIL(45.923,2) FROM dual;

SELECT GREATEST(45.923,2) FROM dual;
SELECT LEAST(1,2,3) FROM dual;

--------------------------------------------------
--------------------- 날짜함수---------------------
--------------------------------------------------

-- 날짜 + 숫자 = 날짜
-- 날짜 - 숫자 = 날짜
-- 날짜 + 날짜 = 기간(일수)
-- 날짜 - 날짜 = 기간(일수)

SELECT SYSDATE FROM dual;
SELECT SYSTIMESTAMP FROM dual;

-- 오늘로부터 100일이 되는 날
SELECT SYSDATE+100 FROM dual;

-- 내일
SELECT SYSDATE+1 내일 FROM dual;
SELECT SYSDATE-1 어제 FROM dual;

-- 그동안 살아오신 생애
-- 오늘 - 생일
SELECT FLOOR((SYSDATE - TO_DATE('99/12/07'))) "서히쓰 살아온날" FROM dual;

-- EXTRACT
SELECT extract(day from sysdate) 일,  extract(month from sysdate) 월,  extract(year from sysdate)년 FROM dual;

-- 사원의 이름, 입사일, 입사년도, 입사 월 정보를 조회하라
SELECT ename, hiredate, EXTRACT(year FROM hiredate) "year", EXTRACT(day FROM hiredate) "day" 
FROM emp
WHERE deptno = 20;

-- EMP테이블에서 10번 부서원이 현재까지의 근무 월수를 계산하여 조회한다
SELECT ename, hiredate, sysdate, months_between(sysdate, hiredate) m_between, trunc(months_between(sysdate, hiredate),0) t_between
FROM emp
WHERE deptno = 10
ORDER BY 4 DESC;

-- EMP 테이블에서 10번 부서원의 입사일자로부터 돌아오는 금요일, 토요일은 계산한다
SELECT ename, hiredate, next_day(hiredate, '금요일') "돌아오는 금요일", next_day(hiredate,7) "돌아오는 토요일"
FROM emp
ORDER BY hiredate DESC;


-- 날짜와 날짜 사이의 개월수 :: MONTHS_BETWEEN(DAY1, DAY2)
-- EMP테이블에서 입사한 날로부터 '2023/07/25'일까지의 개월수
-- 날짜는 자동 형변환 됨
SELECT ABS(TRUNC(MONTHS_BETWEEN('2023/07/25', hiredate))) "입사한날로부터 개월수"
FROM emp;

-- ** EMP 테이블에서 20번 부서 중 급여를 3자리 마다 ,를 출력
SELECT empno, ename, job, sal, to_char(sal, '999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

-- ** EMP 테이블에서 20번 부서중 입사일자를 1998년 1월 1이릐 형태로 출력해라
SELECT ename, hiredate, to_char(hiredate, 'YYYY"년" MM"월" DD"일"') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate DESC;

--------------------------------------------------
---------------------일반 함수---------------------
--------------------------------------------------

---------------------DECODE()---------------------
-- EMP테이블에서 업무가 PRESIDENT / 사장,
--                    MANAGER / 관리자
--                    ANALYST / 직원
--                    기타 / 직원
--                    직업 분류
SELECT empno, ename, sal, job,
    DECODE(job, 'ANALYST', '직원',
                'PRESIDENT', '사장',
                'MANAGER', '관리자',
                 '직원'
                ) "직업 분류"
FROM emp;



SELECT empno, ename, sal, job,
    DECODE(sal, 5000, 'OWNER 급여',
                3000, '고액 급여',
                 '일반 급여'
                ) "급여 구분"
FROM emp;



---------------------CASE()---------------------
SELECT empno, ename, sal, job,
    CASE    WHEN  sal =  5000 THEN 'OWNER 급여'
                    WHEN  sal =  3000 THEN '고액 급여'
                   ELSE  '일반 급여' -- esle 안하면 NULL로 처리됨
               END  "급여 구분"
FROM emp;




























