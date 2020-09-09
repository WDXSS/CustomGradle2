package com.example.lib_java.stack;

/**
 * ArrayStack简介
 * 创建一个顺序栈
 * 点：
 * d定义
 * 1。栈的长度
 * 2。栈中已有 元素个数
 * 3。入栈 和 出栈 方法
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
	public boolean push(String text) {
		if (count == size) {
			return false;
		}
		// 将item放到下标为count的位置，并且count加一
		items[count] = text;
		++count;
		return true;
	}

	public String pop() {
		// 栈为空，则直接返回null
		if (count == 0) return null;
		// 返回下标为count-1的数组元素，并且栈中元素个数count减一
		String tmp = items[count - 1];
		--count;
		return tmp;
	}

	private void println(){
		System.out.println(items);
	}
}
