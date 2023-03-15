<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 액션(코어)태그 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- EL태그로 쓸것을 미리 만들어놓는 좋은 습관 기억하자 -->
<%
request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>장바구니 등록</title>
</head>
<body>

		<!-- 
			cartNum	int	NO PRI Auto increament
			pno	int	NO	PRI
			productCnt	int	NO	
 		-->
	<div class="container" align="center">
			<form class="form-horizontal" action="/cart/cartWrite" method="post">
			<div class="form-group">
				<div class="col-sm-12">
					<h2 align="center">장바구니 등록</h2>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">제품 번호</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value = "${productDTO.pno}" name="pno" readonly="readonly"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">제품 이름</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value = "${productDTO.productName}" readonly="readonly"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">제품 가격</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" value = "${productDTO.productPrice}" readonly="readonly"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">주문 수량</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" name = "productCnt" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 left">
					<button type="submit" class="btn btn-primary">주문 하기</button>
					<button type="button" class="btn btn-danger" onClick = "location.href = '/product/productList'">계속 주문하기</button>
				</div>
			</div>
		</form>
	</div>
	

</body>
</html>