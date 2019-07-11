package com.thunisoft.wsbq.listener;

import org.activiti.my.handler.EventHandler;

public class WebAppUtil {
	public static EventHandler getBean(String eventHandlerBeanId) {
		if ("taskCreateListener".equals(eventHandlerBeanId)) {
			TaskCreateListener tr = new TaskCreateListener();
			return tr;
		}
		return null;
    }
}
