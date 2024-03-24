-- Criar database
CREATE DATABASE msuser;

-- Conectar ao database
\c msuser;

CREATE TABLE tb_user (
    id serial PRIMARY KEY,
    name VARCHAR(255) not null,
    birth_date VARCHAR(255) not null,
    cpf BIGINT not null,
    address VARCHAR(255) not null,
    mobile VARCHAR(255) not null,
    email VARCHAR(255) not null
);

INSERT INTO tb_user (name, birth_date, cpf, address, mobile, email)
VALUES ('João', '1990-01-01', 123456789, 'Rua 1', '123456789', 'joao@email.com');