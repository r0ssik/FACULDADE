<?php 
require "connection.php";

function read_sql(){
    $conexao = create_connection();

    $sql = "SELECT * from filmes";
    $result = $conexao->query($sql);

    while ($filmes = $result->fetch_assoc()){
        echo "######\n";
        echo "ID: " . $filmes["id"] . "\n";
        echo "NOME: " . $filmes["nome"] . "\n";
        echo "GENERO: " . $filmes["genero"] . "\n";
        echo "ANO: " . $filmes["ano"] . "\n";
    }
    
}
read_sql();
?>