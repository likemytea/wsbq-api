package org.activiti.my.identity;

import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thunisoft.wsbq.mapper.SysUserMapper;
import com.thunisoft.wsbq.po.SysRole;

@Component
public class CustomGroupEntityManager extends GroupEntityManager {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SysUserMapper sysUserMapper;// 用于查询实际业务中用户表、角色等表

	@Override
	public List<Group> findGroupsByUser(String userId) {
		if (userId == null)
			return null;

		List<SysRole> bGroupList = sysUserMapper.getGroupByUserName(userId);

		List<Group> gs = new java.util.ArrayList<>();
		GroupEntity g;
		String roleId;
		for (SysRole bGroup : bGroupList) {
			g = new GroupEntity();
			g.setRevision(1);
			g.setType("assignment");
			roleId = String.valueOf(bGroup.getId());
			// activitRole = bindGroupWithRole.get(roleId);//此处只是根据RoleId获取RoleCode，
			// 因实际表中无RoleCode字段，暂且如此实际，此行可注释掉
			g.setId(/* activitRole != null ? activitRole : */ roleId);
			g.setName(bGroup.getName());
			gs.add(g);
		}
		return gs;
	}

}
