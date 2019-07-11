package com.thunisoft.wsbq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.wsbq.mapper.ApplicantInfoMapper;
import com.thunisoft.wsbq.po.ApplicantInfo;
import com.thunisoft.wsbq.service.ApplicantInfoService;

@Service(value = "applicantInfoService")
public class ApplicantInfoServiceImpl implements ApplicantInfoService {

	@Autowired
	private ApplicantInfoMapper mapper;

	@Override
	public ApplicantInfo findByUseName(String usercode) {
		ApplicantInfo user = mapper.selectByCode(usercode);
		return user;
	}
}
