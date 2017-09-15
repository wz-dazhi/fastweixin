package com.bwie.wechat.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetSendMessageResponse;
import com.github.sd4324530.fastweixin.message.TextMsg;

/**
 * @function 群发测试
 * @author 王治
 * @date 2017年7月6日
 */
public class Test {

	private static final Logger LOG = LoggerFactory.getLogger(Test.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApiConfig apiConfig = new ApiConfig("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		MessageAPI messageAPI = new MessageAPI(apiConfig);
		//群发了一个文本消息
		TextMsg textMsg = new TextMsg("王治群发了一个消息...");
		GetSendMessageResponse sendMessageToUser = messageAPI.sendMessageToUser(textMsg, true, null);
		LOG.debug("群发之后的结果{}:", sendMessageToUser.getMsgId());
	}

}
