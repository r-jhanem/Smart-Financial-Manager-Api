<?php

include("config.php");
$UserName = strip_tags(trim($_POST["name"]));
$so="نعم";
//$UserName="h";
$All_Users = array();
//$result = "SELECT    MIN(sol),max(sum_sol),COUNT(name)
//FROM Users WHERE  name LIKE '$UserName'";


$result = "SELECT  authorities.id_autss as id , authorities.aut_name  as name FROM  authorities";

$result_Users = $conn->query($result);
		while($rows = $result_Users->fetch_assoc()) {	

	        $All_Users[] = $rows;	        
	    }
              		      
 $json_re=array();
	array_push($json_re,array("All_Users"=>$All_Users));
	echo json_encode($json_re);

mysqli_close($conn);
?>