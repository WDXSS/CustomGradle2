package com.example.lib_java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {


	public static void main(String[] args) {
		RegexMain regexMain = new RegexMain();
//		regexMain.regexTest1();
//		regexMain.regexReplaceAll();
		regexMain.regexStartAndEnd();
	}


	private void regexTest1() {
		String regexTest1 = "[1234567890]+";
		String regexTest2 = "(\\d)+";
		String str = "as1234pppp6789";
//		String str = "1234";
		Pattern p = Pattern.compile(regexTest2);
		Matcher m = p.matcher(str);
		boolean find = m.find();
		System.out.println("find = " + find);
		int end = m.end();
		System.out.println("end = " + end);
		int start = m.start();
		System.out.println("start = " + start);
		String group = m.group();
		System.out.println("group = " + group);
		int groupCount = m.groupCount();
		for (int i = 0; i < groupCount; i++) {
			System.out.println("group[" +i +"] = " + m.group(i));
		}
	}
	//通过 replaceAll 剔除 数据
	private void regexReplaceAll() {
		//起始位置和结束位置
		String regexStart = "^(\\d)+(\\d)";
		String regEx="[^0-9]+";//非数字
		String str = "1234 pppp 6789";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean find = m.find();
		System.out.println("find = " + find);
		int end = m.end();
		System.out.println("end = " + end);
		int start = m.start();
		System.out.println("start = " + start);
		String group = m.group();
		System.out.println("group = " + group);
		int groupCount = m.groupCount();
		for (int i = 0; i < groupCount; i++) {
			System.out.println("group[" +i +"] = " + m.group(i));
		}
		String result = m.replaceAll(" ");
		System.out.println("result = " + result);
	}

	private void regexStartAndEnd() {
		//起始位置和结束位置
//		String regexStart = "^(\\d\\D)+9$";
		String regexStart = "^(\\d{3})-(\\d{3,8})$";
		String str = "010-12345";
		Pattern p = Pattern.compile(regexStart);
		Matcher m = p.matcher(str);
		boolean find = m.find();
		System.out.println("find = " + find);
		int end = m.end();
		System.out.println("end = " + end);
		int start = m.start();
		System.out.println("start = " + start);
		String group = m.group();
		System.out.println("group = " + group);
		int groupCount = m.groupCount();
		for (int i = 0; i < groupCount; i++) {
			System.out.println("group[" +i +"] = " + m.group(i));
		}
		String result = m.replaceAll(" ");
		System.out.println("result = " + result);
	}
}
