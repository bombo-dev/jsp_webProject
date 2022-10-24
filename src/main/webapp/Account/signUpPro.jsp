<%@page import="model.AccountDAO"%>
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
	
	<jsp:useBean id="input" class="model.AccountVO"/>
	<jsp:setProperty property="*" name="input"/>
	
	<jsp:useBean id="dao" class="model.AccountDAO"/>
	<c:set var="row" value="${dao.insert(input)}"/>
	
	<c:if test="${row != 0}">
		<script>
			alert('회원가입을 환영합니다.');
			location.href = 'login.jsp';
		</script>
	</c:if>
	
	<c:if test="${row == 0 }">
		<script>
			alert('회원가입 실패!!');
			history.go(-1);
		</script>
	</c:if>
</body>
</html>