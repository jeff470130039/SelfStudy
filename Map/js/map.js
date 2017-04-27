var mapObj;
var point = new AMap.LngLat(120.148373,30.290422);
function mapInit(){   
//初始化地图对象，加载地图。
mapObj = new AMap.Map("iCenter",{    
		center : point, //地图中心点
		level : 15  //地图显示的缩放级别    
	});
}