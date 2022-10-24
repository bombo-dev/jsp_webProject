<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

	<c:if test="${empty login}">
		<c:redirect url="/Account/login.jsp"/>
	</c:if>

	<main id="boardWrite">
		<form action="writePro.jsp" method="POST">
			<p><input name="title" placeholder="제목"></p>
			<p><input name="writer" type="hidden" value="${login.nick}"></p>
			<p><textarea name="contents"></textarea></p>
			
			<p><button>작성</button></p>
		</form>
	</main>
	
<%@ include file="../footer.jsp"%>