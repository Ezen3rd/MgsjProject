package com.project.product.dao;

import com.project.product.domain.ProductFileDTO;

public interface ProductFileDAO {
	
	// 파일 업로드
	public void productFileUpload(ProductFileDTO productFileDTO) throws Exception;
}
