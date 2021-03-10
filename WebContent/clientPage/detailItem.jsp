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
        
        a {
        	text-decoration: none;
        }
        
	   .btn{
	   		float:right;
		    font-size:1rem;
		    color:black;
		    padding:8px 16px 8px 16px;
		    margin:16px;
		    display:inline-block;
		    border-radius: 10px;
		    transition:all 0.1s;
		    text-decoration: none;
		    /* font-family: 'Lobster', cursive; */ <!-- google font -->
	    }
	    .btn:active{
	     	transform: translateY(3px);
	    }
	    .btn.blue{
		    background-color: #1f75d9;
		    border-bottom:5px solid #165195;
	    }
	    .btn.blue:active{
	     	border-bottom:2px solid #165195;
	    }
	    .btn.red{
		    background-color: #ff521e;
		    border-bottom:5px solid #c1370e;
	    }
	    .btn.red:active{
	     	border-bottom:2px solid #c1370e;
	    }
		
		input[type="number"]::-webkit-outer-spin-button,
		input[type="number"]::-webkit-inner-spin-button {
		    -webkit-appearance: none;
		    margin: 0;
		}
    </style>
</head>

<body>

<jsp:include page="/Header.jsp"/>
    <!-- MAIN (Center website) -->
    <div class="main">

        <h1>${item.data.name}</h1>
        <hr>

        <!-- Portfolio Gallery Grid -->
        <div class="row">
            <div class="column1">
                <div class="content">
                    <img src="http://placehold.it/500" alt="제품이미지" style="width:100%;, height: 100%;">
                </div>
            </div>
            <div class="column2">
            <form action="/shopping/clientPage/basket.do" method="post">
                <div class="readMeItem">
                	<input type="hidden" name="user_id" value="${sessionScope.user.data.id}">
                	<input type="hidden" name="item_id" value="${item.data.id}">
                    <h3>상품 설명 및 이것 저것 들어갈 곳</h3>
                    <p>title : ${item.data.title }</p>
                    <p>제품 설명 : ${item.data.content}</p>
                    <p>가격 : ${item.data.price}</p>
                    <p>브렌드 : ${item.data.brandName}</p>
    				<p> 수량 : 
    				<a href="#" id="decreaseQuantity">▼</a>
                    <input id="numberUpDown" style="text-align: right; width: 30px;" width="50px;" type="number" name="count" value="1" min="0" />
                    <a href="#" id="increaseQuantity">▲</a>
                    </p>
                </div>
	                <input type="submit" class="btn" value="장바구니 추가">
            </form>
            </div>

            <!-- END GRID -->
        </div>

        <div class="content">
            <h3>요즘 상품은 이미지로 많이 설명</h3>
            <img src="http://placehold.it/800" style="width:100%;, height: 100%">
        </div>

        <!-- END MAIN -->
    </div>
<script type="text/javascript">
		$(function(){
			$('#decreaseQuantity').click(function(e){
				e.preventDefault();
				var stat = $('#numberUpDown').val();
				var num = parseInt(stat,10);
				num--;
				if(num<=0){
					alert('더이상 줄일수 없습니다.');
					num = 1;
				}
				$('#numberUpDown').val(num);
			});
			
			$('#increaseQuantity').click(function(e){
				e.preventDefault();
				var stat = $('#numberUpDown').val();
				var num = parseInt(stat,10);
				num++;
				$('#numberUpDown').val(num);
			});
	});

	  
</script>
</body></html>
