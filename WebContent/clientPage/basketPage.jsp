<%@page import="com.example.model.network.response.ItemApiResponse"%>
<%@page import="com.example.model.entity.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
	    padding-top: 50px;
	}
</style>

</head>
<body>
<jsp:include page="/Header.jsp" />

<script type="text/javascript">
	
	function itemData(item) {
		var a = item;
		
		console.log(a);
	}
	
</script>

<div class="main">
<table>
<tbody>
	<c:forEach var="items" items="${itemList.data}">
		<tr style="text-align: center; border: 1;">
			<td>체크박스</td>
			<td width="500px">
				${items.name}
				${items.price}
				<a href="#" onclick="itemData('${items.name}')">dddd</a>
			</td>
		</tr>		
	</c:forEach>
</tbody>
</table>
</div>

</body>
</html>