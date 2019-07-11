package com.thunisoft.wsbq.designPattern.abstractFactory;

import com.thunisoft.wsbq.designPattern.ordinaryFactory.MyInterface;

/**
 * 抽象工厂1:和静态工厂相比，主要是实现了对修改关闭，对扩展开放
 */
public interface Provider {
	public MyInterface produce();
}
