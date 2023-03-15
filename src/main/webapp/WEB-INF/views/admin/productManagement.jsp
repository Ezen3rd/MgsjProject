<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.project.board.domain.PageIngredient" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 관리 페이지</title>
</head>
<link rel="stylesheet" type="text/css" href="/resources/admin/adminPage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
	<div id="boardGroup">
		<h1>상품 목록</h1>
		<table>
			<thead>
				<tr>
					<th style="width: 80px;">상품번호</th>
					<th style="width: 300px;">상품이름</th>
					<th style="width: 150px;">판매자</th>
					<th style="width: 150px;">상품가격</th>
					<th style="width: 150px;">상품재고</th>
					<th style="width: 80px;">상품등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${adminBoardList }" var="adminBoardList">
					<tr>
						<td>${adminBoardList.bno }</td>
						<td>
							<a href="/admin/boardView?bno=${adminBoardList.bno }">${adminBoardList.title }</a>
						</td>
						<td>${adminBoardList.writer }</td>
						<td>
							<fmt:formatDate value="${adminBoardList.regDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>${adminBoardList.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 게시글 검색기능 -->
		<%
		PageIngredient pageIngredient = (PageIngredient) request.getAttribute("page");
		%>
		<div>
			<select class="searchType" name="searchType" onchange="changeInputTag();">
				<option value="userId" <%=pageIngredient.getSearchType().equals("userId") ? "selected" : ""%>>제목</option>
				<option value="content" <%=pageIngredient.getSearchType().equals("content") ? "selected" : ""%>>내용</option>
				<option value="title_and_content" <%=pageIngredient.getSearchType().equals("title_and_content") ? "selected" : ""%>>제목+내용</option>
				<option value="writer" <%=pageIngredient.getSearchType().equals("writer") ? "selected" : ""%>>작성자</option>
			</select>
			<input type="text" id="keyword" class="keyword" name="keyword" value="<%=pageIngredient.getKeyword()%>" onkeyup="enterSearching();">
			<button id="searchingActivate" type="button" onclick="searchingActivate();">검색</button>
		</div>
		<!-- 게시글 검색기능 끝 -->

		<!-- 페이징 시작 -->
		<%
		int selectedPageNum = (int) request.getAttribute("selectedPageNum");

		/* 이전페이지 버튼만들기 */
		if (pageIngredient.isPrevPage() == true) {
		%>
		<span>
			<a href="/announcement/announcement?pageNum=<%=pageIngredient.getStartPage() - 1%><%=pageIngredient.getSearchTypeAndKeyword()%>">◀이전</a>
		</span>
		<%
		}

		/* 페이지 쫙(1,2,3,4...) 출력하기 */
		for (int i = pageIngredient.getStartPage(); i <= pageIngredient.getEndPage(); i++) {

		if (selectedPageNum != i) {
		%>
		<span>
			<a id="notSelectedPage" href="/announcement/announcement?pageNum=<%=i%><%=pageIngredient.getSearchTypeAndKeyword()%>"><%=i%></a>
		</span>
		<%
		} else if (selectedPageNum == i) {
		%>
		<span>
			<b style="font-size: 22px"><%=i%></b>
		</span>
		<%
		}
		}

		/* 다음버튼 만들기 */
		if (pageIngredient.isNextPage() == true) {
		%>
		<span>
			<a href="/announcement/announcement?pageNum=<%=pageIngredient.getEndPage() + 1%><%=pageIngredient.getSearchTypeAndKeyword()%>">다음▶</a>
		</span>
		<%
		}
		%>
		<!-- 페이징 끝 -->
	</div>
</body>
<script type="text/javascript" src="/resources/admin/member/adminMember.js"></script>
</html>