package com.bwie.wechat.menu;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;

/**
 * @function 菜单测试
 * @author 王治
 * @date 2017年7月6日
 */
public class Test {
	
	private static final Logger LOG = LoggerFactory.getLogger(Test.class);
	
	//创建菜单
	public static Menu createMenu(){
		Menu menu = new Menu();
		List<MenuButton> menuButtons = new ArrayList<MenuButton>();
		menuButtons.add(button11());
		menuButtons.add(button12());
		menuButtons.add(button13());
		
		menu.setButton(menuButtons);
		return menu;
	}
	
	//一级菜单
	private static MenuButton button11(){
		MenuButton button = new MenuButton();
		button.setName("天气预报");
		button.setKey("V1001_TODAY_WEATHER");
		button.setType(MenuType.CLICK);
		return button;
	}
	
	//二级菜单
	private static MenuButton button12(){
		MenuButton button = new MenuButton();
		button.setName("微信内置地图");
		button.setUrl("http://17u4f31513.51mypc.cn/wx-1100-JsAPI/fastweixin/jsApi");
		button.setType(MenuType.VIEW);
		return button;
	}
	
	//三级菜单
	private static MenuButton button13(){
		MenuButton button = new MenuButton();
		button.setName("菜单");
		
		MenuButton button21 = new MenuButton();
		button21.setName("百度");
		button21.setUrl("https://www.baidu.com");
		button21.setType(MenuType.VIEW);
		
		MenuButton button22 = new MenuButton();
		button22.setName("搜搜");
		button22.setUrl("http://www.soso.com");
		button22.setType(MenuType.VIEW);
		
		List<MenuButton> subButton = new ArrayList<>();
		subButton.add(button21);
		subButton.add(button22);
		
		button.setSubButton(subButton);
		return button;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApiConfig apiConfig = new ApiConfig("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		MenuAPI menuAPI = new MenuAPI(apiConfig);
		//创建菜单
		ResultType resultType = menuAPI.createMenu(createMenu());
		LOG.debug("菜单创建结果:{}", resultType);
		
		//获取菜单
//		GetMenuResponse menu = menuAPI.getMenu();
//		LOG.debug("获取菜单结果:{}", menu.getMenu());
		
		//删除菜单
//		ResultType deleteMenu = menuAPI.deleteMenu();
//		LOG.debug("删除菜单结果:{}", deleteMenu);
	}

}
