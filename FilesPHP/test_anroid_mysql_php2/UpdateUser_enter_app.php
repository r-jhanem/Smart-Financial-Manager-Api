

<?php

include("config.php");
header('Content-Type: text/html; charset=utf-8');

$UserName = strip_tags(trim($_GET["name"]));
$FromDate = strip_tags(trim($_GET["FromDate"]));
//$UserName ="decomentone_uesrsss";

     $d=0;
	 
 

$m="";
$All_Users = array();
$All_Users3=array();

$All_User2 = array();


switch ($UserName)
{

	
	
	case "date":

		{
			//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
		//	$FromDate = strip_tags(trim($_POST["FromDate"]));

			$ToDate = strip_tags(trim($_GET["ToDate"]));
			$nameh_id = strip_tags(trim($_GET["nameh_id"]));


			
		$result = "SELECT  DISTINCT
		employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
		as type ,decoment.key_decoment as key_decoment
				FROM employesa3  JOIN decoment 
				ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$FromDate' and '$ToDate'
				GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";


		}
		break;


case "date_user_one_4":

	{
		//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment

		$ToDate = strip_tags(trim($_get["ToDate_id"]));
		$nameh_id = strip_tags(trim($_get["ToDate"]));


	$result = "SELECT   employesa3.id_em,employesa3.name as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
	FROM employesa3  JOIN decoment 
	ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$ToDate' and '$FromDate' and employesa3.name like '$nameh_id'
			";


	}
	break;

case "date_user_one_2":

	{
		//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment

		$ToDate = strip_tags(trim($_GET["ToDate"]));
		$nameh_id = strip_tags(trim($_GET["nameh_id"]));
	

	$result = "SELECT  DISTINCT 
	employesa3.name as name, employesa3.id_em,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
	as type ,decoment.key_decoment as key_decoment
			FROM employesa3  JOIN decoment 
			ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$FromDate' and '$ToDate' and 		employesa3.name  like '$nameh_id'
			GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";


	}
	break;

case "date_user_one":

{
	//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment

	$ToDate = strip_tags(trim($_GET["ToDate"]));
	$nameh_id = strip_tags(trim($_GET["nameh_id"]));

	
$result = "SELECT  DISTINCT
employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
as type ,decoment.key_decoment as key_decoment
		FROM employesa3  JOIN decoment 
		ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$FromDate' and '$ToDate' and decoment.id_emply='$nameh_id'
		GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";


}
break;

case "date_2":

{
	//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
	

	

	$ToDate = strip_tags(trim($_get["ToDate"]));

$result="SELECT employesa3.name as name ,count( employesa3.id_em)as CountDecoment, 
SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 

SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,

SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,

SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
FROM employesa3
JOIN decoment ON employesa3.id_em = decoment.id_emply
where decoment.date BETWEEN '$FromDate' and '$ToDate'
GROUP BY employesa3.name
ORDER BY  employesa3.name";
}
break;

case "date_decoment_true":

	{
		//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
		//$FromDate = strip_tags(trim($_POST["FromDate"]));

	
		$ToDate = strip_tags(trim($_GET["ToDate"]));
		$nameh_id = strip_tags(trim($_GET["nameh_id"]));



		
	$result = "SELECT  DISTINCT
	employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
	as type ,decoment.key_decoment as key_decoment
			FROM employesa3  JOIN decoment 
			ON decoment.id_emply=employesa3.id_em where decoment.name='$nameh_id '
			GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";


	}
	break;

	case "date_frm_to":

		{
			//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
			//$FromDate = strip_tags(trim($_POST["FromDate"]));
	
		
			$ToDate = strip_tags(trim($_GET["ToDate"]));
			$nameh_id = strip_tags(trim($_GET["nameh_id"]));
	
	
	
			
		$result = "SELECT  DISTINCT
		employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
		as type ,decoment.key_decoment as key_decoment
				FROM employesa3  JOIN decoment 
				ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$FromDate' and '$ToDate' and decoment.name='$nameh_id '
				GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";
	
	
		}
		break;
	


	case "date_decoment_true_USER":

		{
			//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
		//	$FromDate = strip_tags(trim($_POST["FromDate"]));

			$ToDate = strip_tags(trim($_GET["ToDate"]));
			$nameh_id = strip_tags(trim($_GET["nameh_id"]));


			
		$result = "SELECT  DISTINCT
		employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
		as type ,decoment.key_decoment as key_decoment
				FROM employesa3  JOIN decoment 
				ON decoment.id_emply=employesa3.id_em where decoment.name = '$nameh_id ' and employesa3.name like '$FromDate'
				GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";


		}
		break;

}
$result_Users = $conn->query($result);
		while($rows = $result_Users->fetch_assoc())
		 {			 

	$All_Users3[]=$rows;
	
	    }

		$sum=count($All_Users);
				
	$json_re=array();

	array_push($json_re,array("All_Users"=>$All_Users3));

	$so= json_encode($json_re);
echo $so;


	mysqli_close($conn);
	
?>

