package com.my.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		String[] area6 = {"香港", "澳门", "台湾"};
		String s = "江苏省";
		//System.out.println(Arrays.asList(area6).contains("香港"));
//		System.out.println(s.endsWith("省"));
		String originProvice = "江苏省";
		int index = originProvice.indexOf("省");
		originProvice= originProvice.substring(0, index);
		System.out.println(originProvice);
	}

}
