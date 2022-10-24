<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="user" class="model.AccountVO"/>
	<jsp:setProperty property="*" name="user"/>

	<%-- 객체는 useBean으로 만들 수 있다. --%>
	<jsp:useBean id="dao" class="model.AccountDAO"/>
	
	<%-- Attribute를 생성하고 저장은 c:set으로 가능하다. --%>
	<%-- <c:set var="ver" value="${dao.test()}"/> --%>

	<c:set var="login" value="${dao.selectOne(user)}" scope="session"></c:set>
	
	<c:if test="${not empty login}">
		<c:redirect url="/main.jsp"/>
	</c:if>
	
	<c:if test="${empty login }">
		<script>
			alert('일치하는 계정이 존재하지 않습니다.');
			history.go(-1);
		</script>
	</c:if>
	
</body>
</html>