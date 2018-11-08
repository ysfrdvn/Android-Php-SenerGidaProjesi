<?php
	class settings{
		public function conn(){
		$servername = "localhost";         // Veritabanı adresi yada ip'si yer almalı
        $user = "root";            // bu alanda ise veritabanının kullanıcı adı yer almalı.
        $pass = "";     // bu alanda veritabanı kullanıcı şifresi yer almalı.
        $dbname = "sener";  
		$conn=new mysqli($servername, $user, $pass, $dbname);	
		return $conn;
		}
		               // bu alanda veritabanı adı yer almalı
		public function insert($count,$barcode,$table,$name){
			$conn=$this->conn();
			 $conn->query("insert into $table (count,barcode,name) VALUES ('$count','$barcode','$name')");
			 header("Location: http://localhost"); /* Redirect browser */
			exit();
			
			
		}
		public function getTable($table){
			$conn=$this->conn();
			return mysqli_query($conn,"SELECT * FROM $table ");
			
			
		}
		public function deleteProduct($table,$id){
			$conn=$this->conn();
			 $conn->query("DELETE FROM $table WHERE id = $id");
			 header("Location: http://localhost"); /* Redirect browser */
			exit();
		}
		//android kısmı için
		public function showProduct($table){
			// ekrana yazdırmak gerekli
			$conn=$this->conn();
			return mysqli_query($conn,"SELECT * FROM $table ");
			
		}
		//android kısmı için
		public function updateProduct($table,$produced,$id){
			//ekrana yazdırmak gerekli
			$conn=$this->conn();
			$string=$conn->query("SELECT * FROM  $table WHERE id = '$id'");
			$string=mysqli_fetch_assoc($string);
			$conn->query("DELETE FROM $table WHERE id = $id");
			$name=$string['name'];
			$barcode=$string['barcode'];
			$count=$string['count'];
			$conn->query("insert into uretilen (dep,count,produced,name,barcode) VALUES ('$table','$count','$produced','$name','$barcode')");
			
		}
		public function updateCorrect($id){
			$conn=$this->conn();
			return $conn->query("UPDATE uretilen SET isCorrect=1 WHERE id='$id'");
		
		}
		
		
		
	
	}

?>