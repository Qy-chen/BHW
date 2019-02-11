package com.bingsum.util;

import java.util.UUID;

public class UUIDHelper {

	public static String getUuid(){
		UUID uuid = UUID.randomUUID();  
		String str = uuid.toString().replace("-", "");
		return str.toUpperCase();
	}
	
//	public static void main(String[] args){
//		System.out.print(getUuid().length());
//	}
}
