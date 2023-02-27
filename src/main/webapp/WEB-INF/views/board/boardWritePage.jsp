<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.project.member.domain.MemberDTO"%>
<!DOCTYPE html>
<%
MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberLogon");
%>
<html>
<head>
<meta charset="UTF-8">
<%
if (memberInfo.getUserVerify() == 128) {
%>
<title>공지 게시글 조회</title>
<%
} else {
%>
<title>게시글 조회</title>
<%
}
%>
</head>
<body>
	<%
	if (memberInfo.getUserVerify() == 128) {
	%>
	<h1>공지글 작성하기</h1>
	<%
	} else {
	%>
	<h1>게시글 작성하기</h1>
	<%
	}
	%>
	<form method="post" action="/board/boardWrite">

		<div>
			<label>게시글 제목 : </label>
			<input type="text" name="title">
		</div>

		<hr>
		<br>

		<div>
			<label>작성자 : </label>
			<input type="text" name="writer">
			<br>
		</div>
		<div>
			<label>아이디 : </label>
			<input type="text" name="userId" value="${memberLogon.userId }" readonly="readonly">
		</div>

		<hr>
		<br>

		<div>
			<label>내용</label>
		</div>

		<br>
		<textarea rows="5" cols="50" class="boardTextarea" name="content" maxlength="2000"></textarea>
		<br>

		<%
		if (memberInfo.getUserVerify() == 128) {
		%>
		<button type="submit">공지올리기</button>
		<%
		} else {
		%>
		<button type="submit">게시글 작성하기</button>
		<%
		}
		%>
	</form>

</body>
</html>