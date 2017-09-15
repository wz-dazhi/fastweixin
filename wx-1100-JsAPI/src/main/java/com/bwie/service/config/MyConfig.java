/**
 * 
 */
package com.bwie.service.config;

import org.springframework.stereotype.Component;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;

/**
 * @function  自己的配置
 * @author 王治
 * @date 2017年8月15日
 */
@Component
public class MyConfig {

	private static final String TOKEN = "wangzhi";

	private static final String APPID = "wx2f9cdd6430278db7";

	private static final String SECRET = "f34b751c34c6557d9b9220eea8f1eec0";

	private static final String AESKEY = "KAnGtZ1eswSKu95zAubvqHVRrq1ntP8TE8fkLcg3hpO";

	private String token = TOKEN;
	private String appid = APPID;
	private String secret = SECRET;
	private String aeskey = AESKEY;

	/*
	 * @param enableJsApi 是否启动js api
	 * @return ApiConfig
	 */
	public ApiConfig getApiConfig(boolean enableJsApi) {
		return new ApiConfig(getAppid(), getSecret(), enableJsApi);
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid
	 *            the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the aeskey
	 */
	public String getAeskey() {
		return aeskey;
	}

	/**
	 * @param aeskey
	 *            the aeskey to set
	 */
	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}

}
