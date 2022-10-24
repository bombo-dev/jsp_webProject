<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
	<jsp:useBean id="dao" class="model.BoardDAO"/>
	<c:set var="row" value="${dao.selectOne(param.idx)}"/>
	
	<main id="boardView">
    <h2>${row.title}</h2>
    <div id="info">
      작성자 : ${row.writer } | 조회수 ${row.viewCount} <br>
      작성일 : <fmt:formatDate value="${row.writeDate }" pattern="yyyy-MM-dd HH:mm"/>
    </div>

    <br>

    <fieldset>
      <pre>${row.contents }</pre>
    </fieldset>

    <br>
	<a href="${cpath }/Board/board.jsp">
    	<button>목록</button>
    </a>
  </main>
	
<%@ include file="../footer.jsp"%>