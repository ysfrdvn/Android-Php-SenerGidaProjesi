
    <?php
	
		//if(isset($_GET["submit"])){
        $username=$_POST["username"];
        $password=$_POST["password"];
		//}
	
        $servername = "localhost";         // Veritaban� adresi yada ip'si yer almal�
        $user = "root";            // bu alanda ise veritaban�n�n kullan�c� ad� yer almal�.
        $pass = "";     // bu alanda veritaban� kullan�c� �ifresi yer almal�.
        $dbname = "sener";                  // bu alanda veritaban� ad� yer almal�
        $isExist=false;
     $conn = new mysqli($servername, $user, $pass, $dbname);
        
		
		if ($conn->connect_error)
        {
            die("Connection failed: " . $conn->connect_error);
        }
        $sql = "SELECT * FROM uyeler where username='$username'";
        $result = $conn->query($sql);
		//echo $result->num_rows;
        if ($result->num_rows >0)
        {
                $isExist=true;
                $conn->close();
                echo 'B�yle bir kullan�c� zaten mevcut';
        }
        else
        {
          
            $sql = "insert into uyeler (username, password) VALUES ('$username', '$password')";
            if (mysqli_query($conn, $sql))
            {
                echo "Kullan�c� ba�ar�yla kaydedildi!";
            }
            else
            {
                echo "Error:  $conn->error;";
            }
            $conn->close();
        }
    ?>
<td><p><button class="btn btn-danger btn-xs"  onClick="deletee(result[i].id)" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
    <td>"+result[i].produced+"</td>
			<td>"+result[i].barcode+"</td>
 onClick='"deletee(+result[i].id+)'"