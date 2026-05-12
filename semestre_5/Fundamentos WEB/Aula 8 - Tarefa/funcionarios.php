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

    function criarBanco($conexao) {
        $database = "aula_web";
        $sql = "CREATE DATABASE IF NOT EXISTS $database";

        if ($conexao->query($sql) == true) {
            echo "Banco '$database' criado com sucesso\n";
        } else {
            die("Erro ao criar database '$database'\n");
        }

        $conexao->select_db($database);
    }

    function criarTabelas($conexao) {
        $sql_funcoes = "
            CREATE TABLE IF NOT EXISTS funcoes (
                id INT AUTO_INCREMENT PRIMARY KEY,
                descricao VARCHAR(100) NOT NULL
            )
        ";

        if ($conexao->query($sql_funcoes) == true) {
            echo "Tabela 'funcoes' criada com sucesso\n";
        } else {
            die("Erro ao criar tabela 'funcoes'\n");
        }

        $sql_funcionarios = "
            CREATE TABLE IF NOT EXISTS funcionarios (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                id_funcao INT NOT NULL,
                FOREIGN KEY (id_funcao) REFERENCES funcoes(id)
            )
        ";

        if ($conexao->query($sql_funcionarios) == true) {
            echo "Tabela 'funcionarios' criada com sucesso\n";
        } else {
            die("Erro ao criar tabela 'funcionarios'\n");
        }
    }

    function inserirDados($conexao) {
        $funcoes = ["Desenvolvedor", "Gerente", "Designer"];
        $stm_funcao = $conexao->prepare("INSERT INTO funcoes (descricao) VALUES (?)");

        foreach ($funcoes as $descricao) {
            $stm_funcao->bind_param("s", $descricao);
            if ($stm_funcao->execute()) {
                echo "Funcao '$descricao' inserida com sucesso\n";
            } else {
                die("Erro ao inserir funcao '$descricao'\n");
            }
        }

        $funcionarios = [
            ["Joao",   1],
            ["Maria",  2],
            ["Carlos", 3]
        ];
        $stm_func = $conexao->prepare("INSERT INTO funcionarios (nome, id_funcao) VALUES (?, ?)");

        foreach ($funcionarios as $func) {
            $stm_func->bind_param("si", $func[0], $func[1]);
            if ($stm_func->execute()) {
                echo "Funcionario '{$func[0]}' inserido com sucesso\n";
            } else {
                die("Erro ao inserir funcionario '{$func[0]}'\n");
            }
        }
    }

    function buscarFuncaoFuncionario($conexao, $nome) {
        $stm = $conexao->prepare("SELECT nome, id_funcao FROM funcionarios WHERE nome = ?");
        $stm->bind_param("s", $nome);
        $stm->execute();
        $resultado = $stm->get_result();

        if ($resultado->num_rows == 0) {
            echo "Funcionario '$nome' nao encontrado.\n";
            return;
        }

        $funcionario = $resultado->fetch_assoc();
        $id_funcao   = $funcionario["id_funcao"];
        $nome_real   = $funcionario["nome"];

        $stm2 = $conexao->prepare("SELECT descricao FROM funcoes WHERE id = ?");
        $stm2->bind_param("i", $id_funcao);
        $stm2->execute();
        $resultado_funcao = $stm2->get_result();

        if ($resultado_funcao->num_rows == 0) {
            echo "Funcao do funcionario '$nome' nao encontrada.\n";
            return;
        }

        $funcao = $resultado_funcao->fetch_assoc();
        echo "Funcionario " . $nome_real . " tem a funcao " . $funcao["descricao"] . "\n";
    }

    // CHAMADAS
    criarBanco($conexao);
    criarTabelas($conexao);
    inserirDados($conexao);

    echo "\n--- Resultado ---\n";
    buscarFuncaoFuncionario($conexao, "Joao");
    buscarFuncaoFuncionario($conexao, "Maria");
    buscarFuncaoFuncionario($conexao, "Carlos");

?>
