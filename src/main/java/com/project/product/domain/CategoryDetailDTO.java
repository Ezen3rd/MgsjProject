package com.project.product.domain;

public class CategoryDetailDTO {

	private int cdno;
	private int cno;
	private String cdTitle;

	public int getCdno() {
		return cdno;
	}

	public void setCdno(int cdno) {
		this.cdno = cdno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	@Override
	public String toString() {
		return "CategoryDetailDTO [cdno=" + cdno + ", cno=" + cno + ", cdTitle=" + cdTitle + "]";
	}

}
