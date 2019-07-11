package org.activiti.my.identity;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;

import com.thunisoft.wsbq.po.MyUserEntity;
import com.thunisoft.wsbq.po.SysRole;
import com.thunisoft.wsbq.po.SysUser;

public class ActivitiUserUtils {
	public static MyUserEntity toActivitiUser(SysUser bUser) {
		MyUserEntity userEntity = new MyUserEntity();
		userEntity.setId(bUser.getUsername());
		userEntity.setFirstName(bUser.getUsername() + bUser.getId());
		userEntity.setLastName(bUser.getUsername() + bUser.getId() + bUser.getPassword());
        userEntity.setPassword(bUser.getPassword());  
		userEntity.setEmail(null);
        userEntity.setRevision(1);  
		userEntity.setBirthdays(bUser.getUsername() + bUser.getId() + bUser.getPassword() + "xxxxdddd");
        return userEntity;  
    }  
  
	public static GroupEntity toActivitiGroup(SysRole sysRole) {
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setRevision(1);
		groupEntity.setType("assignment");
		groupEntity.setId(String.valueOf(sysRole.getId()));
		groupEntity.setName(sysRole.getName());
		return groupEntity;
    }  
  
	public static List<Group> toActivitiGroups(List<SysRole> sysRoles) {
        List<Group> groups = new ArrayList<Group>();  
		for (SysRole sysRole : sysRoles) {
            GroupEntity groupEntity = toActivitiGroup(sysRole);  
            groups.add(groupEntity);  
        }  
        return groups;  
    }
 
}
