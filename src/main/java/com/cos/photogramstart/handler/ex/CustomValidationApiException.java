package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException{
	//똑같은거 하나 더만듬
	//

	
	private static final long serialVersionUID = 1L;
	// 객체를 구분할 때 쓸 씨리얼번호
	
	/* private String message; */
	private Map<String,String> errorMap;
	
	public CustomValidationApiException(String message) {
		super(message);
	}
	public CustomValidationApiException(String message, Map<String, String> errorMap) {
		super(message);
		//생성자
		/* this.message = message; */
		this.errorMap = errorMap;
	}
	
	public Map<String,String> getErrorMap() {
		return errorMap;
	}
	

}
