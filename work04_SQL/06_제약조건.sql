-- ���� ����
-- employee | department 2���� ����
-- CTAS

DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee AS
(SELECT * FROM emp);

CREATE TABLE department AS
(SELECT * FROM dept);

DESC employee;
DESC department;


-- PK(�⺻��) ���� ������ ���̺� �߰�
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);


-- FK(�ܷ�Ű) ���� ����
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno);


-- FK(�ܷ�Ű) ���� ���� + ON DELETE CASCADE
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;



DELETE employee WHERE empno=7369; -- SMITH  ����
SELECT * FROM employee;

-- 20�� �μ��� �����ϴ��� 20�� �μ����� �ٹ��ϴ� ������ �״���̴�
-- �̰��� employee���̺�� department���̺��� ����(Relation) �Ǿ������� �ʱ� �����̴�
-- FK ���� ������ �߰��ؾ��ϴ� �����̴�

DELETE department WHERE deptno=20; 
SELECT * FROM department;


-- FK ���������� �߰��ϸ� �ڽ��� ������ �ִ� �θ� ���̺� ������ �ȵȴ�
-- �ذ����� �ڽ� ���ڵ带 ���� ������ �� �θ� ���ڵ� ������ ����
-- ���� ���� �۾�� �״�� ���ִ� �ɼ��� �ٷ� ON DELELTE CASCADE
-- FK���� ������ ������ �� ON DELETE CASCADE �ɼ��� �Բ� �����ؾ��Ѵ�












