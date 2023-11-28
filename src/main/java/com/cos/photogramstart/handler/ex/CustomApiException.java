package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomApiException extends RuntimeException{
	//똑같은거 하나 더만듬
	//

	
	private static final long serialVersionUID = 1L;
	// 객체를 구분할 때 쓸 씨리얼번호
	
	public CustomApiException(String message) {
		super(message);
	}

	
	

}
