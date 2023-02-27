package com.project.product.domain;

public class CartDTO {
	private int cartNum;
	private int pno;
	private int productCnt;

	public int getCartNum() {
		return cartNum;
	}

	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
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
		return "CartDTO [cartNum=" + cartNum + ", pno=" + pno + ", productCnt=" + productCnt + "]";
	}

}
