<?php 

	include 'settings.php';
	$settings=new settings();
	$conn=$settings->conn();
	$request=$_POST['request'];
	if($request="insert"){
		echo $conn->query($settings->insert($_POST['count'],$_POST['barcode'],$_POST['table']));
		
	}



?>