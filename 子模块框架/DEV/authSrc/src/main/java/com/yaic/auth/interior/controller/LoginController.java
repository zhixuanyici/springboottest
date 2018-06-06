package com.yaic.auth.interior.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value="/login")
	public String login(){
		System.out.println("askdjfklsfjslaf");
		return "dklsjfaljf";
	}
}
