package com.mq.service.impl;

import javax.jms.*;

import org.apache.log4j.Logger;

import com.mq.constant.Constant;
import com.mq.service.IMessageTopicSender;
import com.mq.util.ActiveMqConnectionUtil;

public class MessageTopicSender implements IMessageTopicSender {

	private static Logger logger = Logger.getLogger(MessageTopicSender.class);

	private Session session = null;
	private Destination destination = null;
	private MessageProducer producer = null;
	private Connection connection = null;

	// 发布者发布文本消息
	public void sendTopicTextMessage(String message) {

		try {
			// 创建连接
			connection = ActiveMqConnectionUtil.getConnection();
			// 启动连接
			connection.start();
			// 获取session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE); // 消息的目的地
			destination = session.createTopic(Constant.MQ_MESSAGE_TOPIC);
			// 消息生产者
			producer = session.createProducer(destination);
			// 消息持久化
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 发送文本消息
			TextMessage textMessage = session.createTextMessage(message);
			// 发送消息
			producer.send(textMessage);
			// session提交
			session.commit();
			logger.info("Topic文本消息发送成功");
		} catch (JMSException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null) {
				try {
					// 关闭session
					session.close();
					if (producer != null)
						// 关闭producer
						producer.close();
					if (connection != null)
						// 关闭connection连接
						connection.close();
				} catch (JMSException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	// 发布者发布键对值消息
	public void sendTopicMapMessage(MapMessage mapMessage) {

		try {
			// 创建连接
			connection = ActiveMqConnectionUtil.getConnection();
			// 启动连接
			connection.start();
			// 获取session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 消息的目的地
			destination = session.createTopic(Constant.MQ_MESSAGE_TOPIC);
			// 消息生产者
			producer = session.createProducer(destination);
			// 消息持久化
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 发送消息
			producer.send(mapMessage);
			// session提交
			session.commit();
			logger.info("Topic键对值消息发送成功");
		} catch (JMSException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null) {
				try {
					// 关闭session
					session.close();
					if (producer != null)
						// 关闭producer
						producer.close();
					if (connection != null)
						// 关闭connection连接
						connection.close();
				} catch (JMSException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	// 发布者发布流消息
	public void sendTopicStreamMeaasge(StreamMessage streamMessage) {

		try {
			// 创建连接
			connection = ActiveMqConnectionUtil.getConnection();
			// 启动连接
			connection.start();
			// 获取session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 消息的目的地
			destination = session.createTopic(Constant.MQ_MESSAGE_TOPIC);
			// 消息生产者
			producer = session.createProducer(destination);
			// 消息持久化
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 发送消息
			producer.send(streamMessage);
			// session提交
			session.commit();
			logger.info("Topic流消息发送成功");
		} catch (JMSException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null) {
				try {
					// 关闭session
					session.close();
					if (producer != null)
						// 关闭producer
						producer.close();
					if (connection != null)
						// 关闭connection连接
						connection.close();
				} catch (JMSException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	// 发布者发布字节消息
	public void sendTopicBytesMessage(BytesMessage byteMessage) {

		try {
			// 创建连接
			connection = ActiveMqConnectionUtil.getConnection();
			// 启动连接
			connection.start();
			// 获取session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 消息的目的地
			destination = session.createTopic(Constant.MQ_MESSAGE_TOPIC);
			// 消息生产者
			producer = session.createProducer(destination);
			// 消息持久化
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 发送消息
			producer.send(byteMessage);
			// session提交
			session.commit();
			logger.info("Topic字节消息发送成功");
		} catch (JMSException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null) {
				try {
					// 关闭session
					session.close();
					if (producer != null)
						// 关闭producer
						producer.close();
					if (connection != null)
						// 关闭connection连接
						connection.close();
				} catch (JMSException e) {
					logger.error(e.getMessage());
				}
			}
		}

	}

	// 发布者发布对象消息
	public void sendTopicObjectMessage(ObjectMessage objectMessage) {

		try {
			// 创建连接
			connection = ActiveMqConnectionUtil.getConnection();
			// 启动连接
			connection.start();
			// 获取session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 消息的目的地
			destination = session.createTopic(Constant.MQ_MESSAGE_TOPIC);
			// 消息生产者
			producer = session.createProducer(destination);
			// 消息持久化
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 发送消息
			producer.send(objectMessage);
			// session提交
			session.commit();
			logger.info("Topic对象消息发送成功");
		} catch (JMSException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null) {
				try {
					// 关闭session
					session.close();
					if (producer != null)
						// 关闭producer
						producer.close();
					if (connection != null)
						// 关闭connection连接
						connection.close();
				} catch (JMSException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}
}
