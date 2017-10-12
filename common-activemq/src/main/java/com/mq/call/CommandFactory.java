package com.mq.call;

import java.util.ArrayList;
import java.util.List;

import com.mq.message.MsgCommand;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         生产消息命令工厂静态工厂 加入线程锁(防止多线程情况下的数据混乱)
 */
public class CommandFactory {

	// 缓存容器 将对象存入,如果堆在存在此集合中直接返回对象 否则new一个对象,防止聊天频繁创建对象导致系统内容溢出
	public static List<Object> cmdList = new ArrayList<Object>();

	// 获取消息对象 加入锁机制
	public synchronized static MsgCommand getMsgCommand() {
		// 判断list容器中是否存在此对象
		if (cmdList.size() == 0) {
			// 创建消息命令对象
			MsgCommand msgCommand = new MsgCommand();
			// 将对象存入list容器中
			cmdList.add(msgCommand);
			// 返回消息命令对象
			return msgCommand;
		} else {
			// 如果已存在此对象 直接冲容器中取出此对象
			return (MsgCommand) cmdList.get(0);
		}

	}
}
