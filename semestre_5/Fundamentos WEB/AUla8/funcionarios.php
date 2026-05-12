<?php

    // CREDENCIAIS
    $servidor = "127.0.0.1";
    $usuario = "root";
    $senha = "";

    $conexao = new mysqli($servidor, $usuario, $senha);

    if ($conexao->connect_error) {
        die("Erro na conexao: " . $conexao->connect_error . "\n");
    } else {
        echo "Conectado ao banco de dados\n";
    }

    // CRIAR BANCO
    $database = "aula_web";
    $sql_create_database = "CREATE DATABASE IF NOT EXISTS $database";

    if ($conexao->query($sql_create_database) == true) {
        echo "Banco " . $database . " criado com sucesso\n";
    } else {
        die("Erro ao criar database " . $database . "\n");
    }

    $conexao->select_db($database);

    // CRIAR TABELA FUNCOES
    $sql_create_funcoes = "
        CREATE TABLE IF NOT EXISTS funcoes (
            id INT AUTO_INCREMENT PRIMARY KEY,
            descricao VARCHAR(100) NOT NULL
        )
    ";

    if ($conexao->query($sql_create_funcoes) == true) {
        echo "Tabela 'funcoes' criada com sucesso\n";
    } else {
        die("Erro ao criar tabela 'funcoes'\n");
    }

    // CRIAR TABELA FUNCIONARIOS
    $sql_create_funcionarios = "
        CREATE TABLE IF NOT EXISTS funcionarios (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            id_funcao INT NOT NULL,
            FOREIGN KEY (id_funcao) REFERENCES funcoes(id)
        )
    ";

    if ($conexao->query($sql_create_funcionarios) == true) {
        echo "Tabela 'funcionarios' criada com sucesso\n";
    } else {
        die("Erro ao criar tabela 'funcionarios'\n");
    }

    // INSERT FUNCOES
    $funcoes = ["Desenvolvedor", "Gerente", "Designer"];

    $sql_insert_funcao = "INSERT INTO funcoes (descricao) VALUES (?)";
    $stm_funcao = $conexao->prepare($sql_insert_funcao);

    foreach ($funcoes as $descricao) {
        $stm_funcao->bind_param("s", $descricao);
        if ($stm_funcao->execute()) {
            echo "Funcao '" . $descricao . "' inserida com sucesso\n";
        } else {
            die("Erro ao inserir funcao '" . $descricao . "'\n");
        }
    }

    // INSERT FUNCIONARIOS
    $funcionarios = [
        ["Joao",    1],
        ["Maria",   2],
        ["Carlos",  3]
    ];

    $sql_insert_funcionario = "INSERT INTO funcionarios (nome, id_funcao) VALUES (?, ?)";
    $stm_funcionario = $conexao->prepare($sql_insert_funcionario);

    foreach ($funcionarios as $func) {
        $stm_funcionario->bind_param("si", $func[0], $func[1]);
        if ($stm_funcionario->execute()) {
            echo "Funcionario '" . $func[0] . "' inserido com sucesso\n";
        } else {
            die("Erro ao inserir funcionario '" . $func[0] . "'\n");
        }
    }

    // FUNÇÃO: busca funcionario e exibe sua funcao
    function buscarFuncaoFuncionario($nome) {
        global $conexao;

        $sql_funcionario = "SELECT nome, id_funcao FROM funcionarios WHERE nome = ?";
        $stm = $conexao->prepare($sql_funcionario);
        $stm->bind_param("s", $nome);
        $stm->execute();
        $resultado_funcionario = $stm->get_result();

        if ($resultado_funcionario->num_rows == 0) {
            echo "Funcionario '" . $nome . "' nao encontrado.\n";
            return;
        }

        $funcionario = $resultado_funcionario->fetch_assoc();
        $id_funcao   = $funcionario["id_funcao"];
        $nome_real   = $funcionario["nome"];

        $sql_funcao = "SELECT descricao FROM funcoes WHERE id = ?";
        $stm2 = $conexao->prepare($sql_funcao);
        $stm2->bind_param("i", $id_funcao);
        $stm2->execute();
        $resultado_funcao = $stm2->get_result();

        if ($resultado_funcao->num_rows == 0) {
            echo "Funcao do funcionario '" . $nome . "' nao encontrada.\n";
            return;
        }

        $funcao = $resultado_funcao->fetch_assoc();
        $descricao = $funcao["descricao"];

        echo "Funcionario " . $nome_real . " tem a funcao " . $descricao . "\n";
    }

    // CHAMADA DA FUNÇÃO
    echo "\nResultado\n\n";
    buscarFuncaoFuncionario("Joao");
    buscarFuncaoFuncionario("Maria");
    buscarFuncaoFuncionario("Carlos");

?>
