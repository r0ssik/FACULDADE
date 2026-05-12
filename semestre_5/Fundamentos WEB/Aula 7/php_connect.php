<?php 

    //DEFINIR CREDENCIAIS
    $servidor = "127.0.0.1";
    $usuario = "root";
    $senha = "";

    $conexao = new mysqli($servidor, $usuario, $senha);

    if ($conexao -> connect_error){
        die("Erro na conexao: " . $conexao->connect_error . " . ");
    } else {
        echo "Conectado ao banco de dados";
    }

    $database = "aula_web";
    $sql_create_database = "CREATE DATABASE IF NOT EXISTS $database";

    if($conexao->query($sql_create_database) == true){
        echo "Banco " . $database . " criado com sucesso";
    } else {
        die("Erro ao criar database" . $database . "\n");
    }

    //Criar Tabela
    $conexao->select_db($database);
    $sql_create_table = "
    CREATE TABLE IF NOT EXISTS aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    )
    ";

    if($conexao->query($sql_create_table) == true){
        echo "Tabela Criada com sucesso";
    } else {
        die("Erro ao criar tabela \n");
    }

    // Insert
    $nome = "Gabriel";
    $email = "gabriel@gabriel";
    
    $sql_insert = "INSERT INTO aluno (nome, email) VALUES (?, ?)";
    $stm = $conexao->prepare($sql_insert);
    $stm -> bind_param("ss", $nome, $email);

    if($stm->execute()){
        echo "Dados inseridos com sucesso";
    } else {
         die("Erro ao inserir dados!\n");
    }

?>