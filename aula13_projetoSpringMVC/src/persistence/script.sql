drop database if exists bdspring;
create database bdspring;

use bdspring;

create table usuario(id int primary key auto_increment, nome varchar(50), email varchar(50) unique, senha varchar(255));

