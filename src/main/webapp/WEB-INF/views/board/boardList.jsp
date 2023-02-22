<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" /> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록보기</title>
</head>
<body>


	<div align = "center">
		<table border = "1" >
			<thead>
				<tr class="warning">
					<th class="col-sm-1  text-center">번 호</th>
					<th class="col-sm-4  text-center">제 목</th>
					<th class="col-sm-1  text-center">작성자</th>
					<th class="col-sm-3  text-center">작성일자</th>
					<th class="col-sm-1  text-center">조회수</th>
				</tr>
			</thead>
			<tbody>
				<!-- 
				bno int userId varchar(20) 
				writer varchar(20) 
				title varchar(50)  
				content text 
				regDate datetime
				readCount int
				
				-->
				<c:forEach var="boardList" items="${boardList}">
					<tr>
						<td align="center">${boardList.bno}</td>
						<td align="center" title="${boardList.content}"><a href="#">${boardList.title}</a></td>
						<!-- <td class = "hidden">${notice.content}</td>-->
						<td align="center">${boardList.writer}</td>
						<td><fmt:formatDate value="${boardList.regDate}" pattern="yyyy-MM-dd" /></td>
						<td class="center">${boardList.readCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>