package com.project.product.domain;

import java.util.Arrays;
import java.util.Date;

public class ProductFileDTO {

	private int productFileNumber;
	private String originFileName;
	private String storedFileName;
	private String storedThumbNail;
	private byte[] fileSize;
	private Date fileRegDate;
	
	// 오버로딩시 기본생성자 선언은 반드시!!
	public ProductFileDTO() {
		// 기본생성자
	}
	
	// 컨트롤러에서 보내주는 정보
	public ProductFileDTO(String originFileName, String storedFileName, String storedThumbNail) {
		
		this.originFileName = originFileName;
		this.storedFileName = storedFileName;
		this.storedThumbNail = storedThumbNail;
		
	}
	
	// 서비스단에서 받아내는 생성자의 역할
	public ProductFileDTO(int productFileNumber, String originFileName, String storedFileName, String storedThumbNail) {
		
		this.productFileNumber = productFileNumber;
		this.originFileName = originFileName;
		this.storedFileName = storedFileName;
		this.storedThumbNail = storedThumbNail;
		
	}

	public int getProductFileNumber() {
		return productFileNumber;
	}

	public void setProductFileNumber(int productFileNumber) {
		this.productFileNumber = productFileNumber;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public String getStoredThumbNail() {
		return storedThumbNail;
	}

	public void setStoredThumbNail(String storedThumbNail) {
		this.storedThumbNail = storedThumbNail;
	}

	public byte[] getFileSize() {
		return fileSize;
	}

	public void setFileSize(byte[] fileSize) {
		this.fileSize = fileSize;
	}

	public Date getFileRegDate() {
		return fileRegDate;
	}

	public void setFileRegDate(Date fileRegDate) {
		this.fileRegDate = fileRegDate;
	}

	@Override
	public String toString() {
		return "ProductFileDTO [productFileNumber=" + productFileNumber + ", originFileName=" + originFileName + ", storedFileName=" + storedFileName
				+ ", storedThumbNail=" + storedThumbNail + ", fileSize=" + Arrays.toString(fileSize) + ", fileRegDate=" + fileRegDate + "]";
	}
	
}
