<?php

include("config.php");
$UserName=strip_tags(trim($_POST["name"]));
//$UserName="php_branchess";
        
//$md5Pass = md5($PassWord); 

$All_Users = array();




//$result = "SELECT * FROM Users where name ='gg'" ;

switch($UserName)
{
	case"php_branchess":

		{

		$id = strip_tags(trim($_POST["id"]));

			$result = "SELECT branchess.id as   id,  branchess.br_name as name  FROM  branchess";

			break;

		}

		case"php_branchess_id":

			{


			
				
			$id = strip_tags(trim($_POST["id"]));
				$result = "SELECT branchess.id as   id,  branchess.br_name as name  FROM  branchess WHERE branchess.id_auth='$id'";
	
				break;
				
			}
		}
$result_Users = $conn->query($result);
		while($rows = $result_Users->fetch_assoc()) {			 
	        $All_Users[] = $rows;	        
	    }
              		      
 $json_re=array();

  header('Content-Type: application/json');

	array_push($json_re,array("All_Users"=>$All_Users));
	echo json_encode($json_re);

mysqli_close($conn);
?>