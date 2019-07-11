package org.activiti.my.identity;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomGroupEntityManagerFactory implements SessionFactory {
	@Resource
	private CustomGroupEntityManager customGroupEntityManager;

	@Override
	public Class<?> getSessionType() {
		return GroupEntityManager.class;
	}

	@Override
	public Session openSession() {
		return customGroupEntityManager;
	}

	@Autowired
	public void setCustomGroupEntityManager(CustomGroupEntityManager customGroupEntityManager) {
		this.customGroupEntityManager = customGroupEntityManager;
	}
}
