package com.tonmedia.tickets.controller;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.tonmedia.tickets.domain.Match;
import com.tonmedia.tickets.domain.Shipping;
import com.tonmedia.tickets.domain.Ticket;
import com.tonmedia.tickets.domain.User;
import com.tonmedia.tickets.service.ReservationService;
import com.tonmedia.tickets.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "reservation.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String reservationview( Model model, HttpServletRequest request, Match match, Ticket ticket, User user ) {
		return this.reservationService.view(model, request, match, ticket, user );
	}
	
	// 좌석선택 후 NEXT 버튼을 눌러 다음단계로 넘어갈때 
	@ResponseBody
	@RequestMapping(value = "insertseat.do", method = {RequestMethod.POST, RequestMethod.GET})
	public int insertSeat( Model model, Ticket ticket, HttpServletRequest request, Match match  ) {
		return this.reservationService.insertSeat(model, ticket, request, match );
	}

	// 구역 선택 시 해당 구역 seat정보 불러오기
	@ResponseBody
	@RequestMapping(value = "seatselect.do", method = {RequestMethod.POST, RequestMethod.GET})
	public Object seatSelect( Model model, HttpServletRequest request, Match match, Ticket ticket) {
		return this.reservationService.seatselect(model, request, match, ticket );
	}
	
	
	// 주문자 정보와 동일할 경우
	@ResponseBody
	@RequestMapping(value = "userselect.do", method = {RequestMethod.POST, RequestMethod.GET})
	public Object userSelect( HttpServletRequest request, User user   ) {
		return this.reservationService.userselect( request, user );
	}
	
	// 5분시간 초과로 인해 예매 취소(db에서 예매내역 delete) or 마이페이지 예매취소버튼
	@ResponseBody
	@RequestMapping(value = "seatdelete.do", method = {RequestMethod.POST, RequestMethod.GET})
	public Object seatDelete( Model model, HttpServletRequest request, Ticket ticket, Match match, Shipping shipping ) {
		return this.reservationService.seatDelete(model, request, ticket, match, shipping );
	}
	
		
}
