package com.project.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.order.domain.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "mappers.orderMapper";
	
	// 주문 등록
	@Override
	public void orderWrite(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 등록 orderWrite - DAO");
		
		sqlSession.insert(NAME_SPACE + ".orderWrite", orderDTO);
	}
	// 주문 조회
	@Override
	public OrderDTO orderView(int orderNum) throws Exception {
		
		logger.info("주문 조회 orderView - DAO");
		
		
	return sqlSession.selectOne(NAME_SPACE + ".orderView", orderNum);
	}
	// 주문 수정
	@Override
	public void orderUpdate(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 수정 orderUpdate - DAO");
		
		sqlSession.update(NAME_SPACE + ".orderUpdate", orderDTO);
	}
	// 주문 삭제
	@Override
	public void orderDelete(int orderNum) throws Exception {
	
		logger.info("주문 삭제 orderDelete - DAO");
		
		sqlSession.delete(NAME_SPACE + ".orderDelete", orderNum);
	}
	// 주문 목록
	@Override
	public List<OrderDTO> orderList(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 목록 orderList - DAO");
		
		return sqlSession.selectList(NAME_SPACE + ".orderList", orderDTO);
	}
	

}
