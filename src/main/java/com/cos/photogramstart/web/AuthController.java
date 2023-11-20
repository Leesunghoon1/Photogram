package com.cos.photogramstart.web;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //1번째 방법 finul이 달린 모든생성자를 만들어줌
@Controller //1. ioc, 2.파일을 리턴하는 컨트롤러
public class AuthController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	
	@Autowired
	private final AuthService authService;
	
	/* 2번째 방법
	 * public AuthController(AuthService authService) { this.authService =
	 * authService; }
	 */
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		
		return "auth/signup";
	}
	
	//회원가입 버튼을 -> /auth/signup -> /auth/signin
	//회원가입 버튼x
	@PostMapping("/auth/signup")
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {// key-value
		
		/*
		 * if(signupDto.getUsername().length() > 20) { //
		 * signupDto.getUsername().length() 글자가 20자 보다 크면 // 이게 벨리데이션 체크
		 * System.out.println("너 길이 초과했어"); }
		 */
		
		if(bindingResult.hasErrors()) {
			
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			
		}
		
		
		log.info(signupDto.toString());
		//User <- signupDto
		User user = signupDto.toEntity();
		
		User userEntity = authService.회원가입(user);
		System.out.println(userEntity);
		return "auth/signin";
	}
}
