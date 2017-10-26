package com.mq.test;

import com.mq.call.*;
import com.mq.exception.MsgException;
import com.mq.message.MsgCommand;

public class TestMessageSend {
	// 消息发送测试
	public static void main(String[] args) {
		MsgCommand cmd = CommandFactory.getMsgCommand();
		cmd.setCmd("123");
		try {
			MessageSendCall.topicProxyOjbectMessageSend(cmd);
		} catch (MsgException e) {
			e.printStackTrace();
		}
	}

}
