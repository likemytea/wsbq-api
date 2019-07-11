package com.thunisoft.wsbq.designPattern.prototype;

import com.alibaba.fastjson.JSON;

/**
 * java是值传递，当一个实例对象作为参数被传递到方法中时，参数的值就是该对象的引用的一个副本<br>
 * 基本类型和引用类型<br>
 * 对于基本类型，变量里边存储的是值本身。对于引用类型，变量里边存储的是内存地址。变量引用的是值，所以称为引用类型。<br>
 * 值传递和引用传递
 * 
 */
public class Analysis1 {
	public static void main(String[] args) {
		int count = 66;
		String str = "m";
		// 下面的语句则是新开辟了一块内存地址
		str = "m-m";
		MyDove md = new MyDove();
		md.setName("zhangsan");
		myfun(count);
		myfun1(str);
		myfun2(md);
		System.out.println(count);
		System.out.println(str);
		System.out.println(JSON.toJSONString(md));
	}

	private static void myfun(int count) {
		count = 666;
	}

	private static void myfun1(String str) {
		str = "m-m-m";
	}

	private static void myfun2(MyDove md2) {
		md2.setName("lisi");
	}
}
