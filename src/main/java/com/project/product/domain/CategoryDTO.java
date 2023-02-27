package com.project.product.domain;

public class CategoryDTO {

	private int cno;
	private String categoryName;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryDTO [cno=" + cno + ", categoryName=" + categoryName + "]";
	}

}
