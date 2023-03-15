package com.project.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.member.domain.MemberAddressDTO;
import com.project.member.domain.MemberDTO;
import com.project.order.domain.OrderDTO;
import com.project.order.domain.OrderDetailDTO;
import com.project.order.service.OrderService;
import com.project.product.domain.CartDTO;
import com.project.product.service.CartService;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartService cartService;

	// 주문 작성 페이지
	@RequestMapping(value = "/order/orderPage", method = RequestMethod.GET)
	public String orderWritePage(String userId, CartDTO cartDTO, MemberAddressDTO memberAddressDTO, Model model, HttpServletRequest req)
			throws Exception {

		logger.info("주문 작성 페이지 orderWirtePage - Controller");

		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("memberInfo");

		cartDTO.setUserId(memberLoginSession.getUserId());

		MemberAddressDTO memadd = orderService.memAddress(userId);

		List<CartDTO> cartList = cartService.cartList(cartDTO);

		model.addAttribute("cartList", cartList);

		model.addAttribute("memberAddress", memadd);

		return "/order/orderPage";
	}

	// 주문 등록
	@RequestMapping(value = "/order/orderWrite", method = RequestMethod.POST)
	public String orderWrite(OrderDTO orderDTO) throws Exception {

		logger.info("주문 작성 orderWrite - Controller");

		orderService.orderWrite(orderDTO);

		return "redirect:/";
	}

	// 주문 수정
	@RequestMapping(value = "/order/orderUpdate", method = RequestMethod.POST)
	public String orderUpdate(OrderDTO orderDTO) throws Exception {

		logger.info("주문 수정 orderUpdate - Controller");

		orderService.orderUpdate(orderDTO);

		return "redirect:/order/main";
	}

	// 주문 삭제
	@ResponseBody
	@RequestMapping(value = "/order/orderDelete", method = RequestMethod.POST)
	public String orderDelete(int orderNum) throws Exception {

		logger.info("주문 삭제 orderDelete - Controller");

		orderService.orderDelete(orderNum);

		return "redirect:/order/orderList";
	}

	// 주문 내역 상세 조회
	@RequestMapping(value = "/order/orderView", method = RequestMethod.GET)
	public void orderView(HttpServletRequest req, Model model, OrderDetailDTO orderdetailDTO, String userId) throws Exception {

		logger.info("주문 조회 orderView - Controller");

		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("memberInfo");

		orderdetailDTO.setUserId(memberLoginSession.getUserId());

		OrderDetailDTO orderdetail = orderService.orderView(userId);

		model.addAttribute("orderDetailDTO", orderdetail);
	}

	// 주문 목록
	@RequestMapping(value = "/order/orderList", method = RequestMethod.GET)
	public void orderList(HttpServletRequest req, OrderDTO orderDTO, Model model) throws Exception {

		logger.info(" 주문 목록 orderList - Controller");

		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("memberInfo");

		orderDTO.setUserId(memberLoginSession.getUserId());

		List<OrderDTO> orderList = orderService.orderList(orderDTO);

		model.addAttribute("orderList", orderList);

	}

}
