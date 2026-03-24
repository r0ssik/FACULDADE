
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


INSERT INTO accounts (username, password, email)
VALUES ('joao', SHA2('senha123', 256), 'joao@exemplo.com');