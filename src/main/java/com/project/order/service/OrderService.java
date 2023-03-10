package com.project.order.service;

import java.util.List;

import com.project.order.domain.OrderDTO;

public interface OrderService {

	// 주문 등록
	public void orderWrite(OrderDTO orderDTO) throws Exception;
	
	// 주문 조회
	public OrderDTO orderView(int orderNum) throws Exception;
	
	// 주문 수정
	public void orderUpdate(OrderDTO orderDTO) throws Exception;
	
	// 주문 삭제
	public void orderDelete(int orderNum) throws Exception;
	 
	// 주문 목록
	public List<OrderDTO> orderList(OrderDTO orderDTO) throws Exception;
	
	
}
