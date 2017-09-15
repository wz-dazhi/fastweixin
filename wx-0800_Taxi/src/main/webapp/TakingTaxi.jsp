<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"> 
		<link rel="stylesheet" href="css/weui.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="application/javascript">
			$(function() {
				$('#startMap').click(function() {
					$('#form1').hide();
					$('#mapPage').show();
				});
				$('#endMap').click(function() {
					$('#form1').hide();
					$('#poiPage').show();
				});
				$('#showTooltips').click(function() {
					var start = $('#addr1').val();
					var end = $('#addr2').val();
					var iphone = $('#iphone').val();
					if (start === '') {
						alert('起始地点不能为空!');
						return false;
					}
					if (end === '') {
						alert('目的地不能为空!');
						return false;
					}
					if (iphone === '') {
						alert('手机号不能为空!');
						return false;
					} else if (!(/^1(3|4|5|7|8)\d{9}$/.test(iphone))) {
						alert("手机号码有误，请重填");
						return false;
					}
					location.href = "fastweixin/formMsg?start=" + start + "&end=" + end + "&iphone=" + iphone;
				});
			});
		</script>
		<title>我要打车</title>
	</head>

	<body>
		<div id="form1">
			<div class="weui-cells__title">
				<h1 style="color: red;text-align: center;margin-top: 10px;margin-bottom: 10px;">您要去哪儿?</h1>
			</div>
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label" style="text-align: center;color: greenyellow;width: 50px;">●</label>
					</div>
					<div class="weui-cell__bd">
						<a href="#" style="color:black;" id="startMap">
							<input class="weui-input" type="text" id="addr1" value="" placeholder="您的位置" />
						</a>
					</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label" style="text-align: center;color: red;width: 50px;">●</label>
					</div>
					<div class="weui-cell__bd">
						<a href="#" style="color:black;" id="endMap">
							<input class="weui-input" type="text" id="addr2" value="" placeholder="您要去哪儿" />
						</a>	
					</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<input class="weui-input" type="tel" id="iphone" style="text-align: center;" placeholder="请输入手机号">
					</div>
				</div>
			</div>
			<div class="weui-btn-area" style="margin-top: 30px;">
				<a class="weui-btn weui-btn_plain-default" href="#" id="showTooltips" style="width: 200px;">呼叫出租车</a>
			</div> 
		</div>
		
		<!-- 前端定位 -->
		<iframe id="geoPage" width=0 height=0 frameborder=0 s	tyle="display:none;" scrolling="no" src="https://apis.map.qq.com/tools/geolocation?key=CHZBZ-ZWXHU-YRWVV-2RNAM-WR6JZ-TDBJJ&referer=myapp"></iframe>
		<!-- 起始地点选点 -->
		<iframe hidden="hidden" id="mapPage" width="100%" height="700px;" frameborder=0 src="http://apis.map.qq.com/tools/locpicker?search=1&type=1&key=CHZBZ-ZWXHU-YRWVV-2RNAM-WR6JZ-TDBJJ&referer=myapp"></iframe>
		<!-- 目的地POI搜索 -->
		<iframe hidden="hidden" id="poiPage" width="100%" height="500px;" frameborder=0 src="http://17u4f31513.51mypc.cn/wx-0800_Taxi/poiSearch.html"></iframe>
		
		<script>
			window.addEventListener('message', function(event) {
				// 接收位置信息，用户选择确认位置点后选点组件会触发该事件，回传用户的位置信息
				var loc = event.data;
				if(loc && loc.module == 'locationPicker') { //防止其他应用也会向该页面post信息，需判断module是否为'locationPicker'
					//alert(loc.module);
					var l = loc.latlng;
					//alert(l.lat + "--" + l.lng);
					//alert(loc.poiaddress);
					//alert(loc.poiname);
					//alert(loc.cityname);
					$('#addr1').val(loc.poiname);
					$('#mapPage').hide();
					$('#form1').show();
				}
				if(loc && loc.module == 'geolocation') {
					//alert(loc.province);
					//alert(loc.city);
					//alert(loc.district);
					//alert(loc.addr);
					//alert(loc.lat + "--" + loc.lng + "-误差:" + loc.accuracy);
					$('#addr1').val(loc.addr);
				}
			}, false);
		</script>
	</body>
	
</html>