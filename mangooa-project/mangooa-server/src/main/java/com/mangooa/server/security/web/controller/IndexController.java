package com.mangooa.server.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Controller
@SuppressWarnings("unused")
public class IndexController {

	@GetMapping(path = "/")
	public ModelAndView index(ModelAndView vm) {
		vm.addObject("name","测试");
		vm.setViewName("index");
		return vm;
	}
}
