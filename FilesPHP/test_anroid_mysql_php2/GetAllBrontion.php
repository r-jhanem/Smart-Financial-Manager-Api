<?php

include("config.php");
$UserName = strip_tags(trim($_POST["name"]));
//$UserName="تعز";

//$UserName = strip_tags(trim($_POST["name"]));
// = strip_tags(trim($_POST["phone"]));

//$UserName="dd";
$All_Users = array();
$All_Users3=array();
$All_User2 = array(); 

$check="";
$sql_UsersLogIn = "SELECT * FROM authorities WHERE  aut_name = '$UserName' LIMIT 1";
	
	$uLogInCheck = $conn->query($sql_UsersLogIn);    
    if ($uLogInCheck->num_rows > 0) {    
      
                        
                    $check = "LogIn_OK"; 
                }else
				{  
				

				$sql_UsersLogIn = "SELECT * FROM authorities WHERE  branchess_name = '$UserName' LIMIT 1";
	
				$uLogInCheck = $conn->query($sql_UsersLogIn);    
				if ($uLogInCheck->num_rows > 0) {    
				  
									
								$check = "LogIn_OK_2"; 
							}
							else
							{
				$sql_UsersLogIn = "SELECT * FROM authorities WHERE  box_name = '$UserName' LIMIT 1";
				$uLogInCheck = $conn->query($sql_UsersLogIn);    
				if ($uLogInCheck->num_rows > 0) {    
				  
									
								$check = "LogIn_OK_3"; 
							}
							}
						}







							if($check=="LogIn_OK")
							{
								$result = "SELECT authorities.branchess_name as namebox,COUNT(employesa3.id_aut) as incounts ,sum(employesa3.sol) as SumSol FROM
								authorities LEFT  JOIN employesa3 on employesa3.id_aut=authorities.id_autss  WHERE authorities.aut_name = '$UserName '  GROUP by authorities.branchess_name  ;";
								$result_Users = $conn->query($result);
										while($rows = $result_Users->fetch_assoc())
										 {			 
										   
										   
								
								
									
									$All_Users3[]=$rows;
									
										}
							}
							else if($check=="LogIn_OK_2")
							{
								$result = "SELECT authorities.box_name as namebox,COUNT(employesa3.id_aut) as incounts ,sum(employesa3.sol) as SumSol FROM
								authorities LEFT  JOIN employesa3 on employesa3.id_aut=authorities.id_autss  WHERE authorities.branchess_name = '$UserName '  GROUP by authorities.box_name  ";
								$result_Users = $conn->query($result);
										while($rows = $result_Users->fetch_assoc())
										 {			 
										   
										   
								
								
									
									$All_Users3[]=$rows;
									
										}

							}
							else if($check=="LogIn_OK_3")
							{
								$result = "SELECT employesa3.name as namebox,COUNT(employesa3.id_aut) as incounts ,sum(employesa3.sol) as SumSol FROM
								authorities LEFT  JOIN employesa3 on employesa3.id_aut=authorities.id_autss  WHERE authorities.box_name = '$UserName '  GROUP by employesa3.name  ; ";
				
								$result_Users = $conn->query($result);
										while($rows = $result_Users->fetch_assoc())
										 {			 
										   
										   
								
								
									
									$All_Users3[]=$rows;
									
										}
							}
							else

							{
								echo $check;
							}

							

     $d=0;   
$m="";



//$result = "SELECT  FROM Users  where name ='%'+'$UserName'+'%'" ;


		$sum=count($All_Users);
			
		
				
	$json_re=array();
	array_push($json_re,array("All_Users"=>$All_Users3));
		//array_push($json_re,array("All_Users"=>$All_Users3,"success"=>$All_User2));

	//array_push($json_re,array("success"=>$All_Users));

	$so= json_encode($json_re);
echo $so;
	mysqli_close($conn);
						  
		
				
	
	
	

	
?>