<?php 
require "connection.php";

function create_sql($nome, $genero, $ano){
    $conexao = create_connection();

    $sql = "INSERT INTO filmes(nome, genero, ano) 
        VALUES (?, ?, ?)";

    $stmt = $conexao->prepare($sql);
    $stmt->bind_param("ssi", $nome, $genero, $ano);

    if ($stmt->execute()){
        echo "Filme inserido!\n";
    } else{
        echo "Erro\n";
    }
}
create_sql("Senhor dos Aneis", "Fantasia", 2005);
?>