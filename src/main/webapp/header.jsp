<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${cpath }/css/style.css" type="text/css">
  <title>Main</title>
</head>
<body>
  <header>
    <div id="logo">
    	<a href="${cpath }/main.jsp">
        	<img src="${cpath }/src/logo.png" alt="로고">
        </a>
    </div>

    <div id="menu">
      <div><a href="${cpath }/Board/board.jsp?page=1">Board</a></div>
      <div>
      	<a href="${cpath }/Account/${empty login ? 'login.jsp' : 'logout.jsp' }">
      		${empty login ? 'Login' : 'Logout'}
      	</a>
      </div>
      <div>
      <a href="${cpath}/Account/signUp.jsp">SignUp</a>
      </div>
    </div>
  </header>