/**
 * Created by lonecloud on 2017/7/16.
 */
var SUCCESS = "success";
var ERROR = "error";
$(function () {
    $("#login").click(function () {
        $.ajax({
            url: "doLogin",
            dataType: "json", 
            type: "POST",
            data: {
            	username: $("#username").val(),
                password: $("#password").val()
            },
            success: function (data) {
                if (SUCCESS == data.code) {
                    window.location.href = "index.html";
                } else {
                    alert(data.message);
                }
            },
            error: function () {
                alert("请求失败")
            }
        });
    })
});