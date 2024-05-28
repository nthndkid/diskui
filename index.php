<?php
    $host = "localhost";
    $username = "root";
    $password = "";
    $database = "pup_dbase";

    $connect  = new mysqli($host, $username, $password, $database);

    $sql = "SELECT * FROM pup_student";
    $students = $connect->query($sql) or die($connect->error);
    $row = $students->fetch_assoc();
    // do{
    //     echo $row['lastname']." ".$row['firstname']. "<br/>";
    // }while($row = $students->fetch_assoc());
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
            font-family: Arial, Helvetica, sans-serif;
        }

        table, th, td{
            border: 1px solid black;
            padding-left: 20px;
        }

        th, td{
            padding-left: 20px;
        }
    </style>
</head>
<body>
    <h1>ABS CBN SHOWTIME HOSTS</h1><br>
    <table>
        <tr>
            <th>LAST NAME</th>
            <th>FIRST NAME</th>
            <th>CITY</th>
        </tr>

        <?php do{ ?>
        <tr>
            <td><?php echo $row['lastname']; ?></td>
            <td><?php echo $row['firstname']; ?></td>
            <td><?php echo $row['city'];?></td>
        </tr>
        <?php } while($row = $students->fetch_assoc()) ?>
    </table>



</body>
</html>
