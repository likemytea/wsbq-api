package com.thunisoft.wsbq.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chenxing.common.vo.PageResult;
import com.thunisoft.wsbq.dao.PermissionDao;
import com.thunisoft.wsbq.dao.UserDao;
import com.thunisoft.wsbq.po.ApplicantInfo;
import com.thunisoft.wsbq.po.Permission;
import com.thunisoft.wsbq.po.SysUser;

/**
 * Created by liuxing on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { // 自定义UserDetailsService 接口

	@Autowired
	UserDao userDao;
	@Autowired
	PermissionDao permissionDao;

	public UserDetails loadUserByUsername(String username) {
		ApplicantInfo user = userDao.findByUserName(username);

		if (user != null && (!StringUtils.isEmpty(user.getApplicantCode()))) {
			List<Permission> permissions = permissionDao.findByPermissionByUserId(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (Permission permission : permissions) {
				if (permission != null && permission.getName() != null) {

					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
					grantedAuthorities.add(grantedAuthority);
				}
			}
			return new User(user.getApplicantCode(), user.getPassword(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("admin: " + username + " do not exist!");
		}
	}

	public PageResult<SysUser> findUserList(int currenpage, int pagesize) {
		return userDao.findUser(currenpage, pagesize);
	}
}
