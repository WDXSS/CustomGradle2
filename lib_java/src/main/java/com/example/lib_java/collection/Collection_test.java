package com.example.lib_java.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Java 集合框架原理分析
 * https://blog.csdn.net/u011240877/category_6447444.html
 *
 * Collection_test简介
 * https://blog.csdn.net/lmarster/article/details/90672794
 *
 * @author ext.zhouchao3
 * @date 2020-10-10 11:39
 */
public class Collection_test {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		set.add("xet");
		set.add("jpo");
		set.add("wo");
		set.add("jpo");
		System.out.println(set);

		Set<String> softset = new TreeSet<String>(set);
		System.out.println(softset);

		Set<String> treeSet = new TreeSet<>();
		treeSet.add("b");
		treeSet.add("a");
		treeSet.add("f");
		treeSet.add("c");
		treeSet.add("1102");
		System.out.println(treeSet);
		//TreeSet 的排序规则 默认按字母排序


		linkedList();
	}

	/**
	 * List常用算法举例
	 */
	private static void linkedList() {
		List p1 = new LinkedList();
		List p2 = new LinkedList();
		for (int i = 0; i <= 9; i++) {
			p1.add("a" + i);
		}
		//打印p1[a0, a1, a2, a3, a4, a5, a6, a7, a8, a9]
		System.out.println(p1);
		//随机排列
		System.out.println("随机排列");
		Collections.shuffle(p1);
		System.out.println(p1);

		//逆序
		System.out.println("逆序");
		Collections.reverse(p1);
		System.out.println(p1);
		//排序
		System.out.println("排序");
		Collections.sort(p1);
		System.out.println(p1);
		//折半查找
		System.out.println("折半查找 a5");
		System.out.println(Collections.binarySearch(p1, "a5"));
	}

}
