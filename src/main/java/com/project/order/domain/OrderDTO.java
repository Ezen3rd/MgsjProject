package com.project.order.domain;

import java.util.Date;

public class OrderDTO {

	private int orderNum;
	private int userNum;
	private String userId;
	private Date orderDate;
	private String postAddress;
	private String detailAddress;
	private String detailAddress2;
	private String recipient;
	private String recipientPhone;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getDetailAddress2() {
		return detailAddress2;
	}

	public void setDetailAddress2(String detailAddress2) {
		this.detailAddress2 = detailAddress2;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderNum=" + orderNum + ", userNum=" + userNum + ", userId=" + userId + ", orderDate=" + orderDate + ", postAddress="
				+ postAddress + ", detailAddress=" + detailAddress + ", detailAddress2=" + detailAddress2 + ", recipient=" + recipient
				+ ", recipientPhone=" + recipientPhone + "]";
	}

}
