package com.bwie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bwie.service.WeChatService;
import com.bwie.service.config.MyConfig;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;

/**
 * @function
 * @author 王治
 * @date 2017年8月15日
 */
@RestController
@RequestMapping("/fastweixin")
public class WeChatController extends WeixinControllerSupport {

	private static final Logger LOG = LoggerFactory.getLogger(WeChatController.class);

	@Autowired
	private MyConfig config;

	@Autowired
	private WeChatService service;

	// 接入js sdk签名
	@RequestMapping("/enableJsApi")
	public String enableJsApi(String url) {
		LOG.info("url:" + url);
		return service.enableJsApi(url);
	}

	// 跳转到JsApi.jsp
	@RequestMapping("/jsApi")
	public ModelAndView jsApi() {
		return new ModelAndView("JsApi");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.sd4324530.fastweixin.servlet.WeixinSupport#handleSubscribe(com
	 * .github.sd4324530.fastweixin.message.req.BaseEvent)
	 */
	@Override
	protected BaseMsg handleSubscribe(BaseEvent event) {
		LOG.info("---欢迎关注---");
		return new TextMsg("欢迎关注!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#getAESKey()
	 */
	@Override
	protected String getAESKey() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#getAppId()
	 */
	@Override
	protected String getAppId() {
		return config.getAppid();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.sd4324530.fastweixin.servlet.WeixinSupport#getToken()
	 */
	@Override
	protected String getToken() {
		return config.getToken();
	}

}
