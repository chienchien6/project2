<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>後台</title>
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.1.0/uicons-brands/css/uicons-brands.css'>
    <style>
        body {
            background-color: #FFDCB9;
            margin: 0;
            padding: 0;
			
        }


        .function {
            /*margin-left: 80px;*/
            padding-top: 15px;
            width: 250px;
            height: 98vh;
            background-color: aliceblue;
            float: left;
            
        }

        .user {
            margin: 0 15px 15px 15px;
            font-size: 20px;
        }

        .find {
            width: 200px;
            height: 35px;
            margin-left: 25px;

            font-weight: bold;
            text-indent: 35px;
            font-size: 30px;
            border-radius: 5px;
        }

        .option {
            margin: 15px;
            padding-left: 35px;
            font-size: 30px;

            border-bottom: 1px solid black;
        }

        a {
            text-decoration: none;
            color: black;
            font-weight: bold;
        }

        a:hover {
            color: #FFDC35;
        }
    </style>

</head>


<div class="function">
	
    <div class="user"><i class="fi fi-brands-github"></i><label class="user" for="">${back.email}</label></div>
    <input class="find" type="text" name="" id="" value="">

    <div class="option"><a href="GetAllUser?email=${back.email}">會員管理</a></div>

    <div class="option"><a href="../WSall">活動管理</a></div>

    <div class="option"><a href="http://">配對管理</a></div>

    <div class="option"><a href="http://">商城管理</a></div>

    <div class="option"><a href="http://">互動區管理</a></div>

    <div class="option"><a href="http://">課程管理</a></div>

    <div class="option"><a href="http://">金流管理</a></div>

</div>

<body>

</body>

</html>