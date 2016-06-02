<?php

/* Informações do Banco de Dados*/
$host = "localhost";
$username = "fronche2_admin";
$password = "adminadmin";
$database = "fronche2_engsoftware";
$table = "Gastos";


/* Autenticação */
$link = mysql_connect("$host","$username","$password") or die ("Impossível conectar!");
mysql_select_db("$database") or die ("Database inválida. Tente novamente."); 
 
/* Dados à serem resgatados do HTML (Gastos) */
$descricao = mysqli_real_escape_string($link, $_POST['descricao_gasto']);
$tipo = mysqli_real_escape_string($link, $_POST['tipo_gasto']);
$valor = mysqli_real_escape_string($link, $_POST['valor_gasto']);

/* Inserindo imagem */
$upload_image=$_FILES[" myimage "][ "name" ];
$folder="/fotos";
move_uploaded_file($_FILES[" myimage "][" tmp_name "], "$folder".$_FILES[" myimage "][" name "]);

/* Execução do SQL */
$query = "INSERT INTO '$table' (DescricaoGastos, TipoGasto, ValorGasto) VALUES ('$descricao', '$tipo', '$valor', '$upload_image')";

if(mysqli_query($link, $query)){
    echo "Valores adicionados com sucesso.";
} else{
    echo "Impossível executar a função requerida :(!" . mysqli_error($link);
}
 
mysqli_close($link);
?>
