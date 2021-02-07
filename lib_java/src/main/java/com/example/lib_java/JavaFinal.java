package com.example.lib_java;

import java.util.Arrays;
import java.util.List;

/**
 * final 的变量可以 在构造方法中赋值
 */
public class JavaFinal {
	private static String[] mStrings = {"a", "b", "c"};

	public static void main(String[] args) {
		FinalTest test = new FinalTest("sss", mStrings);
		test.te();
	}


	private static class FinalTest {
		private final String[] strings;
		private final String title;
		private String content;
		private final String info = null;//final 必须赋值，或者在构造方法中赋值

		public FinalTest(String title, String[] strings) {
			this.strings = strings;
			this.title = title;
			System.out.println("strings = " + strings);
			System.out.println("title = " + title);
			content = "";
		}

		public void te() {
			List<String> list = Arrays.asList(strings);
			for (String s : list) {
				System.out.println("s = " + s);
			}
			content = "非构造方法中 ，赋值 不用定义为 final";
			System.out.println("title = " + title);
			System.out.println("content = " + content);
		}
	}
}
