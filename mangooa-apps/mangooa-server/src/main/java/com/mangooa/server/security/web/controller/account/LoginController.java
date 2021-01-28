package com.mangooa.server.security.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录控制器。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Controller
@RequestMapping(path = "/account/login")
@SuppressWarnings("unused")
public class LoginController {

	/**
	 * 跳转到登录页面。
	 */
	@GetMapping
	public ModelAndView login(ModelAndView mv) {
		mv.addObject("username", "admin");
		mv.addObject("password", "admin");
		mv.setViewName("account/login");
		return mv;
	}

	@PostMapping
	public ModelAndView submit(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("index");
		return mv;
	}

}
