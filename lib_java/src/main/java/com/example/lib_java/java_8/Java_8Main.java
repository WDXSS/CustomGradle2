package com.example.lib_java.java_8;

public class Java_8Main {

	public static void main(String[] args) {
		Something something = new Something();
		//带有返回值的
		IConvert<String, String> convert = something::middleWith;
		convert.convert("Who am I? Where am I?");
		//没有返回值的
		IConvert2<String> convertEnd = something::endWith;
		convertEnd.convert("what's the happen?");
		//静态方法
		IConvert<String, String> convertStart = Something::startWith;
		convertStart.convert("Why??");

	}
}
