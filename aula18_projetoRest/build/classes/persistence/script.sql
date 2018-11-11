drop database if exists integracao;

create database integracao;

use integracao;

create table usuario (id int primary key auto_increment, login varchar(50) unique, senha varchar(255));

insert into usuario values (null, 'lu@gmail.com', '123');
insert into usuario values (null, 'liv@gmail.com', '123');
insert into usuario values (null, 'belem@gmail.com', '123');
insert into usuario values (null, 'beira@gmail.com', '123');

select * from usuario;