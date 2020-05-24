--create database farmer-buddy;
user farmer-buddy;

--create user 'touch'@'localhost' identified by 'touch';
--GRANT ALL PRIVILEGES ON *.* TO 'touch'@'localhost';
drop table users;
create table users(id int primary key auto_increment,
username varchar(20),
pswd varchar(200),
name varchar(60),
first_name varchar(60),
last_name varchar(60),
gender varchar(60),
dob varchar(60),
state varchar(60),
city varchar(60),
email varchar(40),
created_by varchar(60),
crea0000000000ted_date varchar(60)
);

truncate table users;

drop table questions;
create table questions(
    question_id int primary key auto_increment,
    question varchar(200),
    created_date varchar(60),
    created_by varchar(60)  
);

drop table question_attributes;
create table question_attributes(
    attribute_id int ,
    attribute_name varchar(60),
    attribute_value varchar(60),
    question_id int,
    created_date varchar(60),
    created_by varchar(60) 
);

drop table answers;
create table answers(
    answer_id int primary key auto_increment,
    answer varchar(900),
    question_id int,
    created_by varchar(60),
    created_date varchar(60)
);

drop table answer_attributes;
create table answer_attributes(
    attribute_id int ,
    attribute_name varchar(60),
    attribute_value varchar(60),
    answer_id int,
    created_date varchar(60),
    created_by varchar(60) 
);
insert into answers(question_id,answer) values(1,'this is answer  of question 1');

