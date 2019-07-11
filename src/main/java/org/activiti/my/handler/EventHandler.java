package org.activiti.my.handler;

import org.activiti.engine.delegate.event.ActivitiEvent;

/**
 * Activiti的事件处理器
 * 
 * @author csx
 *
 */
public interface EventHandler {
	/**
	 * 事件处理器
	 * 
	 * @param event
	 */
	public void handle(ActivitiEvent event);
}
