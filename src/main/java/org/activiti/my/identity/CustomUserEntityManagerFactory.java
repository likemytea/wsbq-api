package org.activiti.my.identity;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserEntityManagerFactory implements SessionFactory {
	// 使用自定义的User管理类
	@Resource
	private CustomUserEntityManager customUserEntityManager;

	@Override
	public Class<?> getSessionType() {
		return UserIdentityManager.class;
	}

	@Override
	public Session openSession() {
		return customUserEntityManager;
	}

	@Autowired
	public void setCustomUserEntityManager(CustomUserEntityManager customUserEntityManager) {
		this.customUserEntityManager = customUserEntityManager;
	}

}
