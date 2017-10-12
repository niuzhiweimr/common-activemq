package com.mq.constant;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         配置文件常量读取类
 */
public class Constant {

	// 消息服务器URL
	public static final String MQ_BROKERURL = ResourceBundle.getBundle("jms", Locale.CHINA).getString("jms_brokerURL");
	// 消息服务器用户名
	public static final String MQ_USERNAME = ResourceBundle.getBundle("jms", Locale.CHINA).getString("jms_userName");
	// 消息服务器密码
	public static final String MQ_PASSWORD = ResourceBundle.getBundle("jms", Locale.CHINA).getString("jms_password");
	// 消息服务器订阅模式发布者名称
	public static final String MQ_MESSAGE_TOPIC = ResourceBundle.getBundle("jms", Locale.CHINA).getString(
			"jms_messageTopic");
	// 消息服务器队列模式发送者名称
	public static final String MQ_MESSAGE_QUEUE = ResourceBundle.getBundle("jms", Locale.CHINA).getString(
			"jms_messageQueue");

}
