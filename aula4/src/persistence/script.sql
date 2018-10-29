create database bddb;

use bddb;

create table aluno (idAluno int primary key, nome varchar (50), email varchar (50) unique);

create table disciplina (idDisciplina int primary key, nomeDisciplina varchar (50));

create table curso (idCurso int, id_aluno int, id_disciplina int,
	primary key(idCurso, id_aluno, id_disciplina), data date, nota1 double,
	nota2 double, foreign key(id_aluno) references aluno(idAluno) on delete cascade,
	foreign key(id_disciplina) references disciplina(idDisciplina) on delete cascade);
	
insert into aluno values (10, 'alan', 'alan@gmail.com');
insert into disciplina values (20, 'java');

insert into curso values (40, 10, 20, now(),8,7);

select*from aluno;
select*from disciplina;
select*from curso;