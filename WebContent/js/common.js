/**
 * Created by lonecloud on 2017/7/17.
 */
var SUCCESS = "success";
var ERROR = "error";
//隐藏页面的注册和登录和注册按钮，以及注销按钮
//定义一个准备函数
$(function() {
	//ajax请求
    $.ajax({
        url : "checkToken",//请求的后端地址
        dataType : "json",//返回的数据类型为json
        type : "GET",//请求类型GET
        data : {},//请求参数
        success : function(data) {//请求成功后回调的函数
            // 判断已经登录
            if (ERROR != data.code) {//判断返回的json 中cod值是success还是error
            	//成功之后隐藏登录注册按钮
                $("[href='register.html']").hide();
                $("[href='login.html']").hide();
            } else {
            	//注销功能按钮隐藏
                $("[href='logout']").hide();
            }
        }
    });
});