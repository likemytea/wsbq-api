package com.thunisoft.wsbq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.wsbq.dao.Test01Dao;

@Service
public class TestService {

	@Autowired
	private Test01Dao test01Dao;

	public String updateName(String id, String name) {
		String count = "";
		try {
			count = test01Dao.getNameById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
}
