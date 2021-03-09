<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        * {
            box-sizing: border-box;
        }


        /* Center website */
        .main {
            max-width: 1000px;
            padding: 10px;
            margin: auto;
        }

        h1 {
            font-size: 50px;
            word-break: break-all;
        }

        .row {
            margin: 8px -16px;
        }

        /* Add padding BETWEEN each column */
        .row,
        .row>.column1 {
            padding: 8px;
        }

        .row,
        .row>.column2 {
            padding: 8px;
        }

        /* Create four equal columns that floats next to each other */
        .column1 {
            float: left;
            width: 25%;
        }

        .column2 {
            float: left;
            width: 75%;
        }

        /* Clear floats after rows */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Content */
        .content {
            background-color: white;
            padding: 10px;
        }
        
        .readMeItem {
            background-color: white;
            padding: 10px;
        }
        
        .readMeItem>h3 {
            text-align: center;
        }
        
        .readMeItem>p {
            text-align: right;
        }

        /* Responsive layout - makes a two column-layout instead of four columns */
        @media screen and (max-width: 900px) {
            .column {
                width: 50%;
            }
        }

        /* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .column {
                width: 100%;
            }
        }
        
        .bar {
       		overflow: hidden;
            background-color: #333;
            top: 0;
            width: 100px;
        }
        
        .button {
        	float: right;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 18.5px 16px;
            text-decoration: none;
            font-size: 20px;
        }
    </style>
</head>

<body>



<jsp:include page="/Header.jsp"/>
    <!-- MAIN (Center website) -->
    <div class="main">

        <h1>제품 이름!</h1>
        <hr>

        <!-- Portfolio Gallery Grid -->
        <div class="row">
            <div class="column1">
                <div class="content">
                    <img src="http://placehold.it/500" alt="제품이미지" style="width:100%;, height: 100%;">
                </div>
            </div>
            <div class="column2">
                <div class="readMeItem">
                    <h3>상품 설명 및 이것 저것 들어갈 곳</h3>
                    <p>p태그 하나에</p>
                    <p>내용과 수량, 옵션, 구매 버튼 등등</p>
                    <div class="bar">
	                    <a class="abc" href="#">장바구니 추가</a>
                    
                    </div>
                </div>
            </div>

            <!-- END GRID -->
        </div>

        <div class="content">
            <h3>요즘 상품은 이미지로 많이 설명</h3>
            <img src="http://placehold.it/800" style="width:100%;, height: 100%">
        </div>

        <!-- END MAIN -->
    </div>

</body></html>
