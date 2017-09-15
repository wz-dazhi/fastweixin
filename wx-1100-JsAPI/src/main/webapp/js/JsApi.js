var targetUrl = window.location.href;
$(function() {
	//alert(targetUrl);
	$.ajax({
		type: "get",
		data: {
			"url": targetUrl
		},
		url: "enableJsApi",
		success: function(data) {
			//alert(data);
			data = eval("(" + data + ")");
			wx.config({
				debug: false,
				appId: data.appId,
				timestamp: data.timestamp,
				nonceStr: data.nonceStr,
				signature: data.signature,
				jsApiList: [
					'getLocation','openLocation'
				]
			});
			wx.error(function(res) {
				alert("错误:" + res.errMsg);
				options.callback();
			});
			wx.ready(function() {
				wx.getLocation({
					type: 'gcj02', //gcj02 ,默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
					success: function(res) {
						var lat = res.latitude; // 纬度，浮点数，范围为90 ~ -90
						var lon = res.longitude; // 经度，浮点数，范围为180 ~ -180。 
						var speed = res.speed; // 速度，以米/每秒计
						var accuracy = res.accuracy; // 位置精度
						//alert(lat + '--' + lon + '--' + speed + '--' + accuracy);
						$.ajax({ 
						    url: "http://apis.map.qq.com/ws/geocoder/v1/?location="+lat+","+lon+"&coord_type=5&key=CHZBZ-ZWXHU-YRWVV-2RNAM-WR6JZ-TDBJJ&output=jsonp&callback=calllocation", 
						    type:"GET",        
						    dataType:'jsonp',
						    jsonp:'calllocation'
					   }); 
					},
					fail: function() {
						alert('微信定位失败;');
					}
				});
			});
		}
	});
});

function calllocation(data){
		var name = data.result.formatted_addresses.rough; 
		var address = data.result.formatted_addresses.recommend; 
		var lat = data.result.location.lat; 
		var lng = data.result.location.lng; 
		//alert('进入查看地图接口-->' + lat + "-->" + lng);
		//使用微信内置地图查看位置接口
		wx.openLocation({ 
		latitude: lat, // 纬度，浮点数，范围为90 ~ -90 
		longitude: lng, // 经度，浮点数，范围为180 ~ -180。 
		name: name, // 位置名 
		address: address, // 地址详情说明 scale: 18, // 地图缩放级别,整形值,范围从1~28。默认为最大 
		infoUrl: "https://www.baidu.com"// 在查看位置界面底部显示的超链接,可点击跳转 
	});
}






