package com.thunisoft.wsbq.designPattern.abstractFactory;

import com.thunisoft.wsbq.designPattern.ordinaryFactory.MyClassTwo;
import com.thunisoft.wsbq.designPattern.ordinaryFactory.MyInterface;

public class MyFactoryTwo implements Provider {

	@Override
	public MyInterface produce() {
		return new MyClassTwo();
	}

}
