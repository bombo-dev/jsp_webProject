<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

  <jsp:useBean id="dao" class="model.BoardDAO"/>
  <c:set var="map" value="${dao.selectAll(param.page) }"/>
  <c:set var="list" value="${map['list']}"/>
  <c:set var="page" value="${map['page']}"/>
  
  <main id="board" style="width:90%;">
    <table>
      <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일자</th>
      </tr>

	<c:forEach var="row" items="${list}">
      <tr>
        <td>${row.idx }</td>
           <td>
             <a href="${cpath}/Board/view.jsp?idx=${row.idx}">
            	${row.title }
             </a>
           </td>
        <td>${row.writer }</td>
        <td>${row.viewCount }</td>
        <td>${row.writeDate }</td>
         
      </tr>
    </c:forEach>
    </table>
    
    <br>

    <div id="search">
      <div>
      	<a href="${cpath }/Board/write.jsp">
      		<button>글 작성</button>
      	</a>
      </div>
      
      <div>
        <form action="">
          <input type="text">
          <button>검색</button>
        </form>
      </div>

      <div id="gap"></div>
    </div>

    <br>

    <div id="page">
      <div class="pageBtn">
      	<a href="board.jsp?page=${page.end - page.perSection}">
          ${page.prev ? '이전' : ''}
        </a>
      </div>
      
      <div>
      	<c:forEach var="n" begin="${page.begin }" end="${page.end}" step="1">
      		<span>
      		  <a href="board.jsp?page=${n }">
      			${n }
      		  </a>
      		</span>
      	</c:forEach>
      </div>
      
      <div class="pageBtn">
        <a href="board.jsp?page=${page.begin + page.perSection }">
          ${page.next ? '다음' : ''}
        </a>
      </div>
    </div>
  </main>

  <br>

<%@ include file="../footer.jsp" %>
