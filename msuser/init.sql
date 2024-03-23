-- Criar database
-- CREATE DATABASE techshop;

-- Conectar ao database
\c techshop;

CREATE TABLE tb_user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) not null,
    birthDate VARCHAR(255) not null,
    cpf BIGINT not null,
    address VARCHAR(255) not null,
    mobile VARCHAR(255) not null,
    email VARCHAR(255) not null,
    value double precision not null
);