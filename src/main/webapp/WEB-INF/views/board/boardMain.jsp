<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.project.member.domain.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리다이렉트페이지</title>
</head>
<body>
	여기까지오면 일단 당신이 하는 작업은 성공한겁니다!! (따봉)
	<br>
	<!-- 일반유저 계정 -->
	<%
	MemberDTO memberLogon = (MemberDTO)session.getAttribute("memberLogon");
	
	if(memberLogon == null){
	%>
		<a href="/member/memberLoginPage">로그인하러가기</a>
		<a href="/member/memberSignUp">회원가입</a>
	<%
	} else {
		
		if(memberLogon.getUserVerify() == 128){
	%>
			<a href="/board/adminBoardList">관리자게시판</a><br>
			<a href="javascript:memberLogout()">관리자 계정 로그아웃</a>
	<%
		} else {
	%>
			<a href="/member/memberModifyPage">회원정보수정</a>
			<br>
			<a href="/board/memberBoardList">회원게시판</a>
			<br>
			<a href="javascript:memberLogout()">로그아웃</a>
	<%
		}
	}
	%>
	
</body>
<script type="text/javascript">
	function memberLogout() {
		let logoutYN = confirm("로그아웃 하시게용?");
		
		if(logoutYN == true){
			alert("로그아웃이 됫서용");
			location.href = "/member/memberLogout"; 	/* 세션 invalidate */
			location.href = "/member/memberLoginPage"; 	/* 로그인페이지 */
		} else {
			alert("로그아웃 취소댓서용");
		}
	}
</script>
</html>