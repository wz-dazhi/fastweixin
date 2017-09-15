package com.bwie.wechat.upload.materia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.CustomAPI;
import com.github.sd4324530.fastweixin.api.MaterialAPI;
import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Article;
import com.github.sd4324530.fastweixin.api.entity.CustomAccount;
import com.github.sd4324530.fastweixin.api.enums.MaterialType;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.github.sd4324530.fastweixin.api.response.GetCustomAccountsResponse;
import com.github.sd4324530.fastweixin.api.response.GetMaterialListResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse;
import com.github.sd4324530.fastweixin.api.response.GetUsersResponse.Openid;
import com.github.sd4324530.fastweixin.api.response.UploadMaterialResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.github.sd4324530.fastweixin.message.TextMsg;

/**
 * @function 素材测试
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
		// File file = new File("D:/images/360壁纸 12842.jpg");
		// File file = new File("D:/images/07VT72QP9L20.jpg");
		File file = new File("D:/images/5.jpg");

		// 上传临时素材
		// MediaAPI mediaAPI = new MediaAPI(apiConfig);
		// UploadMediaResponse uf = mediaAPI.uploadMedia(MediaType.IMAGE, file);
		// LOG.debug("上传临时素材结果:{}", uf.getMediaId() + "->" + uf.getType() + "->"
		// + uf.getCreatedAt());

		// 永久素材
		MaterialAPI materialAPI = new MaterialAPI(apiConfig);

		// 上传图片素材
		// UploadMaterialResponse uploadMaterialFile =
		// materialAPI.uploadMaterialFile(file);
		// LOG.debug("上传永久图片素材MediaId:{}", uploadMaterialFile.getMediaId());

		// 上传视频素材
		// UploadMaterialResponse uploadMaterialFile =
		// materialAPI.uploadMaterialFile(file, "小视频", "视频的描述");
		// LOG.debug("上传永久视频素材MediaId:{}", uploadMaterialFile.getMediaId());

		// 因为上传图文消息用到了图片的MediaId,所以先获取素材列表
		// 上传图文消息
//		List<Article> articles = new ArrayList<Article>();
//		Article article1 = new Article(null, "王治11", "标题11", "https://www.baidu.com", "正文11", "图文消息的摘要11", 1);
//		Article article2 = new Article(null, "王治22", "标题22", "https://www.baidu.com", "正文22", "图文消息的摘要22", 1);
//		Article article3 = new Article(null, "王治33", "标题33", "https://www.baidu.com", "正文33", "图文消息的摘要33", 1);
//		// 获取素材列表
//		GetMaterialListResponse batchGetMaterial = materialAPI.batchGetMaterial(MaterialType.IMAGE, 0, 10);
//		List<Map<String, Object>> items = batchGetMaterial.getItems();
//		int index = 0;
//		// 遍历素材列表
//		for (Map<String, Object> map : items) {
//			Set<Entry<String, Object>> entrySet = map.entrySet();
//			for (Entry<String, Object> entry : entrySet) {
//				if ("media_id".equals(entry.getKey())) {
//					index++;
//					if (index == 1) {
//						article1.setThumbMediaId(entry.getValue().toString());
//					} else if (index == 2) {
//						article2.setThumbMediaId(entry.getValue().toString());
//					} else if (index == 3) {
//						article3.setThumbMediaId(entry.getValue().toString());
//					}
//				}
//			}
//		}
//		articles.add(article1);
//		articles.add(article2);
//		articles.add(article3);
//		UploadMaterialResponse uploadMaterialNews = materialAPI.uploadMaterialNews(articles);
//		LOG.debug("上传永久图文素材MediaId:{}", uploadMaterialNews.getMediaId());

		// ...删除,下载就不测试了

	}

}
