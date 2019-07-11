package com.thunisoft.wsbq.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.my.handler.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskCreateListener implements EventHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void handle(ActivitiEvent event) {
		// TODO Auto-generated method stub
		ActivitiEntityEventImpl eventImpl = (ActivitiEntityEventImpl) event;
		TaskEntity taskEntity = (TaskEntity) eventImpl.getEntity();
		logger.info("流程定义id{},被指派人{}", taskEntity.getVariable("reason"), taskEntity.getVariable("designatedExecutor"));

		taskEntity.addCandidateUser((String) taskEntity.getVariable("designatedExecutor"));
		// List<String> assignList = new ArrayList<String>();
		// assignList.add("admin");
		// assignList.add("hr");
		// taskEntity.addCandidateGroups(assignList);
		logger.info("create task is..... " + taskEntity.getName() + " key is:" + taskEntity.getTaskDefinitionKey());
		logger.info("enter the task create listener ---->" + event.getType().name());
	}

}
