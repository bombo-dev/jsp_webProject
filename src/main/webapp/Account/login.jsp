<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


	<main>
		<fieldset id="loginForm">
			<legend>로그인</legend>
			
			<form action="loginPro.jsp" method="POST">
				<p><input name="id" placeholder="아이디 입력" required></p>
				<p><input name="pw" placeholder="패스워드 입력" type="password" required></p>
				
				<p id="loginBtn">
					<button>로그인</button>
					<button type="button">회원가입</button>
				</p>
			</form>
		</fieldset>
	</main>
<%@ include file="../footer.jsp" %>