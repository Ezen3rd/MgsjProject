package com.project.order.domain;

public class OrderDetailDTO {
	
	private int orderNum; // [2] 여기로 들어온 키가
	private int pno;  // [3] 다시 여기로 역전됨
	private int productPrice;
	private int productCnt;
	private String orderStatus;
	
	// 이너 조인 값
	private String userId;
	private String productName;
	private int orderDate;
	
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCnt() {
		return productCnt;
	}
	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(int orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "OrderDetailDTO [orderNum=" + orderNum + ", pno=" + pno + ", productPrice=" + productPrice
				+ ", productCnt=" + productCnt + ", orderStatus=" + orderStatus + ", userId=" + userId
				+ ", productName=" + productName + ", orderDate=" + orderDate + "]";
	}
	
	
}
