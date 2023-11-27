package com.cos.photogramstart.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHanlder {
	
	
	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) {
		
		//CMRespDto.Script비교ㅕ
		//1.클라이언트에게 응답할 때는 Script좋음
		//2.Ajax 통신 - CMRespDto
		//3.Android통신 - CMRespDto
		
		return Script.back(e.getErrorMap().toString());
	}
	
	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<CMRespDto<?>> validationApiException(CustomValidationApiException e) {
		
		//CMRespDto.Script비교ㅕ
		//1.클라이언트에게 응답할 때는 Script좋음
		//2.Ajax 통신 - CMRespDto
		//3.Android통신 - CMRespDto
		
		
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
				
	}
	
	@ExceptionHandler(CustomApiException.class)
	public ResponseEntity<CMRespDto<?>> apiException(CustomValidationApiException e) {
		
		//CMRespDto.Script비교ㅕ
		//1.클라이언트에게 응답할 때는 Script좋음
		//2.Ajax 통신 - CMRespDto
		//3.Android통신 - CMRespDto
		
		
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
				
	}
}
