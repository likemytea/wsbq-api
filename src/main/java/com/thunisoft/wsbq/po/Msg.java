package com.thunisoft.wsbq.po;

import java.io.Serializable;

/**
 * Created by liuxing on 19/6/17.
 */

public class Msg implements Serializable {
	private static final long serialVersionUID = -1089625566106374537L;
	// 发送消息的用户userId
	private String u;
	// 消息类型 s:string p:图片 y:语音 t:时间
	private String t;
	// 发送的消息
	private String c;

	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

}
