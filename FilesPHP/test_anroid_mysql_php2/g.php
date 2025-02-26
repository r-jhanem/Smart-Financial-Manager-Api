<?php
include("config.php");

date_default_timezone_set("Asia/Muscat");
$RegDate= date("Y/m/d - h:i a");

$RegDate_2= date("Ymd");

$TypOpration = strip_tags(trim($_POST["TypOpration"]));

//$TypOpration ="nameh9_7";
$v="";

$dateeCode=date("Ymdhi");
$randomletter = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
$milliseconds = round(microtime(true));
$UserKey = "U".$randomletter.$dateeCode.$milliseconds;



switch ($TypOpration)
{



  						
  case "add_user_and_decoment":

    {


                   
$tybe_abmin = strip_tags(trim($_POST["types_admin"]));

//$tybe_abmin ="1";

$nameAto = strip_tags(trim($_POST["nameAto"]));
$NameUser = strip_tags(trim($_POST["User_name"]));

//$Phone="6886";
$Phone = strip_tags(trim($_POST["Phone"]));

$sol = strip_tags(trim($_POST["Sol"]));

$All_Users = array();
$All_Users3 = array();


    $qry =" INSERT INTO `employesa3`( `name`, `phone`, `id_aut`, `password`, `type`, `keyemple`) VALUES  
('$NameUser','$Phone','$nameAto','$sol', '$tybe_abmin', '$UserKey')";
	break;
	}}

	$Users_Data = array();


	$dbResult = $conn->query($qry);
	 if ($dbResult === TRUE) {
	   $Users_Data []="Reg_OK";
   
			$check = "Reg_OK";  
			 } else {
			   $Users_Data []="Error";
   
			 $check = "Error"; 
			 }
		 
		 
		 $json_re=array();
		 array_push($json_re,array("success"=>$Users_Data));
		 echo json_encode($json_re);
	   
		 
		 mysqli_close($conn);
		 
		
?>