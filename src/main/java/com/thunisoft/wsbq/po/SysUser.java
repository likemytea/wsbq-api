package com.thunisoft.wsbq.po;

import java.util.List;

/**
 * Created by liuxing on 17/1/17.
 */

public class SysUser {
    private Integer id;
    private String username;
    private String password;
	private String friends;
	private String[] friendsList;
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public String[] getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(String[] friendsList) {
		this.friendsList = friendsList;
	}


}
