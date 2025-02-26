<?php
include("config.php");

date_default_timezone_set("Asia/Muscat");
$RegDate= date("Y/m/d - h:i a");

$RegDate_2= date("Ymd");

//$TypOpration = strip_tags(trim($_POST["TypOpration"]));
$TypOpration ="decoment";


$dateeCode=date("Ymdhi");
$randomletter = substr(str_shuffle("abcdefghijklmnopqrstuvwxyz"), 0, 5);
$milliseconds = round(microtime(true));
$UserKey = "U".$randomletter.$dateeCode.$milliseconds;

// تحديد عدد النتائج التي تريد استردادها
$limit = 5;

// تحديد الصفحة التي تريد استرداد النتائج منها
$page= $_GET['page'];
//$page=2;


// حساب الحد الأدنى للصفوف التي يجب استردادها
$offset = ($page - 1) * $limit;
//$limit=1;
//$offset=20;

// انشاء الاستعلام
$result = " SELECT employesa3.keyemple as keyemple, employesa3.name,count( employesa3.id_em)as CountDecoment, 
SUM(CASE WHEN decoment.type= 'له' THEN decoment.sol ELSE 0 END) - 

SUM(CASE WHEN decoment.type='عليه' THEN decoment.sol ELSE 0 END) AS balance_due,

SUM(CASE WHEN decoment.type= 'عليه' THEN decoment.sol ELSE 0 END) AS amount_due,

SUM(CASE WHEN decoment.type='له' THEN decoment.sol ELSE 0 END) AS amount_paid
FROM employesa3
JOIN decoment ON employesa3.id_em = decoment.id_emply
GROUP BY employesa3.name
ORDER BY employesa3.name DESC
LIMIT " . $limit . " OFFSET " . $offset;

//$result = "SELECT `id_em`, `name` as name, `date` as date, `phone` as phone, `details` as details, type as Max_sal, keyemple as
 //keyemple FROM `employesa3` LIMIT $limit  OFFSET  $offset";
// تنفيذ الاستعلام
$result_Users = $conn->query($result);

// تخزين النتائج في مصفوفة
$All_Users = array();
if ($result_Users->num_rows > 0) {
    while($row = $result_Users->fetch_assoc()) {
        $All_Users[] = $row;
    }
}

// انشاء مصفوفة JSON وترتيب البيانات فيها
$response = array("All_Users" => $All_Users);

// عرض البيانات كرد من الطلب
header('Content-Type: application/json');
echo json_encode($response);

// إغلاق الاتصال بقاعدة البيانات
mysqli_close($conn);
?>