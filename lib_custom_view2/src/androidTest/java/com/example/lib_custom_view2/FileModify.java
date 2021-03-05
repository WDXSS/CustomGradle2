package com.example.lib_custom_view2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 修改文件内容
 */
public class FileModify {
	private static final String PATH = "/Users/ext.zhouchao3/AndroidStudioProjects/CustomGradle2/lib_custom_view2/src/main/java/com/example/book/";

	public static void main(String[] args) {
		FileModify obj = new FileModify();
		List<String> fileList = new ArrayList<String>();
		ReaderAndWriter.getFilesPath(PATH, fileList);
		for (String filePath : fileList) {
			String content = obj.read(filePath);
			System.out.println(content);
			obj.write(filePath, content); // 读取修改文件
//
//			try {
//				obj.fileAppender(filePath, "set a=b \n");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}

//		regularRule();
	}

	private static void regularRule(String text) {
		//单行注释，以//开始　
		String ruleOne = "^//.*?$";
		//单行注释，以//前面有一个或多个空格
		String ruleTwo = "\\s+//.*?$";
		// /**/ 多行注释
		String ruleThree = "/\\*[\\w\\W]*?\\*/";
		String ruleFour = "\\s+/\\*[\\w\\W]*?\\*/";


		String content = "//I am noob " + "from runoob.com.";
		String content2 = "     //I am noob " + "from runoob.com.";
//		String content3 = "/**\n" +
//				" * Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.\n" +
//				" */\n" +
//				"\r";

		String content3 = "/**\n" +
				" * Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.\n" +
				" */";
		String content32 = "/** Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.*/";
		String content4 = "       /** Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.*/";
		boolean isMatch = Pattern.matches(ruleOne, content);
		boolean isMatch2 = Pattern.matches(ruleTwo, content2);
		boolean isMatch3 = Pattern.matches(ruleThree, content3);
		boolean isMatch32 = Pattern.matches(ruleThree, content32);
		boolean isMatch4 = Pattern.matches(ruleFour, content4);

		System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
		System.out.println("字符串中是否包含了 'runoob2' 子字符串? " + isMatch2);
		System.out.println("字符串中是否包含了 'runoob3' 子字符串? " + isMatch3);
		System.out.println("字符串中是否包含了 'isMatch32' 子字符串? " + isMatch32);
		System.out.println("字符串中是否包含了 'isMatch4' 子字符串? " + isMatch4);
	}

	/**
	 * 读取文件并修改内容
	 *
	 * @param filePath
	 * @return
	 */
	public String read(String filePath) {
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();

		StringBuffer strNote = new StringBuffer();//注释的字符串
		boolean noteStart = false;
		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));
			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				System.out.println(line);

				if (line.startsWith("/**")) {
					noteStart = true;
				}
				if (line.endsWith("*/")) {
					strNote.append(line);
					strNote.append(System.getProperty("line.separator"));
					noteStart = false;
				}
				if (noteStart) {
					strNote.append(line);
					strNote.append(System.getProperty("line.separator"));
				}

				if (strNote.length() > 0) {
					System.out.println("注释：");
					System.out.println(strNote);
				}
				// class 前面没有注释 添加注释，有注释不添加
				if (!noteStart && strNote.length() == 0 && line.startsWith("public class")) {
					//如果类 有注释则不添加注释
					buf.append("/** \n  I am test \n */").append(System.getProperty("line.separator"));
					strNote.setLength(0);//清除数据
				}
				if (!noteStart && line.length() > 0 && !line.endsWith("*/")) {
					//注释的 下一行非空，
					strNote.setLength(0);//清除数据
				}

				// 此处根据实际需要修改某些行的内容
				if (line.startsWith("public class")) {
					buf.append(line);
				} else {
					// 如果不用修改, 则按原来的内容回写
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));//换行符，功能和"\n"是一致的,但是此种写法屏蔽了 Windows和Linux的区别 ，更保险一些.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
				}
			}
		}

		return buf.toString();
	}

	/**
	 * 将内容回写到文件中
	 */
	public void write(String filePath, String content) {
		BufferedWriter bw = null;
		try {
			// 根据文件路径创建缓冲输出流
			bw = new BufferedWriter(new FileWriter(filePath));
			// 将内容写入文件中
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					bw = null;
				}
			}
		}
	}

	/**
	 * 追加
	 *
	 * @param fileName
	 * @param content
	 * @throws IOException
	 */
	public void fileAppender(String fileName, String content) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		// 一行一行的读
		StringBuilder sb = new StringBuilder();
		sb.append(content);
		while ((line = reader.readLine()) != null) {
			sb.append(line);
			sb.append("\r\n");
		}
		reader.close();

		//写回去
		RandomAccessFile mm = new RandomAccessFile(fileName, "rw");
		mm.writeBytes(sb.toString());
		mm.close();
	}
}
