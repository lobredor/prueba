CREATE DATABASE prueba
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE estudiantes(
    id serial primary key,
    identificacion varchar(30) not null,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    edad int not null,
    carrera varchar(30) not null
);