package com.thunisoft.wsbq.designPattern.abstractFactory;

import com.thunisoft.wsbq.designPattern.ordinaryFactory.MyInterface;

public class DesignTest {
	public static void main(String[] args) {
		Provider p = new MyFactoryTwo();
		MyInterface myi = p.produce();
		myi.print();
	}
}
