package com.example.lib_custom_view2;

import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;

public class HeaderCommentsGenerator {
	private static int count = 0;
	static final String PATH = "/Users/ext.zhouchao3/AndroidStudioProjects/CustomGradle2/lib_custom_view2/src/main/java/com/example/book/";

	public static void main(String[] args) {
		String content = "/**\n" +
				" * Copyright (C), 2020-2020, Godsname Tech. Co., Ltd.\n" +
				" */\n" +
				"\r";
		commentFile(new File(PATH), content);
	}

	private static void commentFile(File file, String comments) {
		if (file != null && file.exists()) {
			if (file.isDirectory()) {
				String[] children = file.list();
				for (int i = 0; i < children.length; i++) {
					File child = new File(file.getPath() + System.getProperty("file.separator") + children[i]);
					commentFile(child, comments);
				}
			} else {
				if (file.getName().toLowerCase().endsWith(".java")) {
					System.out.println(file.getName());
					count++;
					try {
						RandomAccessFile raFile = new RandomAccessFile(file, "rw");
						byte[] content = new byte[(int) raFile.length()];
						raFile.readFully(content);
						String all = new String(content);
						all = all.trim();
						while (all.startsWith("\n")) {
							all = all.substring(1);
						}
						if (all.indexOf("package") != -1) {
							all = all.substring(all.indexOf("package"));
						}
						if (all.indexOf("import") != -1) {
							all = all.substring(all.indexOf("package"));
						}
						all = comments + "\n" + all;
						raFile.close();
						FileWriter writer = new FileWriter(file);
						writer.write(all);
						writer.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}


