drop database if exists bdserv;

create database bdserv;

use bdserv;

create table produto (id int primary key auto_increment, nome varchar(50) unique, marca varchar (50), preco double, promocao double);

	insert into produto values(null, 'iphone 1', 'apple', 200, 50);
	insert into produto values(null, 'galaxy', 'samsung', 170, 70);
	insert into produto values(null, 'radio', 'nextel', 80, 70);
	insert into produto values(null, 'ipad', 'apple', 400, 300);
	insert into produto values(null, 'iphone 8', 'apple', 4500, 0);
commit;

select * from produto;
