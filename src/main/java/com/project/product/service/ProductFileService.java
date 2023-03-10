package com.project.product.service;

import com.project.product.domain.ProductFileDTO;

public interface ProductFileService {
	
	// 제품 파일 업로드
	public void productFileUpload(ProductFileDTO productFileDTO) throws Exception;
}
