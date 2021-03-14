package com.example.lib_custom_view2;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * 注释规范
 * 为Java文件头部加上注释
 * <p>
 * 例如 ： Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.
 *
 * @author Godsname
 * @since 2020-04
 */
public class AnnotationSpecifications {
	//扫描的文件目录
	static final String PATH = "/Users/ext.zhouchao3/AndroidStudioProjects/CustomGradle2/lib_custom_view2/src/main/java/com/example/book/";
	//为表头添加的注释
	static final String CONTENT = "/**\n" +
			" * Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.\n" +
			" */\n" +
			"\r";

	@Test
	public static void main(String[] args) {
		List<String> fileList = new ArrayList<String>();
		getFilesPath(PATH, fileList);
		putContentToFiles(fileList);
	}

	/**
	 * 将注释内容放入java文件里面
	 *
	 * @param list java文件的绝对地址
	 */
	public static void putContentToFiles(List<String> list) {
		for (String filePath : list) {
			try {
				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

//				File temp = File.createTempFile("temp", null);
//				RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
//				FileOutputStream fileOutputStream = new FileOutputStream(temp);
//				FileInputStream fileInputStream = new FileInputStream(temp);

//				String strLine = null;
//				while ((strLine = bufferedReader.readLine()) != null) {
//					System.out.println("str line = " + strLine);
//					if (strLine.startsWith("public class ")) {
//						raf.seek(0);
//						byte[] buff = new byte[1024];
//						int hasRead = 0;
//						while ((hasRead = raf.read(buff)) > 0) {
//							fileOutputStream.write(buff, 0, hasRead);
//						}
//						raf.seek(0);
//						raf.write(CONTENT.getBytes());
//						while ((hasRead = fileInputStream.read(buff)) > 0) {
//							raf.write(buff, 0, hasRead);
//						}
//					}
//				}
//				fileReader.close();
//				bufferedReader.close();
//				raf.close();
//				fileInputStream.close();
//				fileOutputStream.close();

				if(bufferedReader.readLine().indexOf("package")>=0){
					File temp = File.createTempFile("temp",null);
					RandomAccessFile raf = new RandomAccessFile(filePath,"rw");
					FileOutputStream fileOutputStream = new FileOutputStream(temp);
					FileInputStream fileInputStream = new FileInputStream(temp);
					raf.seek(0);
					byte[] buff = new byte[1024];
					int hasRead = 0;
					while((hasRead = raf.read(buff)) > 0){
						fileOutputStream.write(buff,0,hasRead);
					}
					raf.seek(0);
					raf.write(CONTENT.getBytes());

					while((hasRead = fileInputStream.read(buff))>0){
						raf.write(buff,0,hasRead);
					}
					fileReader.close();
					bufferedReader.close();
					raf.close();
					fileInputStream.close();
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 扫描文件夹下面的所有文件
	 *
	 * @param filePath 文件夹地址
	 * @param list     存放获取的所有文件地址
	 * @return boolean
	 */
	public static void getFilesPath(String filePath, List<String> list) {
		File file = new File(filePath);
		if (!file.isDirectory() && file.getName().endsWith("java")) {
			list.add(file.getPath());
		} else if (file.isDirectory()) {
			String[] fileList = file.list();
			for (int i = 0; i < fileList.length; i++) {
				File readFile = new File(filePath + fileList[i]);
				if (!readFile.isDirectory() && readFile.getName().endsWith("java")) {
					list.add(readFile.getPath());
				} else if (readFile.isDirectory()) {
					getFilesPath(filePath + "/" + fileList[i], list);
				}
			}
		}
	}
}
