<%--
  Created by IntelliJ IDEA.
  User: 黄宇辉
  Date: 6/18/2019
  Time: 9:37 AM
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" content="#">
    <title>营销机会管理</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/css/demo.css">
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/easyui/js/validateExtends.js"></script>

    <script type="text/javascript">
        <%@ include file="/WEB-INF/view/sales/chance.js"%>
    </script>
</head>
<body>

<!-- 教师列表信息 -->
<table id="dataList" cellspacing="0" cellpadding="0"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="float: left;"><a id="add" href="javascript:" class="easyui-linkbutton"
                                 data-options="iconCls:'icon-add',plain:true">添加</a></div>
    <div style="float: left;" class="datagrid-btn-separator"></div>
    <%-- 通过JSTL设置用户操作权限: 将修改和删除按钮设置为仅管理员可见 --%>
    <c:if test="${userType==1}">
        <div style="float: left;"><a id="edit" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-edit',plain:true">修改</a></div>
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <div style="float: left;"><a id="delete" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-some-delete',plain:true">删除</a></div>
    </c:if>

    <!-- 教师,班级名搜索域 -->
    <div style="margin-left: 10px;">
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <!-- 班级名称下拉框 -->
        <a href="javascript:" class="easyui-linkbutton"
           data-options="iconCls:'icon-class',plain:true">班级名称</a>
        <select id="search-clazzname" style="width: 155px;" class="easyui-combobox" name="clazzname">
            <!-- 通过JSTL遍历显示年级信息,clazzList:为Contrller传递的来的,存储着Clazz的List对象 -->
            <option value="">未选择班级</option>
            <c:forEach items="${clazzList}" var="clazz">
                <option value="${clazz.name}">${clazz.name}</option>
            </c:forEach>
        </select>
        <!-- 教师姓名搜索框 -->
        <a href="javascript:" class="easyui-linkbutton"
           data-options="iconCls:'icon-user-teacher',plain:true">教师名称</a>
        <input id="search-teachername" class="easyui-textbox" name="studentname"/>
        <!-- 搜索按钮 -->
        <a id="search-btn" href="javascript:" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>
</div>

<!-- 添加信息窗口 -->
<div id="addDialog" style="padding: 15px 0 0 55px;">
    <!-- 设置添加头像功能 -->
    <div style="float: right; margin: 15px 40px 0 0; width: 250px; border: 1px solid #EEF4FF" id="add-photo">
        <img id="add-portrait" alt="照片" style="max-width: 250px; max-height: 300px;" title="照片"
             src="${pageContext.request.contextPath}/image/portrait/default_teacher_portrait.png"/>
        <!-- 头像信息表单 -->
        <form id="add-uploadForm" method="post" enctype="multipart/form-data" action="uploadPhoto"
              target="photo_target">
            <input id="choose-portrait" class="easyui-filebox" name="photo" data-options="prompt:'选择照片'"
                   style="width:200px;">
            <input id="add-upload-btn" class="easyui-linkbutton" style="width: 50px; height: 24px;;float:right;"
                   type="button" value="上传"/>
        </form>
    </div>
    <!-- 教师信息表单 -->
    <form id="addForm" method="post" action="#">
        <table id="addTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <!-- 存储所上传的头像路径 -->
            <input id="add_portrait-path" type="hidden" name="portrait_path"/>
            <tr>
                <td>班级</td>
                <td colspan="1">
                    <select id="add_clazz_name" style="width: 200px; height: 30px;" class="easyui-combobox"
                            name="clazz_name" data-options="required:true, missingMessage:'请选择所属班级哟~'">
                        <c:forEach items="${clazzList}" var="clazz">
                            <option value="${clazz.name}">${clazz.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>机会来源</td>
                <td colspan="1">
                    <input id="add_source" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="source"/>
                </td>
            </tr>
            <tr>
                <td>客户名称</td>
                <td colspan="1">
                    <input id="add_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="name" data-options="required:true, missingMessage:'请填写客户名称'"/>
                </td>
            </tr>
            <tr>
                <td>成功机率%</td>
                <td>
                    <input id="add_rate" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="rate" data-options="required:true, missingMessage:'请填写机率'"/>
                </td>
            </tr>
            <tr>
                <td>概要</td>
                <td>
                    <input id="add_title" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="title" />
                </td>
            </tr>
            <tr>
                <td>联系人</td>
                <td>
                    <input id="add_contact" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="contact" />
                </td>
            </tr>
            <tr>
                <td>联系电话</td>
                <td>
                    <input id="add_tel" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="tel" validType="mobile"/>
                </td>
            </tr>
            <tr>
                <td>创建人</td>
                <td>
                    <input id="add_creatuser" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="creatuser" />
                </td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td>
                    <input id="add_createtime" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="createtime" />
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td colspan="1">
                    <input id="add_password" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="password" name="password" data-options="required:true, missingMessage:'请填写自定义密码哟~'"/>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td colspan="1"><input id="add_email" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="email" validType="email"/>
                </td>
            </tr>
        </table>
    </form>
</div>


<!-- 修改信息窗口 -->
<div id="editDialog" style="padding: 20px 0 0 65px">
    <!-- 设置修改头像功能 -->
    <div style="float: right; margin: 15px 40px 0 0; width: 250px; border: 1px solid #EEF4FF" id="edit-photo">
        <img id="edit-portrait" alt="照片" style="max-width: 250px; max-height: 300px;" title="照片"
             src="${pageContext.request.contextPath}/image/portrait/default_student_portrait.png"/>
        <!-- 头像信息表单 -->
        <form id="edit-uploadForm" method="post" enctype="multipart/form-data" action="uploadPhoto"
              target="photo_target">
            <input id="edit-choose-portrait" class="easyui-filebox" name="photo" data-options="prompt:'选择照片'"
                   style="width:200px;">
            <input id="edit-upload-btn" class="easyui-linkbutton" style="width: 50px; height: 24px;;float:right;"
                   type="button" value="上传"/>
        </form>
    </div>
    <!-- 教师信息表单 -->
    <form id="editForm" method="post" action="#">
        <!-- 获取被修改信息的教师id -->
        <input type="hidden" id="edit_id" name="id"/>
        <table id="editTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <!-- 存储所上传的头像路径 -->
            <input id="edit_portrait-path" type="hidden" name="portrait_path"/>
            <tr>
                <td>班级</td>
                <td colspan="1">
                    <select id="edit_clazz_name" style="width: 200px; height: 30px;" class="easyui-combobox"
                            name="clazz_name">
                        <c:forEach items="${clazzList}" var="clazz">
                            <option value="${clazz.name}">${clazz.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td colspan="1">
                    <input id="edit_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="name" data-options="required:true, missingMessage:'请填写姓名哟~'"/>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select id="edit_gender" class="easyui-combobox"
                            data-options="editable: false, panelHeight: 50, width: 60, height: 30" name="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>工号</td>
                <td colspan="1">
                    <!-- 设置为只读 -->
                    <input id="edit_tno" data-options="readonly: true" style="width: 200px; height: 30px;"
                           class="easyui-textbox" type="text"/>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td colspan="1"><input id="edit_email" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="email" validType="email"
                                       data-options="required:true, missingMessage:'请填写邮箱地址哟~'"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="4"><input id="edit_telephone" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="telephone" validType="mobile"
                                       data-options="required:true, missingMessage:'请填写联系方式哟~'"/>
                </td>
            </tr>
            <tr>
                <td>住址</td>
                <td colspan="1"><input id="edit_address" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="address"
                                       data-options="required:true, missingMessage:'请填写家庭住址哟~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<!-- 表单处理 -->
<iframe id="photo_target" name="photo_target" onload="uploaded(this)"></iframe>

</body>
</html>
