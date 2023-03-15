package com.project.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.member.domain.MemberDTO;
import com.project.order.domain.OrderDTO;
import com.project.order.domain.OrderDetailDTO;
import com.project.order.domain.PaymentDTO;
import com.project.order.service.OrderService;
import com.project.order.service.PaymentService;

@Controller
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrderService orderService;
	
	//결제 페이지
	@RequestMapping(value = "/payment/paymentPage", method = RequestMethod.GET)
	public String paymentPage(
			String userId,
			OrderDetailDTO OrderdetailDTO,	
			Model model,
			HttpServletRequest req) throws Exception {
		
		logger.info("결제 페이지 paymentPage - Controller");
		
		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("memberInfo");
		
		OrderdetailDTO.setUserId(memberLoginSession.getUserId());
		
		OrderDetailDTO Orderdetail = orderService.orderView(userId);
		
		model.addAttribute("OrderdetailDTO", Orderdetail);

		return "/payment/paymentPage";
	}
	
	//결제 등록
	@RequestMapping(value = "/payment/paymentWrite", method = RequestMethod.POST)
	public String paymentWrite(PaymentDTO paymentDTO) throws Exception {
		
		logger.info("결제 등록 paymentWrite - Controller");
		
		paymentService.paymentWrite(paymentDTO);
		
		return "/payment/paymentList";
	}
	
	//결제 내역 조회
	@RequestMapping(value = "/payment/paymentView", method = RequestMethod.GET)
	public void paymentView(
			HttpServletRequest req,
			Model model,
			PaymentDTO paymentDTO, 
			String userId) throws Exception {
		
		logger.info("결제 상세 내역 paymentView - Controller");
		
		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("memberInfo");
		
		paymentDTO.setUserId(memberLoginSession.getUserId());
		
		paymentDTO = paymentService.paymentView(userId);
		
		model.addAttribute("paymentDTO", paymentDTO);
		// 에러나면 redirect:/
		//return "/payment/paymendPage";
	}
	
	//결제 내역 목록
	@RequestMapping(value = "/payment/paymentList", method = RequestMethod.GET)
	public void paymentList(HttpServletRequest req, PaymentDTO paymentDTO, Model model) throws Exception {
		
		logger.info("결제 내역 목록 paymentList - Controller");
		
		HttpSession session = req.getSession();

		MemberDTO memberLoginSession = (MemberDTO) session.getAttribute("memberInfo");

		paymentDTO.setUserId(memberLoginSession.getUserId());

		List<PaymentDTO> paymentList = paymentService.paymentList(paymentDTO);
		
		model.addAttribute("paymentList", paymentList);

	}
	
	//관리자의 결제내역 삭제? 결제내역 수정?
	
	
}
