package com.bwie.wechat.customaccount;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.CustomAPI;
import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.CustomAccount;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.GetCustomAccountsResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse.Openid;
import com.github.sd4324530.fastweixin.message.TextMsg;

/**
 * @function 客服测试
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
		CustomAPI customAPI = new CustomAPI(apiConfig);

		// 添加客服账号
//		 CustomAccount customAccount = new CustomAccount();
//		 customAccount.setAccountName("test11@test");
//		 customAccount.setNickName("客服1");
//		 customAccount.setPassword("123");
//		 ResultType resultType = customAPI.addCustomAccount(customAccount);
//		 LOG.debug("添加客服账号结果:{}", resultType);

		// 获取所有客服帐号信息
//		 GetCustomAccountsResponse customAccountAll =
//		 customAPI.getCustomAccountList();
//		 List<CustomAccount> customAccountList =
//		 customAccountAll.getCustomAccountList();
//		 for (CustomAccount c : customAccountList) {
//		 LOG.debug(c.getAccountName() + "--" + c.getNickName() + "---" +
//		 c.getPassword() + "---" + c.getId());
//		 }

		// 删除客服
		// ResultType resultType = customAPI.deleteCustomAccount("test1@test");
		// LOG.debug("删除客服结果:{}", resultType);

		// 设置客服帐号头像
//		 File file = new File("D:/1.jpg");
//		 ResultType resultType = customAPI.uploadHeadImg("test11@test", file);
//		 LOG.debug("设置头像结果:{}", resultType);

		// 获取所有关注者列表
		UserAPI userAPI = new UserAPI(apiConfig);
		GetUsersResponse users = userAPI.getUsers("");
		Openid openid = users.getData();
		String[] openids = openid.getOpenid(); // 获取所有openID
		TextMsg textMsg = new TextMsg("测试客服消息...");
		for (String o : openids) {
			customAPI.sendCustomMessage(o, new String[] { "test11@test" }, textMsg);
		}
	}

}








