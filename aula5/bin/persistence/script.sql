drop database if exists bdaula5;
create database if not exists bdaula5;

use bdaula5;

create table usuario (id int primary key auto_increment, nome varchar(50), email varchar (50) unique, perfil varchar(15));

insert into usuario values (null, 'luis', 'luis@gmail.com', 'usu');
insert into usuario values (null, 'rodrigo', 'rodrigo@gmail.com', 'usu');
insert into usuario values (null, 'lu', 'lu@gmail.com', 'adm');

commit;