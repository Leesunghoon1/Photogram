package com.cos.photogramstart.util;

import java.util.Map;

public class Script {
	
	public static String back(String string) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert("+string+");");
		sb.append("history.back();");
		sb.append("<script>");
		
		return sb.toString();
	}

}
