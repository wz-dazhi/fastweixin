package com.bwie.wechat.qrcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.QrcodeAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.QrcodeType;
import com.github.sd4324530.fastweixin.api.response.QrcodeResponse;

/**
 * @function 二维码测试
 * @author 王治
 * @date 2017年8月15日
 */
public class QrcodeTest {

	private static final Logger LOG = LoggerFactory.getLogger(QrcodeTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApiConfig apiConfig = new ApiConfig("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		QrcodeAPI qrcodeAPI = new QrcodeAPI(apiConfig);
		// 创建临时二维码,有效期600秒
		QrcodeResponse qr = qrcodeAPI.createQrcode(QrcodeType.QR_SCENE, "123", 600);
		LOG.info("Url:" + qr.getUrl() + "Ticket:" + qr.getTicket() + "ExpireSeconds:" + qr.getExpireSeconds());

	}

}


