<?php

include("config.php");
header('Content-Type: text/html; charset=utf-8');

$UserName = strip_tags(trim($_POST["name"]));

//$UserName ="decomentone_uesrsss";

     $d=0;
	 
 

$m="";
$All_Users = array();
$All_Users3=array();

$All_User2 = array();


switch ($UserName)
{



    case "report":
      
		{

			

			$result = "SELECT  employesa3.name as name ,ifnull(COUNT(decoment.id_emply),'0')as incounts ,ifnull(sum(decoment.sol),'0') as SumSol ,decoment.type  as type FROM
			employesa3  left JOIN decoment on decoment.id_emply=employesa3.id_em    GROUP by employesa3.name,decoment.type";
			/*
			SELECT  authorities.id_autss as idbox , authorities.aut_name as namebox, authorities.branchess_name as 
			namebox_2,authorities.box_name as 
			namebox_3,ifnull(COUNT(employesa3.id_aut),'0')as incounts ,ifnull(sum(employesa3.sol),'0') as SumSol FROM
			authorities  left JOIN employesa3 on employesa3.id_aut=authorities.id_autss   GROUP by authorities.aut_name,authorities.id_autss";
			*/
		}
        break;

    case "decoment":

			
$result=" SELECT employesa3.keyemple as keyemple, employesa3.name,count( employesa3.id_em)as CountDecoment, 
SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 

SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,

SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,

SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
FROM employesa3
JOIN decoment ON employesa3.id_em = decoment.id_emply
GROUP BY employesa3.name
ORDER BY  employesa3.name";


		
        break;

		case "get_print_deoment":
			{
				//$ToDate="رعد غانم";
				$FromDate = strip_tags(trim($_POST["FromDate"]));

			$ToDate = strip_tags(trim($_POST["ToDate"]));
			$ToDate_2 = strip_tags(trim($_POST["ToDate_id"]));

	
			$result = "SELECT   employesa3.id_em,employesa3.name as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
			FROM employesa3  JOIN decoment 
			ON decoment.id_emply=employesa3.id_em where employesa3.name  like '$ToDate'";


				break;
			}

			
		case "get_print_deoment_3":
			{
				//$ToDate="رعد غانم";
				$FromDate = strip_tags(trim($_POST["FromDate"]));

				$ToDate = strip_tags(trim($_POST["ToDate_id"]));

			$ToDate = strip_tags(trim($_POST["ToDate"]));
	
			$result = "SELECT   employesa3.id_em,employesa3.name as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
			FROM employesa3  JOIN decoment 
			ON decoment.id_emply=employesa3.id_em where employesa3.name  like '$ToDate'";


				break;
			}


			case "Get_All_Data_Spiner_print_one":
				{
					
				$ToDate = strip_tags(trim($_POST["ToDate"]));

				//$ToDate ="Uowlsz2023081901041692392667";
		
				$result = "SELECT  decoment.id_dee as id, employesa3.name as name, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date
				FROM employesa3  JOIN decoment 
				ON decoment.id_emply=employesa3.id_em where decoment.key_decoment  = '$ToDate';";
	
	
					break;
				}
			case "decomentone_r":
				{
					$FromDate = strip_tags(trim($_POST["FromDate"]));
	
				$ToDate = strip_tags(trim($_POST["ToDate"]));
		
				$result = "SELECT   employesa3.id_em,employesa3.name as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
				FROM employesa3  JOIN decoment 
				ON decoment.id_emply=employesa3.id_em";
	
	
					break;
				}
		case "decomentone":
			{
				//$ToDate="raad";
				$FromDate = strip_tags(trim($_POST["FromDate"]));

			$ToDate = strip_tags(trim($_POST["ToDate"]));
	
			$result = "SELECT   decoment.id_dee as id_d,decoment.aut_id as dite, employesa3.id_em,employesa3.name
			 as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
			FROM employesa3  JOIN decoment 
			ON decoment.id_emply=employesa3.id_em where employesa3.id_em ='$ToDate'";


				break;
			}

			case "decomentone_uesrsss":
				{
					//$ToDate="raad";
					$FromDate = strip_tags(trim($_POST["FromDate"]));
	
				$ToDate = strip_tags(trim($_POST["ToDate"]));
				$result = "SELECT   decoment.id_dee as id_d,decoment.aut_id as dite, employesa3.id_em,employesa3.name
				 as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
				FROM employesa3  JOIN decoment 
				ON decoment.id_emply=employesa3.id_em where employesa3.name like '$ToDate'";
	
	
					break;
				}
			case "decomentone_search_spinner_box":
				{

					$Use_id= strip_tags(trim($_POST["name_id"]));


					
		$result =  "SELECT boxes.id_bo as id, boxes.box_name as name FROM boxes
		";
		
					break;
				}

				case "decomentone_search_spinner_box_id":
					{
	
						$Use_id= strip_tags(trim($_POST["name_id"]));
	
	
						
			$result = " SELECT boxes.id_bo as id, boxes.box_name as name FROM boxes WHERE boxes.id_brans='$Use_id'
			";
			
						break;
					}

				case "decomentone_search_spinner_empl":
					{
						$Use_id= strip_tags(trim($_POST["name_id"]));

						
			$result = "SELECT `id_em` as id, `name` as name FROM `employesa3`";
			
						break;
					}


					
					
				case "decomentone_search_auttext":
					{
	
					
						//$Use_id= strip_tags(trim($_POST["name_id"]));

						$result = "SELECT `id_em` as id, `name` as name FROM `employesa3`
							
";


						break;
					}


					case "decomentone_search_auttext_2":
						{
		
						
							$Use_id= strip_tags(trim($_POST["name_id"]));


	
							$result = "SELECT `id_em` as id, `name` as name FROM `employesa3` where employesa3.id_aut='$Use_id'
								
	";
	
	
							break;
						}
				case "decomentone_search_spinner_empl_2":
					{
	
						$Use_id= strip_tags(trim($_POST["name_id"]));

			$result = "SELECT `id_em` as id, `name` as name FROM `employesa3` WHERE employesa3.id_aut='$Use_id'";
			
						break;
					}
			case "decomentone_search":
				{
				//$ToDate="رعد غانم";
					$FromDate = strip_tags(trim($_POST["FromDate"]));
	
$ToDate = strip_tags(trim($_POST["ToDate"]));
		
				$result="SELECT employesa3.name,count( employesa3.id_em)as CountDecoment, 
				SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
				
				SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
				
				SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
				
				SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
				FROM employesa3
				JOIN decoment ON employesa3.id_em = decoment.id_emply
		where employesa3.name LIKE'%$ToDate%' or employesa3.phone LIKE'%$ToDate%' 
				GROUP BY employesa3.name
				ORDER BY  employesa3.name";
	
					break;
				}

				
		case "date_printes":

			{
				//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
				$FromDate = strip_tags(trim($_POST["FromDate"]));

				$ToDate = strip_tags(trim($_POST["ToDate"]));
				$nameh_id = strip_tags(trim($_POST["nameh_id"]));


				
			$result = "SELECT  DISTINCT
			employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
			as type ,decoment.key_decoment as key_decoment
					FROM employesa3  JOIN decoment 
					ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$FromDate' and '$ToDate'
					GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";

break;

			}

				case "date_box_date":

			{
				//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
				$FromDate = strip_tags(trim($_POST["FromDate"]));

				$ToDate = strip_tags(trim($_POST["ToDate"]));
				$nameh_id = strip_tags(trim($_POST["nameh_id"]));


				
			$result = "SELECT  DISTINCT
			employesa3.name as name,decoment.sol as sol,decoment.detils as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')  as date,decoment.type 
			as type ,decoment.key_decoment as key_decoment
					FROM employesa3  JOIN decoment 
					ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$FromDate' and '$ToDate' and employesa3.id_aut='$nameh_id'
					GROUP by employesa3.name,decoment.sol,decoment.name,decoment.date,decoment.type,decoment.key_decoment;";
		

			}
			break;
	
	

			


				
				case "date_user_one_4":

					{
						//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
						$FromDate = strip_tags(trim($_POST["FromDate"]));
		
						$ToDate = strip_tags(trim($_POST["ToDate_id"]));
						$nameh_id = strip_tags(trim($_POST["ToDate"]));
			

					$result = "SELECT   employesa3.id_em,employesa3.name as name,decoment.sol as sol,decoment.detils  as detils,decoment.name as stat, DATE_FORMAT(decoment.date, '%Y/%m/%d')as  date,decoment.type as type ,decoment.key_decoment  as key_decoment
					FROM employesa3  JOIN decoment 
					ON decoment.id_emply=employesa3.id_em where decoment.date BETWEEN '$ToDate' and '$FromDate' and employesa3.name like '$nameh_id'
							";
		
		
					}
					break;

				case "date_user_one_2":

					{
						//SELECT DATE_FORMAT(date, '%Y-%m-%d') AS formatted_date FROM decoment
						$FromDate = strip_tags(trim($_POST["FromDate"]));
	
						$ToDate = strip_tags(trim($_POST["ToDate"]));
						$nameh_id = strip_tags(trim($_POST["nameh_id"]));
					

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
					$FromDate = strip_tags(trim($_POST["FromDate"]));
	
					$ToDate = strip_tags(trim($_POST["ToDate"]));
					$nameh_id = strip_tags(trim($_POST["nameh_id"]));
				
					
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
					$FromDate = strip_tags(trim($_POST["FromDate"]));
	
					$ToDate = strip_tags(trim($_POST["ToDate"]));
	
					
				

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
			case "employss3":

				{
					//$ToDate="رعد غانم";


				$ToDate = strip_tags(trim($_POST["ToDate"]));

				//	$FromDate = strip_tags(trim($_POST["FromDate"]));

				

				$result = "SELECT employesa3.name AS name, decoment.sol AS sol, decoment.name AS stat, DATE_FORMAT(decoment.date, '%Y/%m/%d') as date, decoment.type AS
				TYPE , decoment.key_decoment AS key_decoment
				FROM employesa3
				INNER JOIN decoment ON decoment.id_emply = employesa3.id_em
				WHERE employesa3.name ='$ToDate'
				GROUP BY employesa3.name, decoment.sol, decoment.name, decoment.date, decoment.type, decoment.key_decoment
				LIMIT 0 , 30";

				}
				break;
		
    case "employss":

		

		$result = "SELECT `id_em`, `name` as name, `date` as date, `phone`
		as phone, `details` as details ,type as Max_sal,keyemple as keyemple FROM `employesa3`";
		
        break;
		case "employss_one":
{		

//int sec all;
			$ToDate = strip_tags(trim($_POST["id_user"]));

			$result = "SELECT `id_em`, `name` as name, `date` as date, `phone`
			as phone, `details` as details ,type as Max_sal,keyemple as keyemple FROM `employesa3` where id_em='$ToDate'";
			
			break;}
			

			case "employss_one_uy":
				{		
				
				//int sec all;
							$ToDate = strip_tags(trim($_POST["id_user"]));
				
							$result = "SELECT `id_em`, `name` as name, `date` as date, `phone`
							as phone, `details` as details ,type as Max_sal,keyemple as keyemple FROM `employesa3` ";
							
							break;}
							
		case "nameh9":

			{
			
			$result = "SELECT `id_em` as id, `name` as name FROM `employesa3`";
			}
			break;
	case "SearchSpinner":
		$ToDate = strip_tags(trim($_POST["ToDate"]));


		$ToDate = strip_tags(trim($_POST["FromDate"]));

		$result="SELECT  employesa3.keyemple as keyemple,employesa3.name,count( employesa3.id_em)as CountDecoment, 
		SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
		
		SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
		
		SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
		
		SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
		FROM employesa3
		JOIN decoment ON employesa3.id_em = decoment.id_emply
where employesa3.id_aut='$ToDate'
		GROUP BY employesa3.name
		ORDER BY  employesa3.name";

		break;
	case "SearchSpinner_22":
		$ToDate = strip_tags(trim($_POST["ToDate"]));


		$ToDate = strip_tags(trim($_POST["FromDate"]));

		$result="SELECT  employesa3.keyemple as keyemple,employesa3.name,count( employesa3.id_em)as CountDecoment, 
		SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
		
		SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
		
		SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
		
		SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
		FROM employesa3
		JOIN decoment ON employesa3.id_em = decoment.id_emply
		GROUP BY employesa3.name
		ORDER BY  employesa3.name";

		break;

		
		case "SearchSpinner_All_Auth_report":
			{
			
			//	$ToDate = strip_tags(trim($_POST["ToDate"]));
			
			
			//	$ToDate = strip_tags(trim($_POST["FromDate"]));
			
				$result="SELECT authorities.aut_name AS name,
				COUNT(employesa3.id_em) AS CountDecoment,
				SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) - SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
				SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
				SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) AS amount_paid
		 FROM  authorities 
		 LEFT JOIN branchess ON authorities.id_autss = branchess.id_auth
		 
		 LEFT JOIN boxes ON branchess.id = boxes.id_brans
		 LEFT JOIN employesa3 ON boxes.id_bo = employesa3.id_aut
		 LEFT JOIN decoment ON employesa3.id_em = decoment.id_emply
		 GROUP BY authorities.aut_name 
		 ORDER BY authorities.aut_name ;";

				
			
			
			}
			
			
						break;


						case "SearchSpinner_All_emp_report":
							{
							
						//		$ToDate = strip_tags(trim($_POST["ToDate"]));
							
							
								//$ToDate = strip_tags(trim($_POST["FromDate"]));
							
								$result="SELECT employesa3.name AS name,
								COUNT(employesa3.id_em) AS CountDecoment,
								SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) - SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
								SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
								SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) AS amount_paid
						 FROM employesa3
						 LEFT JOIN decoment ON employesa3.id_em = decoment.id_emply
						 GROUP BY employesa3.name
						 ORDER BY employesa3.name;";
				
								
							
							
							}
							
							
										break;

						case "SearchSpinner_All_box_report":
							{


							
							//	$ToDate = strip_tags(trim($_POST["ToDate"]));
							
							
								//$ToDate = strip_tags(trim($_POST["FromDate"]));
							
								$result="SELECT boxes.box_name AS name,
								COUNT(employesa3.id_em) AS CountDecoment,
								SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) - SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
								SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
								SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) AS amount_paid
						 FROM boxes 
						 LEFT JOIN employesa3 ON boxes.id_bo = employesa3.id_aut
						 LEFT JOIN decoment ON employesa3.id_em = decoment.id_emply
						 GROUP BY boxes.box_name
						 ORDER BY boxes.box_name;";
				
								
							
							
							}
							
							
										break;



		case "SearchSpinner_All_brann_report":
			{
			


				//$ToDate = strip_tags(trim($_POST["ToDate"]));
			
			
				//$ToDate = strip_tags(trim($_POST["FromDate"]));
			
				$result="SELECT branchess.br_name AS name,
				COUNT(employesa3.id_em) AS CountDecoment,
				SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) - SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
				SUM(CASE WHEN decoment.type = 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
				SUM(CASE WHEN decoment.type = 'له' THEN decoment.sol ELSE 0 END) AS amount_paid
		 FROM branchess
		 LEFT JOIN boxes ON branchess.id = boxes.id_brans
		 LEFT JOIN employesa3 ON boxes.id_bo = employesa3.id_aut
		 LEFT JOIN decoment ON employesa3.id_em = decoment.id_emply
		 GROUP BY branchess.br_name
		 ORDER BY branchess.br_name;";

				
			
			
			}
			
			
						break;
		case "SearchSpinner_autho_report":
{

	$ToDate = strip_tags(trim($_POST["ToDate"]));


	$ToDate = strip_tags(trim($_POST["FromDate"]));

	$result="SELECT  count( employesa3.id_em)as CountDecoment, 
	SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
	
	SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
	
	SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
	
	SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
	FROM  branchess JOIN
	boxes on branchess.id=boxes.id_brans JOIN  
	employesa3 on boxes.id_bo=employesa3.id_aut  
	JOIN decoment ON employesa3.id_em = decoment.id_emply 
	
where branchess.id_auth='$ToDate'
";


}


			break;

		case "SearchSpinner_autho":

			{
				$ToDate = strip_tags(trim($_POST["ToDate"]));


		$ToDate = strip_tags(trim($_POST["FromDate"]));

		$result="SELECT  employesa3.keyemple as keyemple,employesa3.name,count( employesa3.id_em)as CountDecoment, 
				SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
				
				SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
				
				SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
				
				SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
				FROM branchess JOIN
				boxes on branchess.id=boxes.id_brans JOIN  
				employesa3 on boxes.id_bo=employesa3.id_aut  
				JOIN decoment ON employesa3.id_em = decoment.id_emply 
				
		where branchess.id_auth='$ToDate'
				GROUP BY employesa3.name
				ORDER BY  employesa3.name";



				break;
			}
		case "SearchSpinner_brann":

			{
				$ToDate = strip_tags(trim($_POST["ToDate"]));


		$ToDate = strip_tags(trim($_POST["FromDate"]));

		$result="SELECT  employesa3.keyemple as keyemple,employesa3.name,count( employesa3.id_em)as CountDecoment, 
		SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
		
		SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
		
		SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
		
		SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
		FROM boxes JOIN  
        employesa3 on boxes.id_bo=employesa3.id_aut  
		JOIN decoment ON employesa3.id_em = decoment.id_emply 
        
where boxes.id_brans='$ToDate'
		GROUP BY employesa3.name
		ORDER BY  employesa3.name
		";
			}

			break;





		case "SearchSpinner_auth":
			$ToDate = strip_tags(trim($_POST["ToDate"]));
	
	
	
			$result="SELECT branchess.br_name as name,branchess.id  as id
			 FROM branchess where branchess.id_auth='$ToDate' 
			";
	
			break;
		case "SearchSpinner_2":
			$ToDate = strip_tags(trim($_POST["ToDate"]));


			$ToDate = strip_tags(trim($_POST["FromDate"]));
	
			$result="SELECT employesa3.name,count( employesa3.id_em)as CountDecoment, 
			SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
			
			SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
			
			SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
			
			SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
			FROM employesa3
			JOIN decoment ON employesa3.id_em = decoment.id_emply
	where decoment.aut_id='$ToDate'
			GROUP BY employesa3.name
			ORDER BY  employesa3.name";

			break;
			

			case "data_user":
			{
				 $ToDate= strip_tags(trim($_POST["ToDate"]));
				 //$ToDate="26";
				$result="SELECT employesa3.name,count( employesa3.id_em)as CountDecoment, 
				SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 
				
				SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,
				
				SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,
				
				SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
				FROM employesa3
				JOIN decoment ON employesa3.id_em = decoment.id_emply
		where employesa3.id_em='$ToDate'
				GROUP BY employesa3.name
				ORDER BY  employesa3.name
";
			}

			break;
    case "box":


		$result = "SELECT  authorities.id_autss as idbox , authorities.aut_name as namebox, authorities.branchess_name as 
		namebox_2,authorities.box_name as 
		namebox_3,ifnull(sum(employesa3.sol),'0') as SumSol FROM
		authorities  left JOIN employesa3 on employesa3.id_aut=authorities.id_autss   GROUP by authorities.aut_name,authorities.id_autss";
        break;
    default:
	$result = "SELECT  authorities.id_autss as idbox , authorities.aut_name as namebox, authorities.branchess_name as 
		namebox_2,authorities.box_name as 
		namebox_3,ifnull(COUNT(employesa3.id_aut),'0')as incounts ,ifnull(sum(employesa3.sol),'0') as SumSol FROM
		authorities  left JOIN employesa3 on employesa3.id_aut=authorities.id_autss   GROUP by authorities.aut_name,authorities.id_autss";



}
//$result = "SELECT  FROM Users  where name ='%'+'$UserName'+'%'" ;

$result_Users = $conn->query($result);
		while($rows = $result_Users->fetch_assoc())
		 {			 

	$All_Users3[]=$rows;
	
	    }

		$sum=count($All_Users);
				
	$json_re=array();

	array_push($json_re,array("All_Users"=>$All_Users3));

		//array_push($json_re,array("All_Users"=>$All_Users3,"success"=>$All_User2));

	//array_push($json_re,array("success"=>$All_Users));

	$so= json_encode($json_re);
echo $so;


	mysqli_close($conn);
	
?>