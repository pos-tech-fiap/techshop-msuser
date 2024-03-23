-- Criar database
-- CREATE DATABASE techshop;

-- Conectar ao database
\c techshop;

CREATE TABLE tb_user (
                            id BIGINT PRIMARY KEY,
                            name VARCHAR(255) not null,
                            birthDate VARCHAR(255) not null,
                            cpf BIGINT not null,
                            value double precision not null
);