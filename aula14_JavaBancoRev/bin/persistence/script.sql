#1p1
#tabela produto (id,nome,preco)
#tabela estoque (idEstoque,quantidade,idProduto)
#inserir 5 itens cada
#reduzir a quantidade do produto menor 10, trigger
#imprimir mensagem estoque minimo

create database revisao1;

use revisao1;

create table produto (id int primary key auto_increment, nome varchar(50), preco float);
create table estoque (idEstoque int primary key auto_increment, quantidade int, id_produto int, foreign key(id_produto) references produto(id));

insert into produto values (null, 'iphone', '3500');
insert into produto values (null, 'zenfone', '1500');
insert into produto values (null, 'motorola', '1200');
insert into produto values (null, 'samsung', '1400');
insert into produto values (null, 'lg', '1000');
--insert into produto values (null, 'lenovo', '800');
--insert into produto values (null, 'china', '200');

drop trigger if exists gatilho1;
delimiter $
create trigger gatilho1 
before insert on estoque
for each row
begin
set @qtd = new.quantidade;
	if @qtd < 10 then
		signal sqlstate '20000' set MESSAGE_TEXT = 'Quantidade menor que 10';
	end if;
end; 
$
delimiter ;

select @qtd;

insert into estoque values (null, '10', '1');
insert into estoque values (null, '20', '2');
insert into estoque values (null, '22', '3');
insert into estoque values (null, '25', '4');
insert into estoque values (null, '8', '5'); #nao vai inserir pq o trigger bloqueia
insert into estoque values (null, '14', '6');
--insert into estoque values (null, '13', id_produto = (SELECT id FROM produto WHERE nome = 'china');


create view v$produtoEstoque as select id, nome, preco, idestoque, quantidade 
			from produto p inner join estoque e on p.id=e.id_produto;

select * from v$produtoEstoque;
---------

set @error='';
--mensagem para aparecer quando a quantidade for menor que o estoque deixa!
create table test(id int primary key, quantidade int);
--drop procedure gravar;
delimiter $
create procedure gravar(idestoque int, quantidade int)
begin
	set @qtd = quantidade;
	if (@qtd<10) then
		set @error='Estoque minimo: Quantidade abaixo de 10!';
	    else
	    set @error='Estoque no limite.';
	end if;
end 
$
delimiter ;

call gravar(1000,5);
select @error;

--
--drop trigger if exists gatilho4;
create trigger gatilho10 
   after insert  on test
   for each row 
   	call gravar(new.id, new.quantidade);

insert into test values (200,9);
select @error;



