create database green;

use green;

create table MEMBERS(
member_id int auto_increment primary key,
name varchar(50),
email varchar(50),
phone varchar(50),
create_at datetime,
updated_at datetime
);

insert into members(member_id, name, email, phone)
values (1, '홍길동', 'aaa@naver.com', '010-1234-1234');

delete from members where member_id = 1;

insert into members(member_id, name, email, phone, create_at, updated_at)
values (1, '홍길동', 'aaa@naver.com', '010-1234-1234', date(now()), date(now()));

select * from members where member_id = 1;

update members set name = '이승용' where name like '홍길동';

insert into members(name, email, phone, create_at, updated_at)
values ('이길동', 'bbb@naver.com', '010-1234-2345', date(now()), date(now()));

insert into members(name, email, phone, create_at, updated_at)
values ('김길동', 'ccc@naver.com', '010-1234-3456', date(now()), date(now()));

insert into members(name, email, phone, create_at, updated_at)
values ('박길동', 'ddd@naver.com', '010-1234-4567', date(now()), date(now()));

select * from members;

delete from members where member_id = 2;