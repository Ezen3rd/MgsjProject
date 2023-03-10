package com.project.product.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.product.domain.ProductFileDTO;

@Repository
public class ProductFileDAOImpl implements ProductFileDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductFileDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "mappers.productFileMapper";
	
	@Override
	public void productFileUpload(ProductFileDTO productFileDTO) throws Exception {
		
		logger.info("제품 파일 업로드 시작 productFileUpload - DAO : {}", productFileDTO);
		
		sqlSession.insert(NAME_SPACE + ".productFileUpload", productFileDTO);
	}
}
