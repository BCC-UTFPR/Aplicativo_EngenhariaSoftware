<?php 

/* Informações do Banco de Dados*/
$host = "localhost";
$username = "fronche2_admin";
$password = "adminadmin";
$database = "fronche2_engsoftware";
$table = "Gastos";

/* Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
$link = mysql_connect("$host","$username","$password") or die ("Impossível conectar!");
mysql_select_db("$database") or die ("Database inválida. Tente novamente.");
 
// Escape user inputs for security
$descricao = mysqli_real_escape_string($link, $_POST['descricao']);
 
// attempt insert query execution
$sql = "INSERT INTO persons (DescricaoGastos) VALUES ('$descricao')";
if(mysqli_query($link, $sql)){
    echo "Records added successfully.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// close connection
mysqli_close($link);
?>