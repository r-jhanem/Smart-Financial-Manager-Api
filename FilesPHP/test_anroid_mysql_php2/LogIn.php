<?php 
include("config.php");

/*
$UserName = strip_tags(trim($_POST["name"]));
$PassWord = strip_tags(trim($_POST["phone"]));
$UserName = "احمد";
$PassWord ="admin123";

if ($UserName <> "" && $PassWord <> "")
    {
       
        
$md5Pass = md5($PassWord); 
$Users_Data = array();
$so="نعم";
/*
$sql_UsersLogIn="SELECT employesa3.id_em  as id, employesa3.password as pass,employesa3.name 
 as name, employesa3.type as type,count( employesa3.id_em)as CountDecoment, 
SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 

SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,

SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,

SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
FROM employesa3
JOIN decoment ON employesa3.id_em = decoment.id_emply
where employesa3.name like '$UserName'AND employesa3.password like '$PassWord'
GROUP BY employesa3.name
ORDER BY  employesa3.name  LIMIT 1
";
$sql_UsersLogIn = "SELECT employesa3.id_em AS id, employesa3.password AS pass, employesa3.name AS name, employesa3.type AS type,
COUNT(employesa3.id_em) AS CountDecoment,
COALESCE(
    SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) - 
    SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END),
    0
) AS balance_due,
COALESCE(
    SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END),
    0
) AS amount_due,
COALESCE(
    SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END),
    0
) AS amount_paid
FROM employesa3
LEFT JOIN decoment ON employesa3.id_em = decoment.id_emply
WHERE employesa3.name LIKE '$UserName'AND employesa3.password LIKE '$PassWord'
GROUP BY employesa3.name
ORDER BY employesa3.name
LIMIT 1;";

//$sql_UsersLogIn = "SELECT * FROM employesa3 WHERE  name LIKE '$UserName' and password like '$PassWord' LIMIT 1";
	
	$uLogInCheck = $conn->query($sql_UsersLogIn);  
    $rows = $uLogInCheck->fetch_assoc();  
    if ($uLogInCheck->num_rows > 0) {    
        $All_Users[] = $rows;	        

                       $check=$rows['type'];
                    $check = "LogIn_OK"; 
                }else{
                    $All_Users[]= "error";
                }
	           	
                
                

            
            }

            header('Content-Type: application/json');

    
$json_re=array();
array_push($json_re,array("Users_Data"=>$All_Users));
echo json_encode($json_re);

mysqli_close($conn);
?> 

*/


header('Content-Type: text/html; charset=utf-8');
$UserName = strip_tags(trim($_GET["name"]));
$PassWord = strip_tags(trim($_GET["phone"]));
//$UserName = "احمد";
//$PassWord ="admoin123";

if ($UserName <> "" && $PassWord <> "")
    {
       
        
$md5Pass = md5($PassWord); 
$Users_Data = array();
$so="نعم";

$sql_Use = "SELECT * FROM employesa3 WHERE  name LIKE '$UserName' and password like '$PassWord' LIMIT 1";


$uLogInChe= $conn->query($sql_Use);  
$rows = $uLogInChe->fetch_assoc();  
if ($uLogInChe->num_rows > 0) { 

$sql_UsersLogIn = "SELECT employesa3.id_em AS id, employesa3.password AS pass, employesa3.name AS name, employesa3.type AS type,
COUNT(employesa3.id_em) AS CountDecoment,
COALESCE(
    SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) - 
    SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END),
    0
) AS balance_due,
COALESCE(
    SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END),
    0
) AS amount_due,
COALESCE(
    SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END),
    0
) AS amount_paid
FROM employesa3
LEFT JOIN decoment ON employesa3.id_em = decoment.id_emply
WHERE employesa3.name LIKE '$UserName'AND employesa3.password LIKE '$PassWord'
GROUP BY employesa3.name
ORDER BY employesa3.name
LIMIT 1;";

	
	$uLogInCheck = $conn->query($sql_UsersLogIn);  
    $rows = $uLogInCheck->fetch_assoc();  
    if ($uLogInCheck->num_rows > 0) {    
        $All_Users[] = $rows;	        

                       $check=$rows['type'];
                    $check = "LogIn_OK"; 
                }else{
                    $All_Users[]= "error";
                }

            }
                else{
                    $All_Users[]= "error";
                }
	           	
                
                

            
            }


    
$json_re=array();
array_push($json_re,array("Users_Data"=>$All_Users));

echo json_encode($json_re);

mysqli_close($conn);
?> 
