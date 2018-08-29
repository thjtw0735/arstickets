package com.tonmedia.tickets.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tonmedia.tickets.domain.User;
import com.tonmedia.tickets.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "main.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String directToLogin( /*@RequestParam(value="session", required=false)*/ String session, Model model, HttpServletRequest request, User user ) throws Exception {
		return this.mainService.mainProc(session, model, request, user);
	}
}
