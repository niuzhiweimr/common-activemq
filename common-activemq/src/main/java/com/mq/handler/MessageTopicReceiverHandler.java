package com.mq.handler;

import java.io.StringReader;

import javax.jms.*;
import javax.xml.bind.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mq.call.MessageReceiverEvent;
import com.mq.constant.Constant;
import com.mq.message.MsgCommand;
import com.mq.util.FatchApplicationContext;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         mq（Topic）消息处理类
 *         <p>
 *         各种消息的处理机制示例代码
 * 
 */
@Transactional
@Component
public class MessageTopicReceiverHandler {

	private static Logger logger = Logger.getLogger(MessageTopicReceiverHandler.class);

	public void topicTextMessageHandler(final TextMessage textMessage) {

		JAXBContext context2;
		try {
			String cmdMessage = textMessage.getText();
			context2 = JAXBContext.newInstance(MsgCommand.class);
			Unmarshaller unmarshaller = context2.createUnmarshaller();
			MsgCommand cmd = (MsgCommand) unmarshaller.unmarshal(new StringReader(cmdMessage));
			logger.info("收到的cmd命令为" + cmd.getMsgBody());
			FatchApplicationContext.getApplicationContext().publishEvent(
					new MessageReceiverEvent(this, cmd, Constant.MSG_TYPE_TEXT, Constant.LISTER_TYPE_TOPIC));
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void topicMapMessageHandler(final MapMessage mapMessage) {
		try {
			// 通过key查询
			mapMessage.getBoolean("");
			mapMessage.getByte("");
			mapMessage.getChar("");
			mapMessage.getDouble("");
			mapMessage.getFloat("");
			mapMessage.getInt("");
			mapMessage.getLong("");
			mapMessage.getObject("");
			mapMessage.getShort("");
			mapMessage.getString("");
			FatchApplicationContext.getApplicationContext().publishEvent(
					new MessageReceiverEvent(this, mapMessage, Constant.MSG_TYPE_MAP, Constant.LISTER_TYPE_TOPIC));
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}

	}

	public void topicStreamMessageHandler(final StreamMessage streamMessage) {
		try {
			streamMessage.readBoolean();
			streamMessage.readByte();
			streamMessage.readChar();
			streamMessage.readDouble();
			streamMessage.readFloat();
			streamMessage.readInt();
			streamMessage.readLong();
			streamMessage.readObject();
			streamMessage.readShort();
			streamMessage.readString();
			FatchApplicationContext.getApplicationContext().publishEvent(
					new MessageReceiverEvent(this, streamMessage, Constant.MSG_TYPE_STREAM,
							Constant.LISTER_TYPE_TOPIC));
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void topicBytesMessageHandler(final BytesMessage bytesMessage) {
		byte[] bytes = new byte[1024];
		int len = -1;
		String str = null;
		try {
			while ((len = bytesMessage.readBytes(bytes)) != -1) {
				str += new String(bytes, 0, len);
			}
			logger.info("字节消息为:" + str);
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}

	public void topicObjectMessageHandler(final ObjectMessage objectMessage) {

		try {
			MsgCommand cmd = (MsgCommand) objectMessage.getObject();
			FatchApplicationContext.getApplicationContext().publishEvent(
					new MessageReceiverEvent(this, cmd, Constant.MSG_TYPE_OBJECT, Constant.LISTER_TYPE_TOPIC));
			logger.info("消息事件发送成功");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
