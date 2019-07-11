package com.thunisoft.wsbq.listener;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.my.handler.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Activiti的全局事件监听器，即所有事件均需要在这里统一分发处理
 * 
 * @author csx
 * @copyright http://www.redxun.cn
 *
 */
@Transactional
public class GlobalEventListener implements ActivitiEventListener {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// 事件及事件的处理器
	// private Map<String,EventHandler> handlers=new HashMap<String,
	// EventHandler>();
	// 更换为以下模式，可以防止Spring容器启动时，ProcessEngine尚未创建，而业务类中又使用了这个引用
	private Map<String, String> handlers = new HashMap<String, String>();

	@Override
	public void onEvent(ActivitiEvent event) {
		String eventType = event.getType().name();
		logger.debug("envent type is ========>" + eventType);
		// 根据事件的类型ID,找到对应的事件处理器
		String eventHandlerBeanId = handlers.get(eventType);
		if (eventHandlerBeanId != null) {
			logger.info("eventtype" + eventType + "eventHandlerBeanId" + eventHandlerBeanId);
			EventHandler handler = (EventHandler) WebAppUtil.getBean(eventHandlerBeanId);
			if (handler != null) {
				handler.handle(event);
			}
		} else {
			logger.info("xxxx");
		}
	}

	@Override
	public boolean isFailOnException() {
		// 出现异常则向外抛，所以全部数据业务会回滚
		return true;
	}

	public Map<String, String> getHandlers() {
		return handlers;
	}

	public void setHandlers(Map<String, String> handlers) {
		this.handlers = handlers;
	}
}
