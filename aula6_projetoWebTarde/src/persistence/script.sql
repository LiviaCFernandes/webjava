drop database if exists web1;
create database web1;

use web1;

drop table usuario;
create table usuario (id int primary key auto_increment, login varchar(50) unique, senha varchar(255), acesso varchar(15));

	insert into usuario values (null, 'china', md5('123'), 'max');
	insert into usuario values (null, 'rafael', md5('123'), 'min');
	insert into usuario values (null, 'jamal', md5('123'), 'min');

drop table produto;
create table produto (id int primary key auto_increment, nomeProduto varchar(50), preco double);

	insert into produto values (null, '13 cavaleiros', 20);
	insert into produto values (null, 'latin lover', 10);
	insert into produto values (null, 'overboard', 10);
	insert into produto values (null, 'cruzadas', 15);
	insert into produto values (null, '13 legiao', 9);

select * from usuario;
select * from produto;