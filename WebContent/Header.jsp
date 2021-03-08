<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            background-color: #f1f1f1;
            padding: 20px;
            margin: 0;
            padding-left: 0;
            font-family: Arial;
        }
        
        .navbar {
            overflow: hidden;
            background-color: #333;
            position: fixed;
            top: 0;
            width: 100%;
        }

        .navbar>.side {
            float: right;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 18px 16px;
            text-decoration: none;
            font-size: 10px;
        }
        
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background: #ddd;
            color: black;
        }
    </style>
</head>

<body>

    <div class="navbar">
        <a class="topMenu" href="/shopping/mainPage/MainPage.do">Home</a>
        <a class="topMenu" href="#news">News</a>
        <a class="topMenu" href="#contact">Contact</a>
        <a class="side" href="/shopping/clientPage/loginPage.do">로그인</a>
        <a class="side" href="#myinfo">내정보</a>
        <a class="side" href="#basket">장바구니</a>
    </div>