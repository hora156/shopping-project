<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    <!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
  <title>Bootstrap 4 Website Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  
  * {box-sizing: border-box}

	.container {
		padding-top: 10px;
		padding-bottom: 10px;
	}
	/* Style the tab */
	.tab {
	  float: left;
	  border: 1px solid #ccc;
	  background-color: #f1f1f1;
	  width: 30%;
	  height: 100%;
	}
	
	/* Style the buttons that are used to open the tab content */
	.tab button {
	  display: block;
	  background-color: inherit;
	  color: black;
	  padding: 22px 16px;
	  width: 100%;
	  border: none;
	  outline: none;
	  text-align: left;
	  cursor: pointer;
	  transition: 0.3s;
	}
	
	/* Change background color of buttons on hover */
	.tab button:hover {
	  background-color: #ddd;
	}
	
	/* Create an active/current "tab button" class */
	.tab button.active {
	  background-color: #ccc;
	}
	
	/* Style the tab content */
	.tabcontent {
	  float: left;
	  padding: 0px 12px;
	  border: 1px solid #ccc;
	  width: 70%;
	  border-left: none;
	  height: 100%;
	}
	
	.column {
	  float: left;
	  width: 25%;
	  padding: 5px;
	  height: 150px; /* Should be removed. Only for demonstration */
	}
	
	/* Clear floats after the columns */
	.row:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	
     * {
        box-sizing: border-box;
    }

 

     .header {
         background-color: #f1f1f1;
         padding: 30px;
         text-align: center;
     }

     #navbar {
         overflow: hidden;
         background-color: #333;
     }

     #navbar a {
         float: left;
         display: block;
         color: #f2f2f2;
         text-align: center;
         padding: 14px 16px;
         text-decoration: none;
         font-size: 17px;
     }

     #navbar>.side {
         float: right;
         font-size: 13px;
         padding: 17px 16px;
     }

     #navbar a:hover {
         background-color: #ddd;
         color: black;
     }

     .sticky {
         position: fixed;
         top: 0;
         width: 100%;
     }

     .sticky+.content {
         padding-top: 60px;
     }
  </style>
  <script type="text/javascript">
  
  	function linked(id) {
		location.href = '/shopping/clientPage/detailItem.do?id='+id;
	}
  
  	function openCity(evt, category) {
	  // Declare all variables
	  var i, tabcontent, tablinks;

	  // Get all elements with class="tabcontent" and hide them
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }

	  // Get all elements with class="tablinks" and remove the class "active"
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }

	  // Show the current tab, and add an "active" class to the link that opened the tab
	  document.getElementById(category).style.display = "block";
	  evt.currentTarget.className += " active";
	}
  
	$(document).ready(function() {
	 	openCity(event, 1);
	 	 
	});
	
	function removeSession() {
		/* sessionStorage.removeItem('user.data'); */
		console.log("test : " + sessionStorage.getItem('user'));
		/* location.reload(); */
	}
  
  </script>
</head>
<body>

<div class="header">
    <h2>Scroll Down</h2>
    <p>Scroll down to see the sticky effect.</p>
</div>

<div id="navbar">
    <a class="active" href="javascript:void(0)">Home</a>
    <a href="javascript:void(0)">News</a>
    <a href="javascript:void(0)">Contact</a>
    <c:choose>
    	<c:when test="${sessionScope.user eq null}">
    		<a class="side" href="/shopping/clientPage/loginPage.do">로그인</a>
    	</c:when>
    	<c:otherwise>
    		<a class="side" href="#myinfo">내정보</a>
	        <a class="side" href="#basket">장바구니</a>
    		<a class="side" href="/shopping/clientPage/logout.do">로그아웃</a>
    	</c:otherwise>
    </c:choose>
    <%-- <c:if test="${empty user}">
  	 	<a class="another" href="/shopping/clientPage/loginPage.do">로그인</a>
    </c:if>
    <c:if test="${not empty uesr}">
   		<a class="another" href="#" onclick="removeSession()">로그아웃</a>
    </c:if> --%>
</div>

<div class="container">
  <div class="row">
  	<div class="tab">
  	<c:forEach var="category" items="${category.data }">
	  <button class="tablinks" onclick="openCity(event, ${category.id})">${category.title}</button>
	</c:forEach>
	</div>
	<div id=1 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '컴퓨터')}">
					<div class="column" style="background-color:#aaa;" onclick="linked(${items.id})">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=2 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '의류')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=3 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '멀티샵')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=4 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '인테리어')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=5 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '음식')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=6 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '스포츠')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=7 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '쇼핑몰')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=8 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '면세점')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
	<div id=9 class="tabcontent">
		<c:forEach var="items" items="${item.data}">
			<c:if test="${fn:contains(items.title, '화장')}">
					<div class="column" style="background-color:#aaa;">
					  <p>${items.name }</p>
					  <p>${items.price }</p>
					</div>
			</c:if>
		</c:forEach>
	</div>
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>
</div>
</div>
<script type="text/javascript">
	$(window).scroll(function(event) {
		myFunction();
	});
	
	
	var navbar = document.getElementById("navbar");
	var sticky = navbar.offsetTop;
	
	function myFunction() {
	    if (window.pageYOffset >= sticky) {
	        navbar.classList.add("sticky")
	    } else {
	        navbar.classList.remove("sticky");
	    }
	}
</script>
</body>
</html>