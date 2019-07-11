package org.activiti.my.identity;

import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.thunisoft.wsbq.mapper.SysUserMapper;
import com.thunisoft.wsbq.po.MyUserEntity;

@Component
public class CustomUserEntityManager extends UserEntityManager {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public MyUserEntity findUserById(String userId) {
		MyUserEntity u = new MyUserEntity();
		com.thunisoft.wsbq.po.SysUser sysuser = sysUserMapper.selectByUserName(userId);// 这是我们的dao方法查询回来的方法，是自己定义的user
		u = ActivitiUserUtils.toActivitiUser(sysuser);// 将自定义的user转化为activiti的类
		return u;// 返回的是activiti的实体类
	}

	@Override
	public Boolean checkPassword(String userId, String password) {
		MyUserEntity userEntity = this.findUserById(userId);
		log.info(JSON.toJSONString(userEntity));
		return false;
	}

}
