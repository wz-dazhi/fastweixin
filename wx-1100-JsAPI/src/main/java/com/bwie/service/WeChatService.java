/**
 * 
 */
package com.bwie.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwie.service.config.MyConfig;
import com.github.sd4324530.fastweixin.api.JsAPI;
import com.github.sd4324530.fastweixin.api.response.GetSignatureResponse;
import com.github.sd4324530.fastweixin.util.JSONUtil;

/**
 * @function
 * @author 王治
 * @date 2017年8月15日
 */
@Service
public class WeChatService {

	@Autowired
	private MyConfig config;

	// 启用JsAPI
	public String enableJsApi(String url) {
		JsAPI jsAPI = new JsAPI(config.getApiConfig(true));
		System.out.println("--------------------getConfig-----------------" + url);
		Map<String, Object> map = new HashMap<>();
		GetSignatureResponse signature = jsAPI.getSignature(url);

		map.put("appId", config.getAppid());
		map.put("timestamp", signature.getTimestamp());
		map.put("nonceStr", signature.getNoncestr());
		map.put("signature", signature.getSignature());
		map.put("url", signature.getUrl());
		map.put("errcode", signature.getErrcode());
		map.put("errmsg", signature.getErrmsg());

		String jsonString = JSONUtil.toJson(map);
		System.out.println(JSONUtil.prettyFormatJson(jsonString));
		return jsonString;
	}
}






