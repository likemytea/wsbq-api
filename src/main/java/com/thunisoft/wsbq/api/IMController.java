package com.thunisoft.wsbq.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thunisoft.wsbq.service.IMService;

/**
 * 即时通信类
 * <p>
 * Created by liuxing on 19/7/6.
 */
@Controller
@RequestMapping(value = "/im")
public class IMController {
	@Autowired
	private IMService iMService;

	@ResponseBody
	@RequestMapping(value = "/friends/list", method = {
			RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public String getFriendsByClientId(@RequestParam String userId) {
		return iMService.getFriendsByClientId(userId);
	}

	/**
	 * 获取消息
	 * 
	 **/
	@ResponseBody
	@RequestMapping(value = "/chat/msg", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public String getChatMsg(@RequestParam String userId, @RequestParam String friend) {
		return iMService.getChatMsg(userId, friend);
	}
}
