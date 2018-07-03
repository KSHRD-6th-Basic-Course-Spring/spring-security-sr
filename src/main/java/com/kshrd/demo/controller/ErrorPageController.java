package com.kshrd.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {

	@GetMapping("/access-denied-page")
	public String accessDeniedPage() {
		return "access-denied-page";
	}
	
}
