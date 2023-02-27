<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
<style type="text/css">
div>input[name=userId] {
	border: none;
	pointer-events : none;
}
div>input[name=userName] {
	border: none;
	pointer-events : none;
}
div>input[name=userPhoneNumber] {
	border: none;
	pointer-events : none;
}

div>input[name=userId]:hover {
	border: none;
	pointer-events : none;
}
div>input[name=userName]:hover {
	border: none;
	pointer-events : none;
}
div>input[name=userPhoneNumber]:hover {
	border: none;
	pointer-events : none;
}
</style>
</head>
<body>
	<div class="container">
		<form action="/member/memberModify" method="post">
			<div title="아이디는 수정이 불가능합니다">
				<label for="id">아이디 : </label>
				<input type="text" id="userId" name="userId" value="${memberLogon.userId }" readonly="readonly" />
			</div>
			<div>
				<label for="password">비밀번호 : </label>
				<input type="password" id="userPwd" name="userPwd" value="${memberLogon.userPwd }" placeholder="비밀번호를 입력해주세요" />
			</div>
			<div title="이름은 수정이 불가능합니다">
				<label for="name">이름 : </label>
				<input type="text" id="userName" name="userName" value="${memberLogon.userName }" readonly="readonly" />
			</div>
			<div title="휴대전화번호 수정시 별도의 인증이 필요합니다">
				<label for="phoneNum">폰번 : </label>
				<input type="tel" id="userPhoneNumber" name="userPhoneNumber" value="${memberLogon.userPhoneNumber }" readonly="readonly" />
			</div>
			<div>
				<label for="email">이메일 : </label>
				<input type="email" id="userEmail" name="userEmail" value="${memberLogon.userEmail }" placeholder="수정할 이메일을 입력해주세요" />
			</div>
			<div title="성별은 수정이 불가능합니다">
				<!-- jstl if-else 문구 -->
				성별 :
				<c:choose>
					<c:when test="${memberLogon.userGender == 'F' }">
						<input type="radio" name="userGender" value="F" checked="checked" readonly="readonly">
						<label for="check"> 여 </label>
					</c:when>
					<c:otherwise>
						<input type="radio" name="userGender" value="M" checked="checked" readonly="readonly">
						<label for="check"> 남 </label>
					</c:otherwise>
				</c:choose>
			</div>
			<button type="submit">정보수정</button>
			<!-- onclick="confirmInfo()" -->
		</form>
	</div>
</body>
</html>