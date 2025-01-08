show databases;

use mysql;

show tables;

desc mysql.user;

SELECT * FROM user;

create user Lee@localhost identified by '12345678';

create user LEE@localhost identified by '12345678';

drop user LEE@localhost;

create user mdguest2 identified by 'mdguest2';

grant all privileges on madanguniv.* to Lee@localhost;

flush privileges;

show grants for Lee@localhost;

grant select on madangdb.book to Lee@localhost;
flush privileges;

select * from user;