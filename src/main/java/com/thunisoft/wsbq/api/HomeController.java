package com.thunisoft.wsbq.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thunisoft.wsbq.po.ApplicantInfo;
import com.thunisoft.wsbq.service.ApplicantInfoService;
import com.thunisoft.wsbq.service.SysUserService;

/**
 * 主页面类
 * <p>
 * Created by liuxing on 17/1/18.
 */
@Controller
public class HomeController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ApplicantInfoService applicantInfoService;

	@RequestMapping("/")
	public String goHomePage(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ApplicantInfo user = applicantInfoService.findByUseName(userDetails.getUsername());
		// user.setFriendsList(user.getFriends().split(","));
		model.addAttribute("user", user);
		return "homepage";
	}

	@RequestMapping("/login")
	public String login() {
		return "myLogin";
	}

	@RequestMapping("/admin")
	@ResponseBody
	public String hello() {
		return "hello admin";
	}
}
