<?php 

/* Informações do Banco de Dados*/
$host = "localhost";
$username = "fronche2_admin";
$password = "adminadmin";
$database = "fronche2_engsoftware";
$table = "Funcionario";

/* Autenticação */
mysql_connect("$host","$username","$password") or die ("Impossível conectar!");
mysql_select_db("$database") or die ("Database inválida. Tente novamente.");

$field_username = $_POST['field_user'];
$field_password = $_POST['field_password'];

$field_username = stripslashes($field_username);
$field_password = stripslashes($field_password);
$field_username = mysql_real_escape_string($field_username);
$field_password = mysql_real_escape_string($field_password);

$mysql_code = "SELECT * FROM $table WHERE ID_Funcionario = '$field_username' AND Senha = '$field_password'";
$query = mysql_query($mysql_code);

 
$number_of_results = mysql_num_rows($query);

if ($number_of_results > 0) {
		session_register("field_username");
		session_register("field_password");
		//header("location:login_success.php");
		echo "LOGOU PORRA!";
}

else {
	echo "Login incorreto! Tente novamente!";
}

?>
