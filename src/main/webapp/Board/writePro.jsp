<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id ="input" class="model.BoardVO"/>
	<jsp:setProperty property="*" name="input"/>
	<jsp:useBean id="dao" class="model.BoardDAO"/>
	
	<c:set var="row" value="${dao.insert(input)}"/>
	
	<c:if test="${row != 0}">
		<c:redirect url="board.jsp"/>
	</c:if>
	
	<c:if test="${row == 0}">
		<script>
			alert('잘못된 접근으로 글이 작성되었습니다.')
			history.go(-1);
		</script>
	</c:if>
	
</body>
</html>