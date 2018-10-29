drop database if exists BD01;

create database BD01;

use BD01;

create table usuario (idUsuario int primary key auto_increment, nome varchar(50) not null, 
						email varchar(50) not null unique);
create table endereco (idEndereco int primary key auto_increment, logradouro varchar(50), bairro varchar(50), 
						cidade varchar(50), estado varchar(2), cep varchar(50), id_Usuario int,
						foreign key(id_Usuario) references usuario(idUsuario) on delete cascade);
						
create or replace view V$UsuarioEndereco as select idUsuario, nome, email, idEndereco, logradouro, bairro, cidade,
						estado, cep from usuario u inner join endereco e on u.idUsuario=e.id_Usuario;

insert into usuario values (10, 'lu', 'lu@gmail.com');
insert into endereco values (200, 'Av Rio Branco, 185', 'centro', 'Rio de Janeiro', 'RJ', '2004007', 10);

select * from V$UsuarioEndereco;
select nome,bairro from V$UsuarioEndereco;

drop procedure if exists mostrarViewCodigo;
delimiter $$ --muda o comando/estado do fim--
create procedure mostraViewCodigo(vcod int)
begin
	select * from V$UsuarioEndereco where idUsuario=vcod;
end;
$$
delimiter ;

call mostraViewCodigo(10);

