CREATE SEQUENCE seq_member
START WITH 1
INCREMENT BY 1;

CREATE TABLE member
(
id number primary key,
name varchar2(20),
email varchar2(30),
phone varchar2(30)
);

INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'A', 'a@gmail.com', 'aaa-aaaa');


INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'B', 'b@gmail.com', 'bbb-bbbb');
INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'C', 'c@gmail.com', 'ccc-cccc');
INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'D', 'd@gmail.com', 'ddd-dddd');
INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'E', 'e@gmail.com', 'eee-eeee');
INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'F', 'f@gmail.com', 'fff-ffff');
INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, 'G', 'g@gmail.com', 'ggg-gggg');

DELETE member WHERE id = 100;

SELECT *  FROM member;
SELECT * FROM member
SELECT ora_seq.nextVal FROM member;

SELECT seq_member.nextVal FROM member;

commit;