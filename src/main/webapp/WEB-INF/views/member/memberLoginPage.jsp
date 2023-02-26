<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버로그인페이지</title>
</head>
<body>
	<form action="/member/memberLogin" method="post">
		<div>
			<label for="id">아이디</label>
			<input type="text" id="userId" name="userId" />
		</div>
		<div>
			<label for="password">비밀번호</label>
			<input type="password" id="userPwd" name="userPwd"/>
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
	<a href="/member/memberSignUp"><button>회원가입</button></a>
</body>
</html>