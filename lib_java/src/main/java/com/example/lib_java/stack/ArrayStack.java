package com.example.lib_java.stack;

/**
 * ArrayStack简介
 * 创建一个顺序栈
 *
 * @author ext.zhouchao3
 * @date 2020-09-04 18:47
 */
public class ArrayStack {
	private String[] items;//数组 栈的长度
	private int count; //栈中的 元素个数
	private int size; // 栈的长度


	public ArrayStack(int n) {
		this.items = new String[n];
		this.size = n;
		this.count = 0;
	}

	//入栈
	public boolean push(String text){

		if(count == size){
			return false;
		}
		return true;
	}
}
