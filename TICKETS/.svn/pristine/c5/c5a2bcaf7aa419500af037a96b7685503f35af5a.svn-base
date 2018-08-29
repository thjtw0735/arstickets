package com.tonmedia.tickets.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tonmedia.tickets.domain.Match;
import com.tonmedia.tickets.domain.Shipping;
import com.tonmedia.tickets.domain.TimeCheck;
import com.tonmedia.tickets.domain.User;
import com.tonmedia.tickets.service.MypageService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//마이페이지 view
	@RequestMapping(value = "mypage.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String redirectToLogin( Model model, HttpServletRequest request, Shipping shipping, Match match  ){
		
		return this.mypageService.main(model, request, shipping, match );
	}
	
	//shipping table에 들어갈 배송 및 경기 정보 insert
	@ResponseBody
	@RequestMapping(value = "mpinsert.do", method = {RequestMethod.POST, RequestMethod.GET})
	public Object MypageInsert( Model model, HttpServletRequest request, Shipping shipping, TimeCheck timeCheck ){
		
		return this.mypageService.shippinginsert(model, request, shipping, timeCheck);
	}
}
