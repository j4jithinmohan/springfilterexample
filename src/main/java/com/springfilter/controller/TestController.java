package com.springfilter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "test/")
public class TestController {

	@RequestMapping(value = "doFilter", method = RequestMethod.GET)
	public String getTestFilter() {
		System.out.println("Test Controller");
		return null;
	}
}
