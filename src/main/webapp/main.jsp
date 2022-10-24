<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main>
    <div id="banner">
      <img src="${cpath}/src/banner.jpeg" alt="배너 이미지">
    </div>

    <div id="main">
      <div id="side">

        <fieldset id ="user">
          <legend>계정</legend>

		<c:if test="${empty login}">
          <div>
          	<a href=${cpath}/Account/Login.jsp>
            	<button>로그인</button>
            </a>
            <a href=${cpath}/Account/signUp.jsp>
            	<button>회원가입</button>
            </a>
          </div>
        </c:if>
        
        <c:if test="${not empty login}">
        	<div style="text-align: left">
        		<p>회원 번호 : ${login.idx} </p>
        		<p>닉네임 : ${login.nick} (${login.joinDate})</p>
        	</div>
        </c:if>
        </fieldset>

        <ul>
          <li>전체 게시글</li>
          <li>공지사항</li>
          <li>가입 인사</li>
          <li>자유 게시판</li>
          <li>질문 게시판</li>
        </ul>
      </div>

	<%-- board 게시글 가져오기 --%>
	<jsp:useBean id="dao" class="model.BoardDAO"/>
	
	<c:set var="list" value="${dao.selectAll()}"/>

      <div id="board">
        <table>
          <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일자</th>
          </tr>

		 <%-- <c:forEach var="row" items="${list}"> --%>
		 <c:forEach var="i" begin="0" end="24" step="1">
          <tr>
            <td>${list[i].idx }</td>
            <td>
            	<a href="${cpath}/Board/view.jsp?idx=${list[i].idx}">
            		${list[i].title }
            	</a>
            </td>
            <td>${list[i].writer }</td>
            <td>${list[i].viewCount }</td>
            <td>${list[i].writeDate }</td>
            
            <%-- 나중에 글을 눌렀을 때 나오게 사용 --%>
            <%-- <td><fmt:formatDate value="${row.writeDate }" pattern="yyyy-MM-dd HH:mm"/></td> --%>
          </tr>
          </c:forEach>
          
        </table>

        <br>
        <div>
       		<a href="${cpath }/Board/board.jsp?page=1">
        		<button>전체 게시글</button>
        	</a>
        </div>
        
      </div>
    </div>
  </main>

<%@ include file="footer.jsp" %>