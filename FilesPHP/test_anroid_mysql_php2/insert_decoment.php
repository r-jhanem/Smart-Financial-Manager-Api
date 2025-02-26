<?php
include("config.php");

date_default_timezone_set("Asia/Muscat");
$RegDate= date("Y/m/d - h:i a");

$RegDate_2= date("Ymd");

$TypOpration = strip_tags(trim($_POST["TypOpration"]));
$dateeCode=date("Ymdhi");
$randomletter = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
$milliseconds = round(microtime(true));
$UserKey = "U".$randomletter.$dateeCode.$milliseconds;


switch ($TypOpration)
{



  						
  case "add_user_and_decoment":

    {



$name = strip_tags(trim($_POST["User_name_decoment"]));

      //$name = strip_tags(trim($_POST["User_name"]));
    //  $name ="رعد غانم";

      $result = "SELECT `id_em` as id_em FROM `employesa3` WHERE name LIKE '$name'"; // استخدم علامات الاقتباس الصحيحة لتضمين قيمة المتغير $name

      $result_Users = $conn->query($result);
      $All_User = []; // قم بتعريف المصفوفة $All_Users3 قبل الحلقة التكرارية
      
$rows = $result_Users->fetch_assoc();
$v = $rows['id_em'];



    $date = strip_tags(trim($_POST["date_decoment"]));
   
     $id_Auto = strip_tags(trim($_POST["NameAuthor_decoment"]));

      $sol = strip_tags(trim($_POST["Sol_decoment"]));
      $gters = strip_tags(trim($_POST["gresr_decoment"]));

   $tybe_abmin = strip_tags(trim($_POST["types_admin_decoment"]));

if($tybe_abmin=="1")
{
  $tybe_abmin="انتظار";
  $syte="L";

}
else
{
$tybe_abmin="له";
$syte="ss";
}
    

 



  $All_Users = array();
  $All_Users3 = array();
    $dateeCode=date("Ymdhi");
    $randomletter = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
    $milliseconds = round(microtime(true));
    $UserKey = "U".$randomletter.$dateeCode.$milliseconds;
    $check="";  


         $qry="INSERT INTO `decoment` (`aut_id`, `name`, `date`, `sol`, `type`, `id_emply`, `key_decoment`, `detils`) 
         VALUES ('$id_Auto','$syte','$date', '$sol', '$tybe_abmin', '$v', '$UserKey', '$gters')";
         
        





    }
    break;


    case "insert_dacoment":
      
		{



      $name = strip_tags(trim($_POST["User_name_decoment"]));

      //$name = strip_tags(trim($_POST["User_name"]));
    //  $name ="رعد غانم";

      $result = "SELECT `id_em` as id_em FROM `employesa3` WHERE name LIKE '$name' "; // استخدم علامات الاقتباس الصحيحة لتضمين قيمة المتغير $name

      $result_Users = $conn->query($result);
      $All_User = []; // قم بتعريف المصفوفة $All_Users3 قبل الحلقة التكرارية
      
$rows = $result_Users->fetch_assoc();
$v = $rows['id_em'];

      
    $date = strip_tags(trim($_POST["date_decoment"]));
   
     $id_Auto = strip_tags(trim($_POST["NameAuthor_decoment"]));

    // $id_Auto="uuuu";
     

      $sol = strip_tags(trim($_POST["Sol_decoment"]));
      $gters = strip_tags(trim($_POST["gresr_decoment"]));

   $tybe_abmin = strip_tags(trim($_POST["types_admin_decoment"]));

if($tybe_abmin=="1")
{
  $tybe_abmin="انتظار";
  $syte="L";

}
else
{
$tybe_abmin="له";
$syte="ss";
}
    

  $All_Users = array();
  $All_Users3 = array();
    $dateeCode=date("Ymdhi");
    $randomletter = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
    $milliseconds = round(microtime(true));
    $UserKey = "U".$randomletter.$dateeCode.$milliseconds;
    $check="";  


         $qry="INSERT INTO `decoment` (`aut_id`, `name`, `date`, `sol`, `type`, `id_emply`, `key_decoment`, `detils`) 
         VALUES ('$id_Auto','$syte','$date', '$sol', '$tybe_abmin', '$v', '$UserKey', '$gters')";
         
        
       
		}
        break;


        

        case "add_bre":
      
          {


            
            $date = strip_tags(trim($_POST["date"]));
            $sol = strip_tags(trim($_POST["Sol"]));
            $gters = strip_tags(trim($_POST["gresr"]));



            $qry="INSERT INTO `boxes`( `box_name`, `id_brans`) VALUES('$sol','$date')";

          

          }
          break;


  


              case "add_authorities":
      
                {

        
                $date = strip_tags(trim($_POST["date"]));

                                 //   $date = "645";

                  $sol = strip_tags(trim($_POST["Sol"]));
                  $gters = strip_tags(trim($_POST["gresr"]));
      
                  $qry="INSERT INTO `authorities`(`aut_name`) VALUES ( '$date')";
      
                
                }
                    break;

                    case "No_addBox":
      
                      {
                        $date = strip_tags(trim($_POST["date"]));
                        $sol = strip_tags(trim($_POST["Sol"]));
                        $gters = strip_tags(trim($_POST["gresr"]));
            
                        $qry=" INSERT INTO `branchess`( `br_name`, `id_auth`) VALUES ('$sol', '$date') ";
            
                      }
                          break;
      

    case "No_dacoment":
      
		{


      $date = strip_tags(trim($_POST["date"]));
$gters = strip_tags(trim($_POST["gresr"]));

$qry = "UPDATE `decoment` SET	`name`='N'	,`detils`='$gters', `type`='مرفوض'   WHERE `key_decoment` like '$date'";





		}
        break;
        
    case "Yes_dacoment":
      
      {
        $gters = strip_tags(trim($_POST["gresr"]));


        $date = strip_tags(trim($_POST["date"]));


        $qry = "UPDATE `decoment` SET	`name`='ss'	, `type`='عليه'   WHERE `key_decoment` like '$date'
       ";
  
      }
          break;
  


               
          case "updateUser":
      
            {
              $date = strip_tags(trim($_POST["date"]));
$sol = strip_tags(trim($_POST["Sol"]));
$gters = strip_tags(trim($_POST["gresr"]));


              $tybe_abmin = strip_tags(trim($_POST["types_admin"]));
              $nameAto = strip_tags(trim($_POST["nameAto"]));
              $NameUser = strip_tags(trim($_POST["User_name"]));
              $Phone = strip_tags(trim($_POST["Phone"])); 


              $qry = "UPDATE employesa3 SET name='$NameUser' ,phone='$Phone' WHERE keyemple = '$nameAto'";




            }
              break;

         
              case "UpatePassword":
      
                {
                  $date = strip_tags(trim($_POST["date"]));
    $sol = strip_tags(trim($_POST["Sol"]));
    $gters = strip_tags(trim($_POST["gresr"]));
    
    
                  $tybe_abmin = strip_tags(trim($_POST["types_admin"]));
                  $nameAto = strip_tags(trim($_POST["nameAto"]));
                  $NameUser = strip_tags(trim($_POST["User_name"]));
                  $Phone = strip_tags(trim($_POST["Phone"])); 
    
    
                  $qry = "UPDATE employesa3 SET password='$gters'  WHERE id_em = '$nameAto'";
    
    
    
    
                }
                  break;


                    
          case "deleteUser":
      
            {


              $nameAto = strip_tags(trim($_POST["nameAto"]));
              //$nameAto="Urqflt2023052705021685149344";


              $qry =" DELETE FROM employesa3  WHERE keyemple like '$nameAto'";




            }
              break;


          case "AddUser":
      
            {


             
$tybe_abmin = strip_tags(trim($_POST["types_admin"]));

 $nameAto = strip_tags(trim($_POST["nameAto"]));
 $NameUser = strip_tags(trim($_POST["User_name"]));


 $Phone = strip_tags(trim($_POST["Phone"]));

$sol = strip_tags(trim($_POST["Sol"]));

$All_Users = array();
$All_Users3 = array();


     $qry =" INSERT INTO `employesa3`( `name`, `phone`, `id_aut`, `password`, `type`, `keyemple`) VALUES  
 ('$NameUser','$Phone','$nameAto','$sol', '$tybe_abmin', '$UserKey')";


//$qry ="INSERT INTO `employesa3`( `name`, `date`, `phone`, `details`, `id_aut`, `password`, `type`, `keyemple`) VALUES  
//('NameUser79', ' date','ne', 'gters','9','09', 'tybe_abmin', 'UserKey')";
            }
                break;

                
          case "messagechat":
      
            {

              $date = strip_tags(trim($_POST["date"]));
              $sol = strip_tags(trim($_POST["Sol"]));

             // $date =" strip_tag";
              //$sol =" strip_t";



//$sol = strip_tags(trim($_POST["Sol"]));

$qry ="INSERT INTO `messagechat`(`name`, `dates`, `iduser`,`keyMessag`) VALUES ('$date','$RegDate','$sol','$UserKey')";

      
            }
                break;
      
          
  }
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
      

