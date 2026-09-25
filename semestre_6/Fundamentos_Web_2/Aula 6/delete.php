<?php 
require "connection.php";
function delete_sql($id){
    $conexao = create_connection();

    $sql = "DELETE from filmes WHERE id = ?";

    $stmt = $conexao->prepare($sql);
    $stmt->bind_param("i", $id);

    if ($stmt->execute()){
        echo "Filme Deletado!\n";
    } else{
        echo "Erro\n";
    }
    return;
}
delete_sql(2);
?>