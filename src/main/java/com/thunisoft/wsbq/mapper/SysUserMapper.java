package com.thunisoft.wsbq.mapper;

import java.util.List;

import com.thunisoft.wsbq.po.SysRole;
import com.thunisoft.wsbq.po.SysUser;

public interface SysUserMapper {
	SysUser selectByUserName(String userName);
	List<SysRole> getGroupByUserName(String username);
}
