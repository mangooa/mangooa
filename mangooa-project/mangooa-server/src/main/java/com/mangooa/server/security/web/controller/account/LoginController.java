package com.mangooa.server.security.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping
	public String login() {
		return "account/login";
	}

	@PostMapping
	public String index() {
		return "redirect:index";
	}

}
