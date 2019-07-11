package com.thunisoft.wsbq.service;

import java.util.List;

import com.thunisoft.wsbq.po.User;

/**
 * mybatis demo
 * 
 */
public interface UserService {
	int addUser(User user);

	List<User> findAllUser(int pageNum, int pageSize);
}
