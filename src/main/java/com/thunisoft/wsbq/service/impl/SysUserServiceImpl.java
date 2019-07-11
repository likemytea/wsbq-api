package com.thunisoft.wsbq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.wsbq.mapper.SysUserMapper;
import com.thunisoft.wsbq.po.SysUser;
import com.thunisoft.wsbq.service.SysUserService;

@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByUseName(String userName) {
		SysUser sysUser = sysUserMapper.selectByUserName(userName);
		return sysUser;
	}
}
