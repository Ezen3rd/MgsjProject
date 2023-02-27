<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.project.member.domain.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>

<style type="text/css">
input {
	border: none;
}

input:hover {
	pointer-events: none;
}

input:focus {
	border: none;
}

input:visited {
	border: none;
}

textarea {
	resize: none;
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
	<h1>${boardDTO.bno }번공지게시글</h1>
	<%
	} else {
	%>
	<h1>${boardDTO.bno }번게시글</h1>
	<%
	}
	%>

	<div>
		<label>게시글 제목 : </label>
		<input type="text" name="title" value="${boardDTO.title }" readonly="readonly">
	</div>

	<hr>
	<br>

	<div>
		<label>작성자 : </label>
		<input type="text" name="writer" value="${boardDTO.writer }" readonly="readonly">
		<br>
	</div>
	<div style="font-size: 2px;">
		<label>아이디 : </label>
		<input style="font-size: 2px;" type="text" name="userId" value="${boardDTO.userId }" readonly="readonly">
	</div>

	<hr>
	<br>

	<div>
		<label>내용</label>
	</div>
	
	<br>

	<textarea rows="5" cols="50" class="boardTextarea" name="content" maxlength="2000" readonly="readonly">${boardDTO.content }</textarea>

	<br>
	<%
	if (memberInfo.getUserVerify() == 128) {
	%>
	<button type="submit" onclick="location.href='/board/boardModifyPage?bno=${boardDTO.bno}'">공지글 수정하기</button>
	<%
	} else {
	%>
	<button type="submit" onclick="location.href='/board/boardModifyPage?bno=${boardDTO.bno}'">게시글 수정하기</button>
	<%
	}
	%>

</body>
</html>