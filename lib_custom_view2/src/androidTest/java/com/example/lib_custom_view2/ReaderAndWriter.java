package com.example.lib_custom_view2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {
	private static final String PATH = "/Users/ext.zhouchao3/AndroidStudioProjects/CustomGradle2/lib_custom_view2/src/main/java/com/example/book/";

	@Test
	public static void main(String[] args) {

		List<String> fileList = new ArrayList<String>();
		getFilesPath(PATH, fileList);
		putContentToFiles(fileList);


	}

	public static void putContentToFiles(List<String> fileList) {
		for (String filePath : fileList) {
			try {
				System.out.println("filePath = " + filePath);
				String fileName = getFileName(filePath);

//				File tempFile = File.createTempFile("temp",null);
//				System.out.println("tempFile "+ tempFile.getPath());
				//1.将原有文件读取到 临时文件中

				FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader);//将文件读到内存中
				FileWriter fileWriter = new FileWriter(filePath, false);
				String strLine;
				while ((strLine = bufferedReader.readLine()) != null) {
					System.out.println("strLine = " + strLine);
					if (strLine.startsWith("public class " + fileName)) {
						fileWriter.write("\n");
						fileWriter.write("\\\\ I am test ");
						fileWriter.write("\n");
					}
					fileWriter.write(strLine);
					if (strLine.length() > 0) {
						fileWriter.write("\n");
					}
				}

//				//2.从临时文件中读取数据，重新写入到原来文件中
//				FileReader tempReader = new FileReader(filePath + "2");
//				BufferedReader tempBuffer = new BufferedReader(tempReader);
//				System.out.println("从临时文件中读取数据 = " );
//				FileWriter tempWriter = new FileWriter(filePath, false);
//				String tempStr;
//				while ((tempStr = tempBuffer.readLine()) != null) {
//					System.out.println("tempStr = " + tempStr);
//					tempWriter.write(tempStr);
//				}

				fileReader.close();
				bufferedReader.close();
				fileWriter.close();

//				tempReader.close();
//				tempBuffer.close();
//				tempWriter.close();


			} catch (FileNotFoundException e) {
				e.printStackTrace();
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


	private static String getFileName(String fName) {
//		String fName = " G:\\Java_Source\\navigation_tigra_menu\\demo1\\img\\lev1_arrow.gif ";
		//方法1
		File tempFile = new File(fName.trim());
		String fileName = tempFile.getName();

		System.out.println("fileName = " + fileName);
		if (fileName.contains(".")) {
			int lastPoint = fileName.lastIndexOf(".");
			fileName = fileName.substring(0, lastPoint);
		}
		System.out.println("无后缀 fileName = " + fileName);

//		//方法2
//		fName = fName.trim();
//		String fileName2 = fName.substring(fName.lastIndexOf("/") + 1);
//		//或者  
//		String fileName22 = fName.substring(fName.lastIndexOf("\\") + 1);
//		System.out.println("fileName2 = " + fileName2);
//		System.out.println("fileName22 = " + fileName22);
//
//		//方法 3
//		fName = fName.trim();
////		String temp[] = fName.split("\\\\"); /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/
//		String temp[] = fName.split("/"); /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/
//		String fileName3 = temp[temp.length - 1];
//		System.out.println("fileName3 = " + fileName3);
		return fileName;
	}
}
