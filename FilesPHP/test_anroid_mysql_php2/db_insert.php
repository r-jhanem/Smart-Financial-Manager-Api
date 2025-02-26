<?php
include("config.php");

date_default_timezone_set("Asia/Muscat");
$RegDate= date("Y/m/d - h:i a");

//$idbox=$_POST['idbox'];


 //$reslut=$_POST['reslut'];

 //$reslut=$_POST['reslut'];


//$aut=$_POST['auot_name'];

 //$reslut="2";

//$bran=$_POST['bran_name'];
//$boxes=$_POST['box_name'];
$name=$_POST['name'];

  $date=$_POST['dates'];
 //$phone=$_POST['phone'];

 $gters=$_POST['gters'];


 //$simsol=$_POST['sum_sol'];
  $sol=$_POST['sol'];
  $tybe_abmin=$_POST['tybe_abmin'];

  $syte="L";


  $reslut="decoment";
  $name="رعد غانم";

  /*

  
  
 //$reslut="2";
 
$aut="صنعاء";

$bran="auot_name";
$boxes="auot_na";

  $date="2018/4/3";
  $phone="70040";
  
 $gters="اايغي";
 $simsol="10";
  $sol="90";
  $tybe_abmin="0";
  */

   
  $All_Users = array();
  $All_Users3 = array();
    $dateeCode=date("Ymdhi");
    $randomletter = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
    $milliseconds = round(microtime(true));
    $UserKey = "U".$randomletter.$dateeCode.$milliseconds;
    $check="";
    	
   

  if($reslut=="decoment")

  {

    
  $result = "SELECT employesa3.id_aut  as id_aut,employesa3.id_em  as id_em FROM employesa3 WHERE name like '$name'";

  $result_Users = $conn->query($result);
        while($rows = $result_Users->fetch_assoc())
         {			 
            
            
  
  
           
     $All_Users3[]=$rows;
     $x1 = $rows['id_aut'];
     $x2 = $rows['id_em'];


         }
         //echo $x1;

         $qry="INSERT INTO `decoment`( `name`, `date`, `sol`, `type`, `id_emply`, `key_decoment`, `detils`, `id_autos`) 
          VALUES 
          ( '$syte', '$date', '$sol', '$tybe_abmin', '$x2', '$UserKey', '$gters', '$x1')";
          
      
         mysqli_query($conn,$qry);

   
        }
                     
        if($qry==true)
        echo "Filuue  Successfully";
       else
        echo "Could not upload File";

        /*
       // $sum=count($All_Users);


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
  
  $b="INSERT INTO `authorities` (`id_autss`, `aut_name`, `branchess_name`, `box_name`) VALUES (NULL, '$aut', '$bran', '$boxes')";

  mysqli_query($conn,$b);

  	
  if($reslut!="1")
  {

  $result = "SELECT  * FROM authorities";

       $result_Users = $conn->query($result);
             while($rows = $result_Users->fetch_assoc())
              {			 
                 
                 
       
       
                
          $All_Users3[]=$rows;
          $All_Users[] = $rows['aut_name'];
          
              }
       
             $sum=count($All_Users);
             //echo   $sum;

             $qry="INSERT INTO `employesa3` ( `name`, `date`, `phone`, `details`, `Max_sal`, `id_aut`, `password`, `type`)
              VALUES ('$name', ' $date', '$phone', '$gters', '$sol','$sum', 'admin', '$tybe_abmin')";
  
  
 //$qry="INSERT INTO `users`(`id`, `name`, `Datee`, `phone`,
    //`getres`, `sol`, `sum_sol`,`KeyUser`) VALUES (NULL, '$name',
   // '//$date','$phone','$gters','$sol','$simsol','$UserKey')";
 mysqli_query($conn,$qry);
            }
         */

 
?>
