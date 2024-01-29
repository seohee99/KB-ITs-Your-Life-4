create table card
       (card_id varchar(255) primary key,
       expire_date date,
       company_name varchar(255),
       cust_grade varchar(255));

create table cust
       (ssn varchar(255) primary key,
       cust_name varchar(255),
       cust_address varchar(255),
       phone varchar(255));

create table purchase
       (id number primary key,
       ssn varchar(255),
       card_id varchar(255),
       day date,
       price number,
       company_name varchar(255),
       category varchar(255));

drop table purchase;
drop table card;
drop table cust;
//drop table company;

//ALTER TABLE card ADD CONSTRAINT fk_card_company_name foreign key(company_name) references company(company_name) ON DELETE CASCADE;

ALTER TABLE purchase ADD CONSTRAINT fk_purchase_cust_id foreign key(ssn) references cust(ssn) ON DELETE CASCADE;
ALTER TABLE purchase ADD CONSTRAINT fk_purchase_card_id foreign key(card_id) references card(card_id) ON DELETE CASCADE;

CREATE SEQUENCE seq_purchase
START WITH 1
INCREMENT BY 1;

truncate table card;
truncate table purchase;

truncate table cust;
--INSERT INTO company VALUES ('»ï¼º','aaa');
--INSERT INTO company VALUES ('·Ôµ¥','bbb');
--select * from company;

INSERT INTO cust VALUES ('mesh153','Á¶¿øÇü','23/01/23','01036493276');
INSERT INTO cust VALUES ('aaddee','±è°Ç¸ð','23/01/20','0102223333');
INSERT INTO cust VALUES ('bbccdd','¹Ì¹Ì¹Ì','23/12/02','0103332221');
INSERT INTO cust VALUES ('ffddww','¸ð¸ð¸ð','23/01/23','40599493');
select * from cust;

INSERT INTO card (card_id, expire_date, company_name) VALUES ('999-999-999','29/01/23','»ï¼º');
INSERT INTO card (card_id, expire_date, company_name) VALUES ('999-999-900','30/01/23','»ï¼º');
INSERT INTO card (card_id, expire_date, company_name) VALUES ('999-999-998','29/08/23','·Ôµ¥');


INSERT INTO card (card_id, expire_date, company_name) VALUES ('888-888-888','33/01/23','·Ôµ¥');
INSERT INTO card (card_id, expire_date, company_name) VALUES ('888-888-887','33/01/25','»ï¼º');
select * from card;

INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/23', 302000, '»ï¼º', '±³Åë');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/25', 34200, '»ï¼º', 'ºäÆ¼');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/27', 25000, '»ï¼º', '½Ä»ç');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-900', '23/08/27', 100000, '»ï¼º', 'µµ¼­');



INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'aaddee', '888-888-888', '25/07/27', 300000, '·Ôµ¥', 'ºäÆ¼');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'aaddee', '888-888-887', '25/08/04', 12000, '»ï¼º', '½Ä»ç');

select * from cust;
select * from purchase;
select ssn, card_id, price from purchase where  company_name = '»ï¼º';

commit;


// check grade -> 
SELECT  card_id, LTRIM(TO_CHAR( sum(price) , '999,999,999,999,999')), company_name ,
CASE WHEN sum(price) > 500000 THEN 'ÇÃ·¡Æ¼³Ñ'
            WHEN sum(price) BETWEEN 300000 AND 500000  THEN '°ñµå'
             WHEN sum(price) BETWEEN 100000 AND 30000  THEN '½Ç¹ö'
             ELSE 'ºê·ÐÁî' END AS GRADE,
             DENSE_RANK() OVER (ORDER BY sum(price) DESC) ¼øÀ§
FROM purchase
where company_name = '»ï¼º' 
group by company_name, card_id;


SELECT count(*) 
FROM (

SELECT    card_id,sum(price), company_name, 
CASE WHEN sum(price) > 500000 THEN 'ÇÃ·¡Æ¼³Ñ'
            WHEN sum(price) BETWEEN 300000 AND 500000  THEN '°ñµå'
             WHEN sum(price) BETWEEN 100000 AND 30000  THEN '½Ç¹ö'
             ELSE 'ºê·ÐÁî' END AS GRADE,
             DENSE_RANK() OVER (ORDER BY sum(price) DESC) ¼øÀ§
FROM purchase
where company_name = '»ï¼º'  
group by company_name, card_id)

WHERE GRADE = 'ºê·ÐÁî';




SELECT card_id, TO_CHAR( sum(price) , '999,999,999,999,999') ÃÑ¾×, company_name,  CASE WHEN sum(price) > 500000 THEN 'ÇÃ·¡Æ¼³Ñ'WHEN sum(price) BETWEEN 300000 AND 500000  THEN '°ñµå'WHEN sum(price) BETWEEN 100000 AND 30000  THEN '½Ç¹ö' ELSE 'ºê·ÐÁî' END AS GRADE,DENSE_RANK() OVER (ORDER BY sum(price) DESC) ¼øÀ§ FROM purchase where company_name =? AND  ssn =? 
group by company_name,card_id;


update card set card_grade =? where card_id=?
















