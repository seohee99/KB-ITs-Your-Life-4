-- 제약 조건
-- employee | department 2개를 생성
-- CTAS

DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee AS
(SELECT * FROM emp);

CREATE TABLE department AS
(SELECT * FROM dept);

DESC employee;
DESC department;


-- PK(기본기) 제약 조건을 테이블에 추가
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);


-- FK(외래키) 제약 조건
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno);


-- FK(외래키) 제약 조건 + ON DELETE CASCADE
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;



DELETE employee WHERE empno=7369; -- SMITH  삭제
SELECT * FROM employee;

-- 20번 부서를 삭제하더라도 20번 부서에서 근무하는 직원은 그대로이다
-- 이것은 employee테이블과 department테이블이 연관(Relation) 되어져있지 않기 때문이다
-- FK 제약 조건을 추가해야하는 이유이다

DELETE department WHERE deptno=20; 
SELECT * FROM department;


-- FK 제약조건을 추가하면 자식을 가지고 있는 부모 테이블 삭제가 안된다
-- 해결방법은 자식 레코드를 먼저 삭제한 후 부모 레코드 삭제를 진행
-- 위와 같은 작어블 그대로 해주는 옵션이 바로 ON DELELTE CASCADE
-- FK제약 조건을 지정할 때 ON DELETE CASCADE 옵션을 함께 지정해야한다












