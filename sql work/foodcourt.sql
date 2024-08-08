

create table corner(
	corner_id int primary key,
    corner_name varchar(20) not null
);

create table menu(
	corner_id int not null,
	menu_id int not null,
    menu_name varchar(20) not null,
    menu_price int not null,
    foreign key (corner_id) references corner(corner_id),
    primary key(menu_id, corner_id)
);

create table orders(
	order_id int not null,
    menu_id int not null,
    corner_id int not null,
    status char(1) not null default '0'
);