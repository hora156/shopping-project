<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Header.jsp"></jsp:include>
<script type="text/javascript">

$(document).ready(function() {
	alert("결제가 완료되었습니다");
	location.href="<%=request.getContextPath()%>/mainPage/MainPage.do";
});
</script>

</body>
</html>