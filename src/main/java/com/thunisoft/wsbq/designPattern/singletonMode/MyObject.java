package com.thunisoft.wsbq.designPattern.singletonMode;

public class MyObject {
	private static MyObject myObject;

	/**
	 * 构造函数,必须设置为私有的，否则外部也可以构造了。
	 */
	private MyObject() {
	}

	public static MyObject getInstance() {
		if (myObject == null) {
			return new MyObject();
		}
		return myObject;
	}

}
