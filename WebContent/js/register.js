var SUCCESS = "success";
var ERROR = "error";
$(function() {
	$("#register").click(function() {
		// 校验数据正确性
		if (checkField("#username")) {
			alert("用户名不能为空");
			return;
		}
		if (checkField("#password")) {
			alert("密码不能为空")
			return

		}
		if ($("#rePassword").val() != $("#password").val()) {
			alert("输入的两次密码不一致")
			return

		}
		if (checkField("#email")) {
			alert("请输入正确的email")
			return

		}
		$.ajax({
			url : "register",
			type : "POST",
			dataType : "json",
			data : $("#registerForm").serialize(),
			success : function(data) {
				if (SUCCESS == data.code) {
					alert("用户注册成功");
					window.location.href = "index.html";
				} else {
					alert("该用户已经被注册");
				}
			},
			error : function() {
				alert("请求失败")
			}
		});
	});
	function checkUserName() {
		$.ajax({
			url : "checkUser",
			type : "POST",
			dataType : "json",
			data : {
				type : "username",
				value : $("#username").val()
			},
			success : function(data) {
				if (SUCCESS == data.code) {
					alert("该用户可用");
				} else {
					alert("该用户不可用");
				}
			},
			error : function() {
				alert("请求失败")
			}
		});
	}
	function checkField(field) {
		var val = $(field).val();
		return val == null || val == undefined || val == "";
	}
});