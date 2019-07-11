package com.thunisoft.wsbq.designPattern.abstractFactory;

import com.thunisoft.wsbq.designPattern.ordinaryFactory.MyClassOne;
import com.thunisoft.wsbq.designPattern.ordinaryFactory.MyInterface;

public class MyFactoryOne implements Provider {

	@Override
	public MyInterface produce() {
		// TODO Auto-generated method stub
		return new MyClassOne();
	}

}
