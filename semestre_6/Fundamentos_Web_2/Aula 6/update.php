<?php 
require "connection.php";

function update_sql($id, $nome, $genero, $ano){
    $conexao = create_connection();

    $sql = "UPDATE `filmes` SET `nome`= ?,`genero`= ?,`ano`=? WHERE id = ?";

    $stmt = $conexao->prepare($sql);
    $stmt->bind_param("ssii", $nome, $genero, $ano, $id);

    if ($stmt->execute()){
        echo "Filme Editado!\n";
    } else{
        echo "Erro\n";
    }
}
update_sql(3, "Homem Aranha", "Fantasia", 2005);
?>