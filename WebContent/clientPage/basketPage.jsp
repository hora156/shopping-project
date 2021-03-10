<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.main {
	    max-width: 1000px;
	    padding: 10px;
	    margin: auto;
	}
</style>

</head>
<body>
<jsp:include page="/Header.jsp" />

<div class="main">
	<c:forEach var="items" items="${itemList.data}">
		
	</c:forEach>
</div>

</body>
</html>