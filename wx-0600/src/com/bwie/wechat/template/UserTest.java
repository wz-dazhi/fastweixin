/**
 * 
 */
package com.bwie.wechat.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse;

/**
 * @function 获取关注用户信息
 * @author 王治
 * @date 2017年8月14日
 */
public class UserTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApiConfig apiConfig = new ApiConfig("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		UserAPI userAPI = new UserAPI(apiConfig);
		// 获取所有用户openID
		GetUsersResponse users = userAPI.getUsers(null);
		LOG.info(
				"总用户数:" + users.getTotal() + "OPENID个数:" + users.getCount() + "最后一个用户的OPENID:" + users.getNextOpenid());
		String[] openids = users.getData().getOpenid();
		LOG.info("OPENID的列表:");
		for (String o : openids) {
			// LOG.info(o);
			//获取关注者信息
			GetUserInfoResponse userInfo = userAPI.getUserInfo(o);
			LOG.info("关注者的昵称:" + userInfo.getNickname());
//			if (userInfo.getNickname().equals("回头丶yi无路可走")) {
//				break;
//			}
//			if (userInfo.getNickname().equals("春天")) {
//				break;
//			}
//			if (userInfo.getNickname().equals("你不懂")) {
//				break;
//			}
			if (userInfo.getNickname().equals("春风")) {
				break;
			}
		}
	}

}
