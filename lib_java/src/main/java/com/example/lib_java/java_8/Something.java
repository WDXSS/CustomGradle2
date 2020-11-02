package com.example.lib_java.java_8;

/**
 * JAVA 8 '::' 关键字
 * https://blog.csdn.net/kegaofei/article/details/80582356
 */
public class Something {

	public static String startWith(String start) {
		System.out.println("startWith start = " + start);
		return "startWith";
	}

	public void endWith(String end) {
		System.out.println("endWith end = " + end);

	}

	public String middleWith(String middle) {
		System.out.println("middleWith middle = " + middle);
		return "middleWith";
	}
}
