Gabriel Rodrigues Rossik - 075753
João Gabriel Barros Rodrigues - 075788

# API de Login — Node.js + MySQL

Sistema de autenticação com sessões, proteção contra SQL Injection e criptografia SHA-256.

## Pré-requisitos

- Node.js instalado
- XAMPP com Apache e MySQL ativos

## Configurar o Banco de Dados

Abra o phpMyAdmin (http://localhost/phpmyadmin), vá na aba SQL e execute:

    CREATE DATABASE IF NOT EXISTS nodelogin;
    USE nodelogin;

    CREATE TABLE IF NOT EXISTS accounts (
        id       INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50)  NOT NULL,
        password VARCHAR(255) NOT NULL,
        email    VARCHAR(100) NOT NULL
    );

    INSERT INTO accounts (username, password, email)
    VALUES ('teste', SHA2('teste', 256), 'teste@exemplo.com');

---

## Instalar Dependências

Abra o terminal na raiz do projeto e execute:

    npm install express
    npm install express-session
    npm install mysql

---

## Rodar o Projeto

    node login.js

Acesse no navegador: http://localhost:1234

---

## Credenciais de Teste

    Usuário: teste
    Senha:   teste


