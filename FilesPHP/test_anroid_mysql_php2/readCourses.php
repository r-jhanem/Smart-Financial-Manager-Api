

<?php

include("config.php");

//$_POST['UserName']
    
$UserName=strip_tags(trim($_POST["name"]));
//$UserName="gg";
        
//$md5Pass = md5($PassWord); 

$All_Users = array();


    //$id="666";
   
  

     switch($UserName)
{
	case"decomentone_search_spinner_box":

		{



			$id = strip_tags(trim($_POST["name_id"]));

 $result="SELECT boxes.id_bo as id, boxes.box_name as name FROM boxes
      " ;
			break;

		}
     
				case "decomentone_search_spinner_box_id":
					{
	
						$Use_id= strip_tags(trim($_POST["name_id"]));
	
	
						
			$result = " SELECT boxes.id_bo as id, boxes.box_name as name FROM boxes WHERE boxes.id_brans='$Use_id'
			";
			
						break;
					}}
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

