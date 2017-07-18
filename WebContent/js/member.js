var changeInfo=document.getElementById("changeInfo");
var changeEmail=document.getElementById("changeEmail");
var changePwd=document.getElementById("changePwd");
function changeBar(index) {
    if(index==1){
        changeInfo.className="";
        changeEmail.className="hidden";
        changePwd.className="hidden";
    }
    if(index==2){
        changeInfo.className="hidden";
        changeEmail.className="";
        changePwd.className="hidden";
    }
    if(index==3){
        changeInfo.className="hidden";
        changeEmail.className="hidden";
        changePwd.className="";
    }
}
$(function(){
	$.ajax({
        url: "getUser",
        dataType: "json",
        type: "GET",
        data: {
        },
        success: function (data) {
            $("#id").val(data.id);
            $(".user_name").html(data.username);
            $("#lastLoginTime").html(data.logintime);
            $("#user_email").html(data.email);
        },
        error: function () {
            alert("请求失败")
        }
    });
    $("#submitInfo").click(function () {
        $.ajax({
            url: "updateUserInfo",
            dataType: "json",
            type: "POST",
            data:$("#infoForm").serialize(),
            success: function (data) {
                if(SUCCESS==data.code){
                    alert(data.message);
                    location.reload();
                }
            },
            error: function () {
                alert("请求失败")
            }
        });
    })
});