var lis = document.getElementById("tab").getElementsByTagName("li");// 获取li
var uls = document.getElementById("content").getElementsByTagName("ul");// 获取ul
var bottomLi = document.getElementById("bottomUl").getElementsByTagName("li");// 获取菜单所有li
var bottomUl = document.getElementById("bottomGame").getElementsByTagName("ul");// 获取内容ul
for (var i = 0; i < lis.length; i++) {// 循环给li添加事件
	lis[i].onmouseover = function() {// 给li添加鼠标覆盖事件
		var index = 0;
		for (var j = 0; j < lis.length; j++) {
			if (this.isEqualNode(lis[j])) {// 获取这个li是哪一个li
				index = j;
			}
			lis[j].className = "";// 清除li 的样式
			uls[j].className = "hidden";// 清除ul 的样式
		}
		this.className = "active";// 添加li样式
		uls[index].className = "show"; // 添加ul样式
	}
}
/**
 * 所有游戏点击事件
 */
for (var i = 0; i < bottomLi.length; i++) {
	var index = 0;
	bottomLi[i].onclick = function() {
		for (var j = 0; j < bottomUl.length; j++) {
			if (this.isEqualNode(bottomLi[j])) {
				index = j;
			}
			bottomLi[j].className = "";
			bottomUl[j].className = "hidden";
		}
		this.className = "bottomMenuClick";
		bottomUl[index].className = "";
	}
}
/**
 * 图片的js
 */
function changeImg() {
	// 图片变化
	index++;
	if (index == 5) {
		index = 1;
	}
	document.getElementById("img_banner").className = "login" + " img" + index;//
	// li的样式发生变化
	var lis = document.getElementById("indexUl").getElementsByTagName("li");
	for (var i = 0; i < lis.length; i++) {
		lis[i].className = "gray";
	}
	lis[index - 1].className = "lightblue";
}
/**
 * 鼠标在div的框框的时间
 */
var intervalId = setInterval(changeImg, 2000);
function stop_play() {
	//清除定时器
	clearInterval(intervalId);
	intervalId = null;
}
/**
 * 鼠标不在div时候的时间
 * @returns
 */
function play() {
	if (intervalId == null) {
		//设置了一个定时器
		intervalId = setInterval(changeImg, 2000);//参数1调用函数，2为时间
	}

}
function showImg(i) {
	// 图片变化
	index = i;
	document.getElementById("img_banner").className = "login" + " img" + index;
	// li的样式发生变化
	var lis = document.getElementById("indexUl").getElementsByTagName("li");
	for (var i = 0; i < lis.length; i++) {
		lis[i].className = "gray";
	}
	lis[index - 1].className = "lightblue";
}
/**
 * 登录按钮事件
 */
$("#loginBtn").click(function() {
	$.ajax({
		url : "doLogin",
		dataType : "json",
		type : "POST",
		data : {
			username : $("#username").val(),
			password : $("#password").val()
		},
		success : function(data) {
			if (SUCCESS == data.code) {
				window.location.href = "index.html";
			} else {
				alert(data.message);
			}
		},
		error : function() {
			alert("请求失败")
		}
	});
});
//首页默认判断登录信息
$(function() {
	$.ajax({
		url : "checkToken",
		dataType : "json",
		type : "GET",
		data : {},
		success : function(data) {
			// 判断已经登录
			if (ERROR != data.code) {
				$("#username_href").html(data.username);
				$("#showContent").removeClass("hidden");
				$("#login_content").addClass("hidden");
			} else {
				$("#showContent").addClass("hidden");
				$("#login_content").removeClass("hidden");
			}
		}
	});
});
