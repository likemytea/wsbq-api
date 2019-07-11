package com.thunisoft.wsbq.service;

import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.thunisoft.wsbq.po.Msg;
import com.thunisoft.wsbq.util.DictionarySort;

/**
 * 即时通信 获取朋友列表
 * 
 * * Created by liuxing.
 */
@Service("iMService")
@Transactional
public class IMService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedissonClient r;

	/**
	 * 根据userid获取朋友列表
	 */
	@Transactional(readOnly = true)
	public String getFriendsByClientId(String userId) {
		RList<String> lst = r.getList(userId, new org.redisson.client.codec.StringCodec());
		return JSON.toJSONString(lst);
	}

	/**
	 * 获取消息
	 */
	@Transactional(readOnly = true)
	public String getChatMsg(String userId, String chatId) {
		String[] arr = { userId, chatId };
		String messageId = DictionarySort.dictionSort(arr);
		RList<Msg> lst = r.getList(messageId);
		System.out.println(JSON.toJSONString(lst));
		return JSON.toJSONString(lst);
	}

}
