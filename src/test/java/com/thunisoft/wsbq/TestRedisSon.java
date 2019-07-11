package com.thunisoft.wsbq;

import java.util.ArrayList;
import java.util.List;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.alibaba.fastjson.JSON;
import com.thunisoft.wsbq.po.Msg;
import com.thunisoft.wsbq.po.PushMessage;

public class TestRedisSon {
	public static void main(String[] args) {
		TestRedisSon r = new TestRedisSon();
		RedissonClient client = r.getRedisSonClient();
		// r.saveKEYS();
		r.testList1(client);
		// r.testList8(client);
		client.shutdown();
	}

	private void testList5(RedissonClient c) {
		RList<Msg> list = c.getList("liuxing-yuchen");
		System.out.println(JSON.toJSONString(list));

	}

	private void testList8(RedissonClient c) {
		RBucket<List<Msg>> bk = c.getBucket("liuxing-yuchen");
		List<Msg> lst = bk.get();
		System.out.println(JSON.toJSONString(lst));
	}

	private void testList7(RedissonClient c) {
		RBucket<List<Msg>> bucket = c.getBucket("liuxing-yuchen");
		List<Msg> lst = new ArrayList<Msg>();
		Msg msg = new Msg();
		msg.setU("liuxing");
		msg.setT("s");
		msg.setC("早上好，雨晨");
		lst.add(msg);

		Msg msg2 = new Msg();
		msg2.setU("liuxing");
		msg2.setT("s");
		msg2.setC("在公司么，我的电脑能帮我开机么？");
		lst.add(msg2);

		Msg msg3 = new Msg();
		msg3.setU("yuchen");
		msg3.setT("s");
		msg3.setC("好的，已经帮你开开了");
		lst.add(msg3);

		Msg msg4 = new Msg();
		msg4.setU("yuchen");
		msg4.setT("s");
		msg4.setC("还在工作么？O(∩_∩)O");
		lst.add(msg4);

		bucket.set(lst);
		List<Msg> mmm = bucket.get();
		System.out.println(mmm);
	}

	private void testList4(RedissonClient c) {
		RList<Msg> list = c.getList("liuxing-yuchen");

		Msg msg = new Msg();
		msg.setU("liuxing");
		msg.setT("s");
		msg.setC("早上好，雨晨");
		list.add(msg);

		Msg msg2 = new Msg();
		msg2.setU("liuxing");
		msg2.setT("s");
		msg2.setC("在公司么，我的电脑能帮我开机么？");
		list.add(msg2);

		Msg msg3 = new Msg();
		msg3.setU("yuchen");
		msg3.setT("s");
		msg3.setC("好的，已经帮你开开了");
		list.add(msg3);

		Msg msg4 = new Msg();
		msg4.setU("yuchen");
		msg4.setT("s");
		msg4.setC("还在工作么？O(∩_∩)O");
		list.add(msg4);
		Msg msg1 = list.get(0);
		System.out.println("sss");
	}

	private void testList1(RedissonClient c) {
		RList<String> list = c.getList("hanxiao", new org.redisson.client.codec.StringCodec());
		list.add("liuxing");
		list.add("hanxiao");
		list.add("zhouming");
	}

	// private void testList3(RedissonClient c) {
	//
	// RList<Msg> l = c.getList("liuxing");
	//
	// Msg msg = new Msg();
	// msg.setUserId("yuchen");
	// msg.setMsgId("liuxing-yuchen");
	// Map<Long, String> map = new HashMap<Long, String>();
	// map.put(System.currentTimeMillis(), "你好，我是helloketty。");
	// map.put(System.currentTimeMillis(), "周末了，你在干嘛");
	// map.put(System.currentTimeMillis(), "工作么？");
	// msg.setContent(map);
	// l.add(msg);
	//
	// Msg msg2 = new Msg();
	// msg2.setUserId("zhouming");
	// msg2.setMsgId("liuxing-zhouming");
	// Map<Long, String> map2 = new HashMap<Long, String>();
	// map2.put(System.currentTimeMillis(), "作业做完了么？");
	// map2.put(System.currentTimeMillis(), "你和同学在外面吃吧");
	// map2.put(System.currentTimeMillis(), "早点回家哈？");
	// msg2.setContent(map2);
	//
	// l.add(msg2);
	//
	// }

	private void testList2(RedissonClient c) {
		RList<String> list = c.getList("liuxing");
		System.out.println(JSON.toJSONString(list));
	}

	private void saveKEYS() {
		// 存值
		PushMessage m = new PushMessage();
		m.setNickName("aaa");
		RedissonClient client = this.getRedisSonClient();
		RBucket<PushMessage> bucket = client.getBucket("PushMessage");
		bucket.set(m);
		PushMessage uuu = bucket.get();
		uuu.getNickName();
		client.shutdown();
	}

	/**
	 * 使用redisson 链接redis. 返回redisson实例
	 * 
	 */
	private RedissonClient getRedisSonClient() {
		Config redissonConfig = new Config();
		redissonConfig.useSingleServer().setDatabase(0).setConnectionMinimumIdleSize(2)
				.setAddress("redis://172.16.31.43:6379");
		RedissonClient redissonClient = Redisson.create(redissonConfig);
		return redissonClient;
	}

}
