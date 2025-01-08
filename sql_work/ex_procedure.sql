delimiter //
create procedure dorepeat(p1 int)
begin 
	set @x = 0;
	repeat set @x = @x + 1;
    until @x > p1 end repeat;
end //

call dorepeat(1000);

select @x;

delimiter //
create procedure InsertBook(
IN mybookid int,
IN mybookname varchar(40),
IN mypublisher varchar(40),
IN myprice int)
begin
	insert into book(bookid, bookname, publisher, price)
		values(mybookid, mybookname, mypublisher, myprice);
end //

call insertbook(13, '스포츠과학', '마당과학서적', 25000);

select * from book;

delimiter //
create procedure bookinsertorupdate(
	mybookid int,
    mybookname varchar(40),
    mypublisher varchar(40),
    myprice int
)
begin
	declare mycount int;
SELECT 
    COUNT(*)
INTO mycount FROM
    book
WHERE
    bookname LIKE mybookname;
	if mycount!=0 then
		set sql_safe_updates = 0; -- delete, update 연산에 필요한 설정문
UPDATE book SET price = myprice
	where bookname like mybookname;
	else
		insert into book(bookid, bookname, publisher, price)
			values(mybookid, mybookname, mypublisher, myprice);
	end if;
end //

-- BookInsertOrUpdate 프로시저를 실행하여 테스트하는 부분
call BookInsertOrUpdate(15, '스포츠즐거움', '마당과학서적', 25000);
select * from book; -- 15번 투플 삽입 결과 확인
-- BookInsertOrUpdate 프로시저를 실행하여 테스트하는 부분
call BookInsertOrUpdate(15, '스포츠즐거움', '마당과학서적', 20000);
select * from book;

delimiter //
create procedure Averageprice (
	out AverageVal int)
begin
	select avg(price) into AverageVal
	from book where price is not null;
end //

-- 포로시저 Averageprice를 테스트하는 부분
call Averageprice(@myvalue);
select @myvalue;

set global log_bin_trust_function_creators=on;

create table book_log(
	bookid_l int,
    bookname_l varchar(40),
    publisher_l varchar(40),
    price_l int
);

delimiter //
create trigger AfterInsertBook
	after insert on book for each row
begin
	declare average int;
	insert into book_log
    values(new.bookid, new.bookname, new.publisher, new.price);
end //

-- 삽입한 내용을 기록하는 트리거 확인
insert into book values(14, '스포츠과학', '이상미디어', 25000);
select * from book where bookid = 14;
select * from book_log where bookid_l = '14'; -- 결과 확인

