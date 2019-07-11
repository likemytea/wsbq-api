package com.thunisoft.wsbq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chenxing.common.jdbc.MyJdbcTemplate;
import com.chenxing.common.pagination.PaginationResult;
import com.chenxing.common.pagination.SortType;
import com.chenxing.common.vo.PageResult;
import com.thunisoft.wsbq.po.ApplicantInfo;
import com.thunisoft.wsbq.po.SysRole;
import com.thunisoft.wsbq.po.SysUser;

/**
 * Description:
 * 
 * @author liuxing
 * @date 2018年5月14日
 * @version 1.0
 */
@Repository
public class UserDao {

	@Autowired
	@Qualifier("myJdbcTemplatep3")
	private MyJdbcTemplate jdbcTemplate;

	public ApplicantInfo findByUserName(String username) {
		String rsql = "SELECT usr.id,usr.applicant_code,usr.password,r.name from applicant_info usr  "
				+ "left join sys_role_applicant userrole on usr.id= userrole.applicant_info_fk "
				+ "left join sys_role r on userrole.sys_role_fk=r.id where usr.applicant_code= ?";
		//
		// String rsql = "SELECT u.sys_user_id,u.username,u.password,r.name from
		// sys_user u "
		// + "left join sys_role_user sru on u.sys_user_id= sru.sys_user_id "
		// + "LEFT JOIN sys_role r on sru.sys_role_id=r.id where username= ?";

		List<Map<String, String>> ms = jdbcTemplate.query(rsql, new RowMapper<Map<String, String>>() {
			@Override
			public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, String> p = new HashMap<String, String>();
				p.put("id", String.valueOf(rs.getLong(1)));
				p.put("usercode", rs.getString(2));
				p.put("password", rs.getString(3));
				p.put("rolename", rs.getString(4));
				return p;
			}
		}, username);
		return map2Obj(ms);
	}

	public PageResult<SysUser> findUser(int currentpage, int pagesize) {

		String rsql = "SELECT u.sys_user_id,u.username,u.password from sys_user u";
		PaginationResult<Map<String, String>> res = jdbcTemplate.queryForPage(rsql, currentpage, pagesize,
				"sys_user_id", SortType.DESC, new RowMapper<Map<String, String>>() {
					@Override
					public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
						Map<String, String> p = new HashMap<String, String>();
						p.put("userid", String.valueOf(rs.getInt(1)));
						p.put("username", rs.getString(2));
						p.put("password", rs.getString(3));
						return p;
					}
				});
		List<SysUser> lst = map2Obj2(res.getData());
		PageResult<SysUser> pr = new PageResult<SysUser>();
		pr.setArray(lst);
		pr.setTotalCount(res.getTotalCount());
		pr.setTotalPage(res.getTotalPage());
		return pr;
	}

	private List<SysUser> map2Obj2(List<Map<String, String>> ms) {
		List<SysUser> list = new ArrayList<SysUser>();
		SysUser user = null;
		for (Map<String, String> map : ms) {
			user = new SysUser();
			user.setId(Integer.parseInt(map.get("userid")));
			user.setUsername(map.get("username"));
			user.setPassword(map.get("password"));
			list.add(user);
		}
		return list;
	}

	private ApplicantInfo map2Obj(List<Map<String, String>> ms) {
		ApplicantInfo p = new ApplicantInfo();
		SysRole sysRole = null;
		List<SysRole> roles = new ArrayList<SysRole>();
		for (Map<String, String> map : ms) {
			sysRole = new SysRole();
			p.setId(Long.parseLong(map.get("id")));
			p.setApplicantCode(map.get("usercode"));
			p.setPassword(map.get("password"));
			sysRole.setName(map.get("rolename"));
			roles.add(sysRole);
		}
		p.setRoles(roles);
		return p;
	}
}