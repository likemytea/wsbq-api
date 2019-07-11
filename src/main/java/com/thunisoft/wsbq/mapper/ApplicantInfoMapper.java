package com.thunisoft.wsbq.mapper;

import com.thunisoft.wsbq.po.ApplicantInfo;

public interface ApplicantInfoMapper {
	ApplicantInfo selectByCode(String code);
}
