<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" charset="utf-8"/>
    <title>客户管理系统 | 登录页面 </title>
    <!-- 引入CSS -->
    <link href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/h-ui/lib/icheck/icheck.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/lib/icheck/jquery.icheck.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/utils/md5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/utils/StringUtils.js"></script>
    <!-- 页面事件 -->
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/login.js"></script>--%>
    <script type="text/javascript" charset="utf-8">
        <%--<%@ include file="/WEB-INF/view/common/login.js"%>--%>
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
                                $.messager.alert("提示", res.message, "warning");
                                $("#vcodeImg").click();//切换验证码
                                $("input[name='vcode']").val("");//清空验证码输入框
                            }
                        }
                    });
                }
            });

        })
    </script>

</head>
<body style="font-weight: lighter; ">
<div class="header" style="padding: 0;">
    <h3 style="font-weight: lighter; color: white; width: 550px; height: 60px; line-height: 60px; margin: 0 0 0 30px; padding: 0;">
        CRM客户关系管理系统
    </h3>
</div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form id="form" class="form form-horizontal" method="post" action="#">
            <!-- 用户身份信息 -->
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe60a;</i></label>
                <div class="formControls col-8">
                    <input id="username" name="username" type="text" placeholder="账户" class="input-text radius size-L"
                           data-options="label:'userName:',required:true"/>
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe63f;</i></label>
                <div class="formControls col-8">
                    <input id="password" name="password" type="password" placeholder="密码"
                           class="input-text radius size-L" data-options="label:'password:',required:true"/>
                </div>
            </div>
            <!-- 验证码 -->
            <div class="row cl">
                <label class="form-label col-3"><i class="Hui-iconfont">&#xe647;</i></label>
                <div class="formControls col-8">
                    <input id="verifiCode" class="input-text radius size-L" name="verifiCode" type="text"
                           placeholder="字母不区分大小写" data-options="required:true"
                           style="width: 250px;">
                    <img title="点击图片切换验证码" id="vcodeImg" src="getVerifiCodeImage" alt="#">
                </div>
            </div>
            <!-- 登录按钮 -->
            <div class="row">
                <div class="formControls col-8 col-offset-3">
                    <input id="submitBtn" type="button" class="btn btn-primary radius" value="&nbsp;
                    登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>

<!-- 页面底部 -->
<div class="footer">
    Copyright @ 2019  All rights reserved
</div>


</body>
</html>
