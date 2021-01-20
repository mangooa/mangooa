package com.mangooa.server.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Controller
@SuppressWarnings("unused")
public class LoginController {

	@GetMapping(path = "/login")
	public String index() {
		return "index";
	}

}
