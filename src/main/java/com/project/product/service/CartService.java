package com.project.product.service;

import java.util.List;

import com.project.product.domain.CartDTO;

public interface CartService {

	//장바구니 등록
	public void cartWrite(CartDTO cartDTO) throws Exception;
	
	//장바구니 수정
	public void cartUpdate(CartDTO cartDTO) throws Exception;
	
	//장바구니 삭제
	public void cartDelete(int pno) throws Exception;
	
	//장바구니 목록
	public List<CartDTO> cartList(CartDTO cartDTO) throws Exception;
	
}
