$(function () {
    //点击图片切换验证码
    $("#vcodeImg").click(function () {
        this.src = "getVerifiCodeImage?t=" + new Date().getTime();
    });
    //登录
    $("#submitBtn").click(function () {
        //检查登录信息
        var userName = $('#username').val();
        var password = $('#password').val();
        var verifiCode = $('#verifiCode').val();
        if (StringUtils.isEmpty(userName)) {
            $.messager.alert("提示", "请输入用户名 !", "warning");
        } else if (StringUtils.isEmpty(password)) {
            $.messager.alert("提示", "请输入密码 !", "warning");
        } else if (StringUtils.isEmpty(verifiCode)) {
            $.messager.alert("提示", "请输入验证码 !", "warning");
        } else {
            //提交用户的登录表单信息
            var formData = {
                userName: userName,
                password: hex_md5(password), //MD5加密
                verifiCode: verifiCode
            };
            //向服务端发送请求
            $.ajax({
                type: "post",
                url: "login",
                data: formData,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (res) {
                    console.log(JSON.stringify(res));
                    if (res.success) {
                        window.location.href = "/crm/index";//进入系统主页面
                    } else {
                        $.messager.alert("提示", data.message, "warning");
                        $("#vcodeImg").click();//切换验证码
                        $("input[name='vcode']").val("");//清空验证码输入框
                    }
                }
            });
        }
    });

})