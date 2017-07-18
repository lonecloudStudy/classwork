/**
 * Created by lonecloud on 2017/7/17.
 */
var SUCCESS = "success";
var ERROR = "error";
//隐藏页面的注册和登录和注册按钮，以及注销按钮
$(function() {
    $.ajax({
        url : "checkToken",
        dataType : "json",
        type : "GET",
        data : {},
        success : function(data) {
            // 判断已经登录
            if (ERROR != data.code) {
                $("[href='register.html']").hide();
                $("[href='login.html']").hide();
            } else {
                $("[href='logout']").hide();
            }
        }
    });
});