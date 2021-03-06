/*
CREATE TABLE person (
id integer  not null,
name varchar (255) not null,
location varchar (255),
birth_date timestamp,
primary key(id)
);*/
INSERT INTO PERSON(ID,NAME,LOCATION,birth_date)
VALUES (10001,'Omar Barboza','Lima Perú',CURRENT_TIMESTAMP );
INSERT INTO PERSON(ID,NAME,LOCATION,birth_date)
VALUES (10002,'Alan Barboza','Río Brasil',CURRENT_TIMESTAMP );
INSERT INTO PERSON(ID,NAME,LOCATION,birth_date)
VALUES (10003,'Reanio Barboza','Surco Perú',CURRENT_TIMESTAMP );


insert into course(id,name,created_date,last_updated_date,is_deleted)
values (10001,'JPA in 50 steps',sysdate(),sysdate(),false);
insert into course(id,name,created_date,last_updated_date,is_deleted)
values (10002,'Spring Boot 2 in action',sysdate(),sysdate(),false);
insert into course(id,name,created_date,last_updated_date,is_deleted)
values (10003,'JUnit for developers',sysdate(),sysdate(),false);

/*
insert into course(id,name,created_date,last_updated_date)
values (10004,'Dummy1',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date)
values (10005,'Dummy2',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date)
values (10006,'Dummy3',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date)
values (10007,'Dummy4',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date)
values (10008,'Dummy5',sysdate(),sysdate());
 */

insert into passport(id,number)
values (40001,'E123456');
insert into passport(id,number)
values (40002,'N123457');
insert into passport(id,number)
values (40003,'L123890');

insert into student(id,name,passport_id)
values (20001,'Ranga',40001);
insert into student(id,name,passport_id)
values (20002,'Adam',40002);
insert into student(id,name,passport_id)
values (20003,'Jane',40003);



insert into review(id,rating, description,course_id)
values (50001,'FOUR','Great course',10001);
insert into review(id,rating, description,course_id)
values (50002,'THREE','Wonderful course',10001);
insert into review(id,rating, description,course_id)
values (50003,'FIVE','a course',10003);

insert into student_course (student_id,course_id)
values (20001,10001);
insert into student_course (student_id,course_id)
values (20002,10001);
insert into student_course (student_id,course_id)
values (20003,10001);
insert into student_course (student_id,course_id)
values (20001,10003);





