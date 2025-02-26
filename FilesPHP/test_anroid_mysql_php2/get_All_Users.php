<?php

include("config.php");

$so="نعم";
$All_Users = array();
$All_Users1= array();
$All_Users2 = array();
$All_Users3= array();


$result_auth="SELECT  authorities.id_autss as id_aut , authorities.aut_name  as name_auth FROM  authorities";
$result_br=" SELECT branchess.id as   id_brans,  branchess.br_name as br_name  FROM  branchess";

$result_box=" SELECT  boxes.id_bo as id_bo,boxes.box_name as box_name   FROM boxes";
$result_EMP="SELECT  employesa3.id_em as id_ems , employesa3.name
as namebox_4 FROM  employesa3;";

$result_Users = $conn->query($result_auth);
		while($rows = $result_Users->fetch_assoc()) {			 
	      $All_Users[] = $rows;	        
	    }


		
		$result_Users_2 = $conn->query($result_br);
		while($rows_2 = $result_Users_2->fetch_assoc()) {			 
	        $All_Users1[] = $rows_2;	        
	    }	
		$result_Users = $conn->query($result_box);
		while($rows = $result_Users->fetch_assoc()) {			 
	      $All_Users2[] = $rows;	        
	    }


		
		$result_Users_2 = $conn->query($result_EMP);
		while($rows_2 = $result_Users_2->fetch_assoc()) {			 
	        $All_Users3[] = $rows_2;	        
	    }	

		   
		   
		  /*
		  $result_auth = $conn->prepare("SELECT authorities.id_autss as id_aut, authorities.aut_name as name_auth FROM authorities");
		  $result_br = $conn->prepare("SELECT branchess.id as id_brans, branchess.br_name as br_name FROM branchess");
		  $result_box = $conn->prepare("SELECT boxes.id_bo as id_bo, boxes.box_name as box_name FROM boxes");
		  $result_EMP = $conn->prepare("SELECT employesa3.id_em as id_ems, employesa3.name as namebox_4 FROM employesa3");
		  
		  $result_auth->execute();
		  $All_Users = $result_auth->get_result()->fetch_all(MYSQLI_ASSOC);
		  
		  $result_br->execute();
		  $All_Users1= array_merge($All_Users1, $result_br->get_result()->fetch_all(MYSQLI_ASSOC));
		  
		  $result_box->execute();
		  $All_Users2 = array_merge($All_Users2, $result_box->get_result()->fetch_all(MYSQLI_ASSOC));
		  
		  $result_EMP->execute();
		  $All_Users3 = array_merge($All_Users3, $result_EMP->get_result()->fetch_all(MYSQLI_ASSOC));


*/
 $json_re=array();
 //header('Content-Type: application/json');
 header('Content-Type: application/json');

	array_push($json_re,array("All_Users"=>$All_Users)
	,array("All_Users1"=>$All_Users1),array("All_Users2"=>$All_Users2),array("All_Users3"=>$All_Users3));
	echo json_encode($json_re);

mysqli_close($conn);
?>

