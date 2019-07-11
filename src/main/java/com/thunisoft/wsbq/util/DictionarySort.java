package com.thunisoft.wsbq.util;

import java.util.Arrays;

public class DictionarySort {
	public static void main(String[] args) {
		DictionarySort a = new DictionarySort();
		String[] arr = { "bgdsg", "cewfs", "2", "afsegs", "4342", "fcewasffs", "kkkkk11" };
		dictionSort(arr);
	}

	public static String dictionSort(String[] arr) {
		StringBuffer sb = new StringBuffer();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i == arr.length - 1) {
				break;
			}
			sb.append("-");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
