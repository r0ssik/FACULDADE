<?php 

//função
function create_connection(){
    $configs = parse_ini_file(".env");

    $user = $configs["DB_USER"];
    $password = $configs["DB_PASSWORD"];
    $host = $configs["DB_HOST1"];
    $database = $configs["DB_NAME"];

    $connection = new mysqli(
        $host,
        $user,
        $password,
        $database
    );

    if($connection->connect_error){
        die("Erro na conexão: ". $connection->connect_error);
        echo "Erro\n";
    }
    echo "Sucesso\n";
    return $connection;
}

create_connection();

?>