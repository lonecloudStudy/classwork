var SUCCESS = "success";
var ERROR = "error";
$(function () {
    $("#register").click(function () {
    	checkUserName();
        $.ajax({
            url: "register",
            type: "POST",
            dataType: "json", 
            data: $("#registerForm").serialize(),
            success: function (data) {
                if (SUCCESS = data.code) {
                    alert("用户注册成功");
                } else {
                    alert("该用户不可用");
                }
            },
            error: function () {
                alert("请求失败")
            }
        });
    });
    function checkUserName(){
    	$.ajax({
            url: "checkUser",
            type: "POST",
            dataType: "json", 
            data: {
                type: "username",
                value: $("#username").val()
            },
            success: function (data) {
                if (SUCCESS = data.code) {
                    alert("该用户可用");
                } else {
                    alert("该用户不可用");
                }
            },
            error: function () {
                alert("请求失败")
            }
        });
    }
});