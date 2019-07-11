package com.thunisoft.wsbq.service;

import com.thunisoft.wsbq.po.ApplicantInfo;

/**
 * 保全申请人信息
 * 
 */
public interface ApplicantInfoService {

	ApplicantInfo findByUseName(String userName);
}
