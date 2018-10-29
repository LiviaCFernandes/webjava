drop database if exists web2;

create database web2;

use web2;

create table usuario(id int primary key auto_increment, nome varchar(50) not null, email varchar(80) not null unique, ativo int);
	
	insert into usuario values (null, 'lu', 'lu@gmail.com',0);

create table telefone(idTelefone int primary key auto_increment, operadora varchar(50), numero varchar(20), id_usuario int, foreign key(id_usuario) references usuario(id) on delete cascade);

	insert into telefone values (null,'tim','99988877', (select last_insert_id()));
	
