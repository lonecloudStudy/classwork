/**
 * Created by lonecloud on 2017/7/16.
 */
var SUCCESS = "success";
var ERROR = "error";
$(function() {
	$("#login").click(function() {
		//校验数据
		if(checkField("#username")){
			alert("用户名不能为空")
			return
		}
		if(checkField("#password")){
			alert("密码不能为空")
			return
		}
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
	})
	function checkField(field) {
		var val = $(field).val();
		return val == null || val == undefined || val == "";
	}
});