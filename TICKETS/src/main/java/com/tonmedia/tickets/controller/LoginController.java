package com.tonmedia.tickets.controller;



import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.tonmedia.tickets.domain.User;
import com.tonmedia.tickets.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	com.tonmedia.tickets.mapper.UserMapper UserMapper;
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//���� �α���
	@RequestMapping(value = "login.do", method = {RequestMethod.POST, RequestMethod.GET} )	
	@ResponseBody
	public int loginProc(User user, HttpServletRequest request ) {
		return this.loginService.loginProc(user , request );
	}
	
	// ȸ������ �� �ߺ� ���̵� üũ
	@ResponseBody
	@RequestMapping(value = "checkId.do", method = {RequestMethod.POST, RequestMethod.GET})	
	public int idCheck( User user ) {
		return this.loginService.checkId( user);
	}
	
	// ȸ������
	@ResponseBody
	@RequestMapping(value = "signup.do", method = {RequestMethod.POST, RequestMethod.GET})	
	public int signupProc( HttpServletRequest request, User user ) {
		return this.loginService.signupProc( request, user);
	}
	
	
	// ��й�ȣ ã�� �̸��� ����
	@ResponseBody
	@RequestMapping(value = "certification.do", method = {RequestMethod.POST, RequestMethod.GET})	
	public int emailcert( Model model, User user, HttpServletRequest request ) throws AddressException, MessagingException {
		return this.loginService.emailcert( model, user, request );
	}   
	
}
