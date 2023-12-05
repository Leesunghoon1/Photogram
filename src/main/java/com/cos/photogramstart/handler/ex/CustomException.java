package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	// 객체를 구분할 때 쓸 씨리얼번호
	

	
	public CustomException(String message) {
		super(message);
		//생성자
	}

}
