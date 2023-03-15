package com.project.order.domain;

public class OrderTempDTO {

	private String userId;
	private int pno;
	private int productCnt;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getProductCnt() {
		return productCnt;
	}
	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}
	
	@Override
	public String toString() {
		return "OrderTempDTO [userId=" + userId + ", pno=" + pno + ", productCnt=" + productCnt + "]";
	}
	
	
	
}
