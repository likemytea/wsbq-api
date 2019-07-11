package com.thunisoft.wsbq.po;

import org.activiti.engine.impl.persistence.entity.UserEntity;

public class MyUserEntity extends UserEntity {
	private String birthdays;

	public String getBirthdays() {
		return birthdays;
	}

	public void setBirthdays(String birthdays) {
		this.birthdays = birthdays;
	}

}
