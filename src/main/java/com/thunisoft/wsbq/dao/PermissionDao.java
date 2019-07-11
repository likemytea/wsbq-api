package com.thunisoft.wsbq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thunisoft.wsbq.po.Permission;

/**
 * Description:
 * 
 * @author liuxing
 * @date 2018年5月14日
 * @version 1.0
 */
@Repository
public class PermissionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Permission> findByPermissionByUserId(long userid) {
		StringBuffer sb = new StringBuffer();
		sb.append("select p.description,p.id,p.name,p.pid,p.url from applicant_info u ");
		sb.append("LEFT JOIN sys_role_applicant sru on u.id= sru.applicant_info_fk ");
		sb.append("LEFT JOIN sys_role r on sru.sys_role_fk=r.id ");
		sb.append("LEFT JOIN sys_permission_role spr on spr.sys_role_id=r.id ");
		sb.append("LEFT JOIN sys_permission p on p.id =spr.sys_permission_id where u.id=?");

		List<Permission> ms = jdbcTemplate.query(sb.toString(), new RowMapper<Permission>() {
			@Override
			public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
				Permission p = new Permission();
				p.setDescritpion(rs.getString(1));
				p.setId(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setPid(rs.getInt(4));
				p.setUrl(rs.getString(5));
				return p;
			}
		}, userid);
		return ms;
	}

	public List<Permission> findAll() {

		String rsql = "SELECT description,name,url,id,pid from sys_permission";
		List<Permission> ms = jdbcTemplate.query(rsql, new RowMapper<Permission>() {
			@Override
			public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
				Permission p = new Permission();
				p.setDescritpion(rs.getString(1));
				p.setName(rs.getString(2));
				p.setUrl(rs.getString(3));
				p.setId(rs.getInt(4));
				p.setPid(rs.getInt(5));
				return p;
			}
		});
		return ms;
	}
}
