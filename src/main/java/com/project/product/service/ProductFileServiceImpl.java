package com.project.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.product.dao.ProductFileDAO;
import com.project.product.domain.ProductFileDTO;

@Service
public class ProductFileServiceImpl implements ProductFileService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductFileServiceImpl.class);
	
	@Autowired
	private ProductFileDAO productFileDAO;
	
	// 제품 파일 업로드
	@Override
	public void productFileUpload(ProductFileDTO productFileDTO) throws Exception {
		
		logger.info("제품 파일 업로드 시작 productFileUpload - service : {}", productFileDTO);
		
		productFileDAO.productFileUpload(productFileDTO);
	}
}
