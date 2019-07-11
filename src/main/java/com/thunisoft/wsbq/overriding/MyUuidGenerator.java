package com.thunisoft.wsbq.overriding;


import org.activiti.engine.impl.cfg.IdGenerator;

import com.chenxing.common.distributedKey.PrimarykeyGenerated;

/**
 * 自定义主键
 * 
 * @author liuxing
 */
public class MyUuidGenerator implements IdGenerator {

	public String getNextId() {
		return PrimarykeyGenerated.generateId(false);
	}

}

