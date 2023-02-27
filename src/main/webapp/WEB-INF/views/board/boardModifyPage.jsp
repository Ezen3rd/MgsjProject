<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.project.member.domain.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정하기</title>
<style type="text/css">
input[name=userId] {
	border: none;
}

input[name=userId]:hover {
	border: none;
	pointer-events: none;
}
</style>
</head>
<body>
	<!-- 
		private int bno;
		private String userId;
		private String writer;
		private String title;
		private String content;
		private Date regDate;
		private int readCount;
	 -->
	<%
	MemberDTO memberInfo = (MemberDTO) session.getAttribute("memberLogon");

	if (memberInfo.getUserVerify() == 128) {
	%>
	<h1>${boardDTO.bno }번공지게시글 수정</h1>
	<%
	} else {
	%>
	<h1>${boardDTO.bno }번게시글 수정</h1>
	<%
	}
	%>
	<form action="/board/boardModify" method="post">
		<div>
			<label>게시글 제목 : </label>
			<input type="text" name="title" value="${boardDTO.title }">
		</div>

		<hr>
		<br>

		<div>
			<label>작성자 : </label>
			<input type="text" name="writer" value="${boardDTO.writer }">
			<br>
		</div>
		<div style="font-size: 2px;" title="아이디는 수정이 불가능합니다">
			<label>아이디 : </label>
			<input style="font-size: 2px;" type="text" name="userId" value="${boardDTO.userId }" readonly="readonly">
		</div>

		<hr>
		<br>

		<div>
			<label>내용</label>
		</div>

		<br>
		<textarea rows="5" cols="50" class="boardTextarea" name="content" maxlength="2000">${boardDTO.content }</textarea>
		<br>

		<%
		if (memberInfo.getUserVerify() == 128) {
		%>
		<button type="submit">공지글 수정하기</button>
		<%
		} else {
		%>
		<button type="submit">게시글 수정하기</button>
		<%
		}
		%>
	</form>

</body>
</html>