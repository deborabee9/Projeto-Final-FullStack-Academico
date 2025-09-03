-- Database: jpa

-- DROP DATABASE IF EXISTS jpa;

CREATE DATABASE jpa;

-- Apaga todas as Tabelas
DROP TABLE IF EXISTS aluno_curso;
DROP TABLE IF EXISTS aluno;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS disciplina;

-- Table: aluno
CREATE TABLE IF NOT EXISTS aluno
(
    idaluno SERIAL,
    nome character varying(80) NOT NULL,
    sexo character varying(30) NOT NULL,
    dt_nasc date NOT NULL,
    PRIMARY KEY (idaluno)
    );

-- Table: curso
CREATE TABLE IF NOT EXISTS curso
(
    idcurso SERIAL,
    nomecurso character varying(100) NOT NULL,
    PRIMARY KEY (idcurso)
    );

-- Table: aluno_curso
CREATE TABLE IF NOT EXISTS aluno_curso
(
    idcurso integer NOT NULL,
    idaluno integer NOT NULL,
    FOREIGN KEY (idaluno) REFERENCES public.aluno (idaluno),
    FOREIGN KEY (idcurso) REFERENCES public.curso (idcurso)
    );

-- Insere os registros dos alunos
INSERT INTO aluno(nome, sexo, dt_nasc)
VALUES ('Maria','Feminino' ,'2010-01-03'),
       ('João' ,'Masculino','2020-10-30'),
       ('Pedro','Masculino','1998-12-08'),
       ('José' ,'Masculino','2005-06-01'),
       ('Ana'  ,'Feminino' ,'1976-08-12'),
       ('Carol','Feminino' ,'1995-11-21');

-- Insere os registros dos cursos
INSERT INTO curso(nomecurso)
VALUES ('Banco de Dados'    ),
       ('Estrutura de Dados'),
       ('Programação Web'   );

-- Insere os registros da relação entre aluno e curso
INSERT INTO aluno_curso(idcurso, idaluno)
VALUES (1,1),
       (1,2),
       (2,3),
       (2,4),
       (3,5),
       (3,6);