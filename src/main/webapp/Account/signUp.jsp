<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


	<main>
		<fieldset id="loginForm">
			<legend>회원가입</legend>
			
			<form action="signUpPro.jsp" method="POST">
				<p><input name="id" placeholder="아이디 입력" required></p>
				<p><input name="pw" placeholder="패스워드 입력" type="password" required></p>
				<p><input name="nick" placeholder="닉네임 입력"  required></p>
				<p><input name="name" placeholder="이름 입력"  required></p>
				<p>
					<span>생년월일</span>
					<input name="birth" type="date" required>
				</p>
				<p><input name="phone" placeholder="연락처"></p>
				<p><input name="email" placeholder="이메일 입력"  required></p>
				
				<p id="loginBtn">
					<button>회원가입</button>
					<button onclick="history.go(-1)">뒤로가기</button>
				</p>
			</form>
		</fieldset>
	</main>
<%@ include file="../footer.jsp" %>