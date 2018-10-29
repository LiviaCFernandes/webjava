--oracle express (é o atalho do oracle)

conn system/coti
--conectando como DBA

create user alunoti identified by coti
default tablespace users
quota 20m on users;

grant create user, create session, create table, create procedure, create view, create sequence to alunoti;

conn alunoti/coti

drop table usuario;
drop sequence seq_usuario;

create table usuario(id number(5) primary key, nome varchar2(50) not null, email varchar2(80) not null unique, ativo number(2));

create sequence seq_usuario; --é o auto_increment

insert into usuario values (seq_usuario.nextval, 'lu', 'lucianamedeiros.coti@gmail.com', 0);
insert into usuario values (seq_usuario.nextval, 'belem', 'profedsonbelem@gmail.com', 0);
insert into usuario values (seq_usuario.nextval, 'liv', 'liviacfernandes@hotmail.com', 0);
commit;

column nome format a15;
column email format a35;
set linesize 4000;
set pagesize 2000;
select * from usuario;
select * from cat;


