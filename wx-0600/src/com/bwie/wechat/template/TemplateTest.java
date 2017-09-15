package com.bwie.wechat.template;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.TemplateMsgAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Industry;
import com.github.sd4324530.fastweixin.api.entity.TemplateMsg;
import com.github.sd4324530.fastweixin.api.entity.TemplateParam;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.AddTemplateResponse;
import com.github.sd4324530.fastweixin.api.response.BaseResponse;
import com.github.sd4324530.fastweixin.api.response.PrivateTemplate;
import com.github.sd4324530.fastweixin.api.response.SendTemplateResponse;

/**
 * @function 模板消息接口测试
 * @author 王治
 * @date 2017年7月6日
 */
public class TemplateTest {

	private static final Logger LOG = LoggerFactory.getLogger(TemplateTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApiConfig apiConfig = new ApiConfig("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		TemplateMsgAPI templateMsgAPI = new TemplateMsgAPI(apiConfig);

		// 设置所属行业
		// Industry industry = new Industry();
		// industry.setIndustryId1("2");
		// industry.setIndustryId2("1");
		// ResultType resultType = templateMsgAPI.setIndustry(industry);
		// LOG.info("设置所属行业:" + resultType);
		// 添加模板
//		AddTemplateResponse addTemplate = templateMsgAPI.addTemplate("TM00001");
//		LOG.info(addTemplate.getTemplateId() + "-->" + addTemplate.getErrcode() + "-->" + addTemplate.getErrmsg());

		// 发送模板消息
		TemplateMsg msg = new TemplateMsg();
		// 我的oMFX51NR7hR5JTfE2uzTZVKcD_FU,超哥oMFX51N4iU7lwJQ7QpT9iSyEHx5Y,老板oMFX51N7-BqBZd2uPCWvlP7aFWPk
		// 冷哥oMFX51BQn6HE4wGEKzvY6-53VpuE
//		msg.setTouser("oMFX51NR7hR5JTfE2uzTZVKcD_FU");
//		msg.setTemplateId("VJmIqWOwtPGNeIUP8vZO-lt3PxG0Gw6Y6jGDRzciioY");
//		msg.setUrl("https://www.baidu.com");
//		msg.setTopcolor("#FF0000");
//		Map<String, TemplateParam> data = new HashMap<String, TemplateParam>();
//		data.put("first", new TemplateParam("尊敬的会员，XX项目已购买成功！", "#173177"));
//		data.put("keyword1", new TemplateParam(new DateTime().toString("yyyy年MM月dd日"), "#173177"));
//		data.put("keyword2", new TemplateParam("积木乐园年卡", "#173177"));
//		data.put("keyword3", new TemplateParam("500元", "#173177"));
//		data.put("keyword4", new TemplateParam("微信扫码", "#173177"));
//		data.put("keyword5", new TemplateParam("北京-龙旗(玩塾乐园)", "#173177"));
//		data.put("remark", new TemplateParam("多谢惠顾，欢迎再次光临！", "#173177"));
//
//		msg.setData(data);
		// 发送模板消息
//		SendTemplateResponse str = templateMsgAPI.send(msg);
//		LOG.info("发送结果--->errcode:" + str.getErrcode() + "errmsg:" + str.getErrmsg() + "msgid:" + str.getMsgid());

		// 获取已添加至帐号下所有模板列表
		// PrivateTemplate[] templates = templateMsgAPI.getAllPrivateTemplate();
		// for (PrivateTemplate p : templates) {
		// LOG.info("模板ID" + p.getTemplateId() + "模板标题" + p.getTitle() +
		// "模板所属行业的一级行业" + p.getPrimaryIndustry()
		// + "模板所属行业的二级行业" + p.getDeputyIndustry() + "模板内容" + p.getContent() +
		// "模板示例" + p.getExample() + "模板备注"
		// + p.getRemark());
		// }

		// 删除模板
		// BaseResponse delTemplate =
		// templateMsgAPI.delTemplate("hGLgYv4G8B-JWYGyZ6Y2-t4jOMDXeQZyq4nfEV-Q4Vw");
		// LOG.info("删除模板:" + delTemplate);
	}

}
