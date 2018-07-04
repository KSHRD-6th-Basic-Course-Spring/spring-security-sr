package com.kshrd.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/admin")
	public String admin() {
		return "admin/index";
	}
	
	@GetMapping("/editor")
	public String editor() {
		return "editor/index";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user/index";
	}
	
	@GetMapping("/user/profile")
	public String profile() {
		return "user/profile";
	}
	
	@GetMapping("/")
	public String guest() {
		return "guest/index";
	}

	@Autowired
	BCryptPasswordEncoder b;
	
	@GetMapping("/encrypt")
	@ResponseBody
	public String encrypt(String pw) {
		return b.encode(pw);
	}
	
}












