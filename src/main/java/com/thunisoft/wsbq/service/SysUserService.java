package com.thunisoft.wsbq.service;

import com.thunisoft.wsbq.po.SysUser;

/**
 * mybatis demo
 * 
 */
public interface SysUserService {

	SysUser findByUseName(String userName);
}
