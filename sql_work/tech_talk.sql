# 1. 사용자는 게시글을 작성, 수정, 삭제할 수 있어야 한다.
# 2. 게시글은 제목, 내용, 작성자, 작성일, 수정일 정보를 포함해야 한다.
# 3. 사용자는 게시글에 댓글을 달 수 있어야 한다.

create database TechTalk;
use TechTalk;

create table user(
u_idx int auto_increment primary key,
name varchar(50) not null,
email varchar(50) not null,
password varchar(50) not null,
phone varchar(50)
);

create table board(
f_idx int auto_increment primary key,
title varchar(50) not null,
content varchar(255) not null,
created_at datetime not null,
updated_at datetime not null);

create table comment(
c_idx int auto_increment primary key,
);