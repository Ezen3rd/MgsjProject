package com.project.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.order.dao.OrderDAO;
import com.project.order.domain.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDAO orderDAO;
	
	// 주문 등록
	@Override
	public void orderWrite(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 등록 orderWrite - Service");
		
		orderDAO.orderWrite(orderDTO);
	}
	
	// 주문 조회
	@Override
	public OrderDTO orderView(int orderNum) throws Exception {
	
		logger.info("주문 조회 orderView - Service");
		
		return orderDAO.orderView(orderNum);
	}
	
	// 주문 수정
	@Override
	public void orderUpdate(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 수정 orderUpdate - Service");
		
		orderDAO.orderUpdate(orderDTO);
	}
	// 주문 삭제
	@Override
	public void orderDelete(int orderNum) throws Exception {
		
		logger.info("주문 삭제 orderDelete - Service");
		
		orderDAO.orderDelete(orderNum);
	}
	// 주문 목록
	@Override
	public List<OrderDTO> orderList(OrderDTO orderDTO) throws Exception {
		
		logger.info("주문 목록 orderList - Service");
		
		return orderDAO.orderList(orderDTO);
	}
	
	
}
