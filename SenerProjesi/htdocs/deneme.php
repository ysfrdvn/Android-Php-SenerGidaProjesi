<?php 
include ('settings.php');
	$settings=new settings();
	
	
	if($_POST['request']=="insert")
	 $settings->insert($_POST['count'],$_POST['barcode'],$_POST['table'],$_POST['name']);
	else if($_POST['request']=="delete")
		$settings->deleteProduct($_POST['table'],$_POST['id']);
	else if($_POST['request']=="webCorrect"){
		$result=$settings->getTable($_POST['table']);
		$response = array();
		$i=0;
		 while($roww = mysqli_fetch_assoc($result))
			{
				
				$response[$i]= $roww;
				$i=$i+1;

			}
			echo json_encode ( $response );		
	}
		
	else if($_POST['request']=="getTable"){
		$row=$settings->getTable($_POST['table']);
		$response = array();
		$i=0;
		 while($roww = mysqli_fetch_assoc($row))
			{
				
				$response[$i]= $roww;
				$i=$i+1;

			}
			echo json_encode ( $response );
		
	}
	else if($_POST['request']=="andShowProduct"){
		
		$row=$settings->showProduct($_POST['table']);
		$response = array();
		$i=0;
		 while($roww = mysqli_fetch_assoc($row))
			{
				
				$response[$i]= $roww;
				$i=$i+1;

			}
			echo json_encode ( $response );
		
	}
	else if($_POST['request']=="update"){
		$settings->updateProduct($_POST['table'],$_POST['produced'],$_POST['id']);
	}
	else if($_POST['request']=="correct"){
		$settings->updateCorrect($_POST['id']);
	}
	
	
		
		
		
	

?>