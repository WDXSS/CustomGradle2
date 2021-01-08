package com.example.lib_java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		Set<Integer> s = new HashSet<>();
		s.add(2);
		s.add(4);
		a.removeAll(s);
		System.out.println(a);

		List<Long> bookIds = new ArrayList<>();
		bookIds.add(123457L);
		bookIds.add(123456L);
		bookIds.add(12349L);
		Set<String> stringSet = new HashSet<>();
		stringSet.add("123456");
		stringSet.add("123457");
		stringSet.add("12349");

		SetTest setTest = new SetTest();
		boolean result = setTest.checkIdNotMatch(bookIds,stringSet);
		System.out.println("result =" + result);
	}

	private boolean checkIdNotMatch(List<Long> bookIds,Set<String> checkedSet) {
		if (bookIds != null && bookIds.size() > 0) {
			List<Long> checkedIds = new ArrayList<>();
			for (String str : checkedSet) {
				System.out.println(str);
				checkedIds.add(Long.valueOf(str));
			}
			Collections.sort(bookIds);
			Collections.sort(checkedIds);
			System.out.println(bookIds.toString());
			System.out.println(checkedIds.toString());
			System.out.println(" res =" + (bookIds.toString().equals(checkedIds.toString())));
			return !bookIds.toString().equals(checkedIds.toString());
		}
		return true;
	}
}
