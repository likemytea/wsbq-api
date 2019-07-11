package com.thunisoft.wsbq.designPattern.ordinaryFactory;

public class DesignTest {
	public static void main(String[] args) {
		MyFactory factory = new MyFactory();
		MyInterface myi = factory.produce("Two");
		myi.print();
	}
}
