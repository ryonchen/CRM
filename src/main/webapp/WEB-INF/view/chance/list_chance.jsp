<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-19
  Time: 0:02
  To change this template use File | Settings | File Templates.
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/utils/moment.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.edatagrid.js"></script>
    <script type="text/javascript" charset="utf-8">
        // var beginDate = new Date(new Date().toLocaleDateString()).getTime()/1000;
        // var endDate = (new Date(new Date().toLocaleDateString()).getTime()+24*60*60*1000)/1000-1;
        var beginDate = null;
        var endDate = null;
        var today =  moment().format('YYYY-MM-DD');
        //DOM加载完成后执行的回调函数
        $(function () {
            console.log('today',today);
            $('#search-begindate').datebox('setValue', today);
            $('#search-enddate').datebox('setValue', today);
            var table;
            //初始化datagrid
            $('#dataList').datagrid({
                iconCls: 'icon-more',//图标
                border: true,
                collapsible: false,//是否可折叠
                fit: true,//自动大小
                method: "post",
                url: "getChanceList?t=" + new Date().getTime(),
                // data: {"beginDate":beginDate,"endDate":endDate},
                queryParams: {"beginDate":$('#search-begindate').datebox('getValue'),"endDate":$('#search-enddate').datebox('getValue')},
                idField: 'chcId',
                singleSelect: false,//是否单选
                rownumbers: true,//行号
                pagination: true,//分页控件
                sortName: 'chcId',
                sortOrder: 'desc',
                // remoteSort: false,
                columns: [[
                    {field: 'chk', checkbox: true, width: 50},
                    {field: 'chcId', title: '编号', width: 50, sortable: true},
                    {field: 'chcSource', title: '机会来源', width: 100},
                    {field: 'chcCustName', title: '客户名称', width: 150},
                    {field: 'chcRate', title: '成功机率', width: 60},
                    {field: 'chcTitle', title: '概要', width: 150},
                    {field: 'chcLinkman', title: '联系人', width: 50},
                    {field: 'chcTel', title: '联系人电话', width: 100},
                    {field: 'chcDesc', title: '机会描述', width: 150},
                    {field: 'chcCreateId', title: '创建人', width: 50},
                    {field: 'chcCreateDate', title: '创建时间', width: 100},
                    {field: 'chcDueTo', title: '指派给', width: 50},
                    {field: 'chcDueDate', title: '指派时间', width: 100},
                    {field: 'chcStatus', title: '状态', width: 50},
                ]],
                loadFilter: function(data){
                    var rows=[];
                    var total=0;
                    if (data.success){
                        total = data.total
                        for(var i=0; i<data.data.length; i++){
                            rows.push(data.data[i]);
                        }
                    } else {
                        $.messager.alert("消息提醒", data.message, "warning");
                    }
                    var result = {rows:rows, total: total}
                    return result;
                },
                // loader: function(param, success, error){
                //     console.log("loader",param)
                //     console.log("success",success)
                //     console.log("error",error)
                //     success(data)
                // },
                toolbar: "#toolbar"//工具栏
            });

            //设置分页控件
            var p = $('#dataList').datagrid('getPager');
            $(p).pagination({
                pageSize: 10,//设置每页显示的记录条数,默认为10
                pageList: [10, 20, 30, 50, 100],//设置每页记录的条数
                beforePageText: '第',
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
            });

            //信息添加按钮事件
            $("#add").click(function () {
                table = $("#addTable");
                $("#addTable").form("clear");//清空表单数据
                $("#addDialog").dialog("open");//打开添加窗口

                $("#add_create_id").textbox('setValue','${userInfo.userId}');//添加创建人
                $("#add_create_id").textbox('setText','${userInfo.userName}');


            });

            //信息修改按钮事件
            $("#edit").click(function () {
                table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择想要修改的数据!", "warning");
                } else {
                    $("#editDialog").dialog("open");
                }
            });

            //信息删除按钮事件
            $("#delete").click(function () {
                var selectRows = $("#dataList").datagrid("getSelections");//返回所有选中的行,当没有选中的记录时,将返回空数组
                var selectLength = selectRows.length;
                if (selectLength === 0) {
                    $.messager.alert("消息提醒", "请选择想要删除的数据!", "warning");
                } else {
                    var ids = [];
                    $(selectRows).each(function (i, row) {
                        ids[i] = row.chcId;//将预删除行的id存储到数组中
                    });
                    $.messager.confirm("消息提醒", "删除后将无法恢复! 确定继续?", function (r) {
                        if (r) {
                            $.ajax({
                                type: "post",
                                url: "deleteChance?t=" + new Date().getTime(),
                                data: {chcIds: ids},
                                dataType: 'json',
                                success: function (data) {
                                    if (data.success) {
                                        $.messager.alert("消息提醒", "删除成功!", "info");
                                        $("#dataList").datagrid("reload");//刷新表格
                                        $("#dataList").datagrid("uncheckAll");//取消勾选当前页所有的行
                                    } else {
                                        $.messager.alert("消息提醒", "服务器端发生异常! 删除失败!", "warning");
                                    }
                                }
                            });
                        }
                    });
                }
            });

            //信息修改按钮事件
            $("#plan").click(function () {
                // table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择数据!", "warning");
                } else {
                    $("#planDialog").dialog("open");
                }
            });

            //设置添加销售机会信息窗口
            $("#addDialog").dialog({
                title: "添加销售机会信息窗口",
                width: 660,
                height: 470,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '添加',
                        plain: true,
                        iconCls: 'icon-add',
                        handler: function () {
                            var validate = $("#addForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据!", "warning");
                            } else {
                                // var data = $("#addForm").serialize();//序列化表单信息
                                var formdata = $("#addForm").serializeArray();
                                var data = {};
                                $(formdata).each(function(index, obj){
                                    data[obj.name] = decodeURIComponent(obj.value.replace(/\+/g," "));;
                                });
                                data['chcCreateId'] = ${userInfo.userId} //创建人
                                $.ajax({
                                    type: "post",
                                    url: "addChance?t=" + new Date().getTime(),
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            $("#addDialog").dialog("close"); //关闭窗口
                                            $('#dataList').datagrid("reload");//重新刷新页面数据
                                            $.messager.alert("消息提醒", "添加成功!", "info");
                                        } else {
                                            var message = "服务端发生未知异常 ";
                                            if(data.msg){
                                                message = message + data.msg
                                            }
                                            $.messager.alert("消息提醒", message, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#add_source").textbox('setValue', "");
                            $("#add_cust_name").textbox('setValue', "");
                            $("#add_desc").textbox('setValue', "");
                            $("#add_title").textbox('setValue', "");
                            $("#add_linkman").textbox('setValue', "");
                            $("#add_rate").textbox('setValue', "");
                            $("#add_tel").textbox('setValue', "");
                        }
                    }
                ]
            });

            //设置编辑销售机会信息窗口
            $("#editDialog").dialog({
                title: "修改销售机会窗口",
                width: 660,
                height: 430,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '提交',
                        plain: true,
                        iconCls: 'icon-edit',
                        handler: function () {
                            var validate = $("#editForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入数据", "warning");
                            } else {
                                // var data = $("#editForm").serialize();//序列化表单信息
                                var formdata = $("#editForm").serializeArray();
                                var data = {};
                                $(formdata).each(function(index, obj){
                                    data[obj.name] = decodeURIComponent(obj.value.replace(/\+/g," "));
                                });
                                $.ajax({
                                    type: "post",
                                    url: "editChance?t=" + new Date().getTime(),
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            //关闭窗口
                                            $("#editDialog").dialog("close");
                                            //重新刷新页面数据
                                            $('#dataList').datagrid("reload");
                                            $('#dataList').datagrid("uncheckAll");
                                            //用户提示
                                            $.messager.alert("消息提醒", "修改成功!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#edit_source").textbox('setValue', "");
                            $("#edit_cust_name").textbox('setValue', "");
                            $("#edit_desc").textbox('setValue', "");
                            $("#edit_title").textbox('setValue', "");
                            $("#edit_linkman").textbox('setValue', "");
                            $("#edit_rate").textbox('setValue', "");
                            $("#edit_tel").textbox('setValue', "");
                        }
                    }
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    $("#edit_id").val(selectRow.chcId);//初始化id值,需根据id更新教师信息
                    $("#edit_source").textbox('setValue', selectRow.chcSource);
                    $("#edit_cust_name").textbox('setValue', selectRow.chcCustName);
                    $("#edit_create_by").textbox('setValue', selectRow.chcCreateBy);
                    $("#edit_create_date").textbox('setValue', selectRow.chcCreateDate);
                    // $("#edit_create_id").textbox('setValue', selectRow.chcCreateId);
                    $("#edit_desc").textbox('setValue', selectRow.chcDesc);
                    $("#edit_due_date").textbox('setValue', selectRow.chcDueDate);
                    $("#edit_due_id").textbox('setValue', selectRow.chcDueId);
                    $("#edit_due_to").textbox('setValue', selectRow.chcDueTo);
                    $("#edit_linkman").textbox('setValue', selectRow.chcLinkman);
                    $("#edit_rate").textbox('setValue', selectRow.chcRate);
                    $("#edit_status").textbox('setValue', selectRow.chcStatus);
                    $("#edit_tel").textbox('setValue', selectRow.chcTel);
                    $("#edit_title").textbox('setValue', selectRow.chcTitle);
                }
            });



            //开发计划窗口
            $("#planDialog").dialog({
                title: "开发计划窗口",
                width: 660,
                height: 430,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '添加',
                        plain: true,
                        iconCls: 'icon-add',
                        handler: function () {
                            $('#planList').edatagrid('addRow',{	row:{
                                    planChcId: $("#dataList").datagrid("getSelected").chcId,
                                }});

                        }
                    },
                    {
                        text: '删除',
                        plain: true,
                        iconCls: 'icon-some-delete',
                        handler: function () {
                            $('#planList').edatagrid('destroyRow');
                        }
                    },
                    {
                        text: '取消',
                        plain: true,
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#planList').edatagrid('cancelRow');
                        }
                    },
                    {
                        text: '开发成功',
                        plain: true,
                        iconCls: 'icon-ok',
                        handler: function () {
                            $.ajax({
                                type: "post",
                                url: "editChance?t=" + new Date().getTime(),
                                data: {chcId: $("#dataList").datagrid("getSelected").chcId, chcStatus:"开发成功"},
                                dataType: 'json',
                                success: function (data) {
                                    if (data.success) {
                                        $.messager.alert("消息提醒", "开发成功!", "info");
                                        $("#dataList").datagrid("reload");//刷新表格
                                    } else {
                                        $.messager.alert("消息提醒", "服务器端发生异常! 更新失败!", "warning");
                                    }
                                }
                            });
                        }
                    },
                    {
                        text: '终止开发',
                        plain: true,
                        iconCls: 'icon-no',
                        handler: function () {
                            $.ajax({
                                type: "post",
                                url: "editChance?t=" + new Date().getTime(),
                                data: {chcId: $("#dataList").datagrid("getSelected").chcId, chcStatus:"终止开发"},
                                dataType: 'json',
                                success: function (data) {
                                    if (data.success) {
                                        $.messager.alert("消息提醒", "终止开发成功!", "info");
                                        $("#dataList").datagrid("reload");//刷新表格
                                    } else {
                                        $.messager.alert("消息提醒", "服务器端发生异常! 更新失败!", "warning");
                                    }
                                }
                            });
                        }
                    },
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    // $("#edit_id").val(selectRow.chcId);//初始化id值,需根据id更新教师信息
                    $('#planList').edatagrid({
                        iconCls: 'icon-more',//图标
                        border: true,
                        collapsible: false,//是否可折叠
                        fit: true,//自动大小
                        method: "post",
                        url: "getPlanList?t=" + new Date().getTime(),
                        destroyUrl:"deletePlan",
                        saveUrl: "addPlan",
                        updateUrl:"editPlan",
                        // data: {"beginDate":beginDate,"endDate":endDate},
                        queryParams: {"chcId":selectRow.chcId},
                        idField: 'planId',
                        singleSelect: true,//是否单选
                        rownumbers: true,//行号
                        pagination: false,//分页控件
                        sortName: 'planId',
                        sortOrder: 'asc',
                        autoSave: true,
                        // remoteSort: false,
                        columns: [[
                            {field: 'planChcId', title: '机会ID', width: 120, editor:{options:{readonly:true}}},
                            {field: 'planDate', title: '日期', width: 120, editor:{type:'datetimebox',options:{required:true}}},
                            {field: 'planTodo', title: '计划', width: 150, editor:"text"},
                            {field: 'planResult', title: '执行结果', width: 150,editor:"{type:'textarea'}" },
                        ]],
                        loadFilter: function(data){
                            var rows=[];
                            var total=0;
                            if (data.success){
                                total = data.data.length
                                for(var i=0; i<data.data.length; i++){
                                    rows.push(data.data[i]);
                                }
                            } else {
                                $.messager.alert("消息提醒", data.message, "warning");
                            }
                            var result = {rows:rows, total: total}
                            return result;
                        },
                        onBeforeSave:function(index,row){
                            console.log("onBeforeSave index",index)
                            console.log("onBeforeSave row",row)
                            // $.messager.alert("系统消息","保存成功"+row.name);
                        },
                        onSave:function(index,row){
                            console.log("onSave index",index)
                            console.log("onSave row",row)
                            if(row.success){
                                $.messager.alert("系统消息","编辑成功"+row.planId);
                            }else{
                                $.messager.alert("系统消息","编辑失败");
                                $("#planList").datagrid("reload");//刷新表格
                                $("#planList").datagrid("uncheckAll");//取消勾选当前页所有的行
                            }
                        },
                        onAdd:function(index,row){
                            console.log("onAdd index",index)
                            console.log("onAdd row",row)

                        },
                        onEdit:function(index,row){
                            console.log("onEdit index",index)
                            console.log("onEdit row",row)
                        },
                        onDestroy:function(index,row){
                            console.log("onDestroy index",index)
                            console.log("onDestroy row",row)
                            if(row.success){
                                $.messager.alert("系统消息","删除成功"+row.planId);
                            }else{
                                $.messager.alert("系统消息","删除失败");
                                $("#planList").datagrid("reload");//刷新表格
                                $("#planList").datagrid("uncheckAll");//取消勾选当前页所有的行
                            }
                        },
                        onEndEdit:function(index,row){
                            console.log("onEndEdit index",index)
                            console.log("onEndEdit row",row)
                        },
                        onBeforeEdit:function(index,row){
                            console.log("onBeforeEdit index",index)
                            console.log("onBeforeEdit row",row)
                        },
                        onAfterEdit:function(index,row){
                            console.log("onAfterEdit index",index)
                            console.log("onAfterEdit row",row)
                        },
                        onCancelEdit:function(index,row){
                            console.log("onCancelEdit index",index)
                            console.log("onCancelEdit row",row)
                        },
                        //销毁行的时候显示的确认对话框消息
                        destroyMsg:{
                            norecord:{    // 在没有记录选择的时候执行
                                title:'警告',
                                msg:'没有选中行'
                            },
                            confirm:{       // 在选择一行的时候执行
                                title:'确认',
                                msg:'确定要删除吗?'
                                //$.messager.alert("系统消息","删除"+row.name);
                            }
                        },
                    });
                },
            });



            //搜索按钮的监听事件(将其值返回给Controller)
            $("#search-btn").click(function () {
                $("#dataList").datagrid("uncheckAll");
                $('#dataList').datagrid('load', {
                    beginDate: $('#search-begindate').datebox('getValue'),//开始时间
                    endDate: $('#search-enddate').datebox('getValue'),//结束时间
                    custName:$('#search-custname').textbox('getValue'),
                    title:$('#search-title').textbox('getValue'),
                    linkman:$('#search-linkman').textbox('getValue')
                });
            });


        });

        $('#search-begindate').datebox({
            onSelect: function(date){
                beginDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());

            }
        });

        $('#search-enddate').datebox({
            onSelect: function(date){
                endDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
            }
        });




    </script>
</head>
<body>

<!-- 销售机会列表信息 -->
<table id="dataList" cellspacing="0" cellpadding="0"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="float: left;"><a id="add" href="javascript:" class="easyui-linkbutton"
                                 data-options="iconCls:'icon-add',plain:true">添加</a></div>
    <div style="float: left;" class="datagrid-btn-separator"></div>
    <%-- 通过JSTL设置用户操作权限: 将修改和删除按钮设置为仅管理员可见 --%>
    <%--<c:if test="${userType==1}">--%>
        <div style="float: left;"><a id="edit" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-edit',plain:true">修改</a></div>
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <div style="float: left;"><a id="delete" href="javascript:" class="easyui-linkbutton"
                                     data-options="iconCls:'icon-some-delete',plain:true">删除</a></div>
    <%--</c:if>--%>
    <div style="float: left;" class="datagrid-btn-separator"></div>
    <div style="float: left;"><a id="plan" href="javascript:" class="easyui-linkbutton"
                                  data-options="plain:true">开发计划</a></div>
    <!-- 销售机会搜索域 -->
    <div style="margin-left: 10px;">
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <!-- 销售机会搜索框 -->
        <a href="javascript:" class="easyui-linkbutton"
           data-options="plain:true">客户名称</a>
        <input id="search-custname" class="easyui-textbox" style="width:100px"/>
        <a href="javascript:" class="easyui-linkbutton"
           data-options="plain:true">概要</a>
        <input id="search-title" class="easyui-textbox" style="width:100px"/>
        <a href="javascript:" class="easyui-linkbutton"
           data-options="plain:true">联系人</a>
        <input id="search-linkman" class="easyui-textbox" style="width:100px"/>
        <a href="javascript:" class="easyui-linkbutton"
           data-options="plain:true">创建日期</a>
        <input id="search-begindate" type="text" class="easyui-datebox" required="required" style="width:100px">
        <a href="javascript:" class="easyui-linkbutton"
           data-options="plain:true">到</a>
        <input id="search-enddate" type="text" class="easyui-datebox" required="required" style="width:100px">
        <!-- 搜索按钮 -->
        <a id="search-btn" href="javascript:" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true">搜索</a>
    </div>

</div>

<!-- 添加信息窗口 -->
<div id="addDialog" style="padding: 15px 0 0 55px;">
    <!-- 销售机会信息表单 -->
    <form id="addForm" method="post" action="#">
        <table id="addTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <tr>
                <td>机会来源</td>
                <td colspan="1">
                    <select id="add_source" style="width: 200px; height: 30px;" class="easyui-combobox"
                            name="chcSource" data-options="required:true, missingMessage:'请选择机会来源'">
                        <option value=客户介绍>客户介绍</option>
                        <option value="网上">网上</option>
                        <option value="报纸">报纸</option>
                        <option value="其他">其他</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>客户名称</td>
                <td colspan="1">
                    <input id="add_cust_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcCustName" data-options="required:true, missingMessage:'请填写客户名称'"/>
                </td>
            </tr>
            <tr>
                <td>成功机率</td>
                <td colspan="1">
                    <input id="add_rate" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcRate" data-options="required:true, missingMessage:'请填写成功机率'"/>
                </td>
            </tr>
            <tr>
                <td>概要</td>
                <td>
                    <input id="add_title" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcTitle" data-options="required:true, missingMessage:'请填写概要'"/>
                </td>
            </tr>
            <tr>
                <td>联系人</td>
                <td>
                    <input id="add_linkman" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcLinkman" />
                </td>
            </tr>
            <tr>
                <td>联系人电话</td>
                <td>
                    <input id="add_tel" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcTel" validType="mobile"/>
                </td>
            </tr>
            <tr>
                <td>机会描述</td>
                <td>
                    <input id="add_desc" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcDesc" data-options="required:true, missingMessage:'请填写机会描述'"/>
                </td>
            </tr>
            <tr>
                <td>创建人</td>
                <td>
                    <input id="add_create_id" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcCreateId" data-options="readonly:true" readonly="true"/>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td>创建时间</td>--%>
<%--                <td>--%>
<%--                    <input id="add_create_date" style="width: 200px; height: 30px;" class="easyui-textbox"--%>
<%--                           type="text" name="chcCreateDate" />--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td>指派给</td>
                <td colspan="1">
                    <input id="add_due_to" style="width: 200px; height: 30px;" class="easyui-textbox"
                           name="chcDueTo" />
                </td>
            </tr>
            <tr>
                <td>指派时间<td>
                <td colspan="1">
                <%--<input id="add_due_date" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="chcDueDate" />--%>
                <input id="add_due_date" type="text" class="easyui-datetimebox" name="chcDueDate">
                </td>
            </tr>
        </table>
    </form>
</div>


<!-- 修改信息窗口 -->
<div id="editDialog" style="padding: 20px 0 0 65px">
    <!-- 教师信息表单 -->
    <form id="editForm" method="post" action="#">
        <!-- 获取被修改信息的教师id -->
        <input type="hidden" id="edit_id" name="chcId"/>
        <table id="editTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <tr>
                <td>机会来源</td>
                <td colspan="1">
                    <select id="edit_source" style="width: 200px; height: 30px;" class="easyui-combobox"
                            name="chcSource">
                        <option value=客户介绍>客户介绍</option>
                        <option value="网上">网上</option>
                        <option value="报纸">报纸</option>
                        <option value="其他">其他</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>客户名称</td>
                <td colspan="1">
                    <input id="edit_cust_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcCustName" data-options="required:true, missingMessage:'请填写客户名称'"/>
                </td>
            </tr>
            <tr>
                <td>成功机率</td>
                <td colspan="1">
                    <input id="edit_rate" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcRate" data-options="required:true, missingMessage:'请填写成功机率'"/>
                </td>
            </tr>
            <tr>
                <td>概要</td>
                <td colspan="1">
                    <!-- 设置为只读 -->
                    <input id="edit_title" data-options="readonly: true" style="width: 200px; height: 30px;"
                           class="easyui-textbox" type="text" name="chcTitle" data-options="required:true, missingMessage:'请填写概要'"/>
                </td>
            </tr>
            <tr>
                <td>联系人</td>
                <td colspan="1"><input id="edit_linkman" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="chcLinkman" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>联系人电话</td>
                <td colspan="4"><input id="edit_tel" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="chcTel" validType="mobile"
                                       data-options="required:true, missingMessage:'请填写联系方式'"/>
                </td>
            </tr>
            <tr>
                <td>机会描述</td>
                <td colspan="1"><input id="edit_desc" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="chcDesc"
                                       data-options="required:true, missingMessage:'请填写机会描述'"/>
                </td>
            </tr>
            <tr>
                <td>创建人</td>
                <td>
                    <input id="edit_create_id" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="chcCreateId" />
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td>创建时间</td>--%>
<%--                <td>--%>
<%--                    <input id="edit_create_date" style="width: 200px; height: 30px;" class="easyui-textbox"--%>
<%--                           type="text" name="chcCreateDate" />--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td>指派给</td>
                <td colspan="1">
                    <input id="edit_due_to" style="width: 200px; height: 30px;" class="easyui-textbox" name="chcDueTo" />
                </td>
            </tr>
            <tr>
                <td>指派时间<td>
                <td colspan="1"><input id="edit_due_date" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="chcDueDate" />
                </td>
            </tr>
        </table>
    </form>
</div>


<!-- 开发计划窗口 -->
<div id="planDialog" style="">
    <table id="planList" cellspacing="0" cellpadding="0" >
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th field="planDate" width="100" editor="{type:'datetimebox',options:{required:true}}">日期</th>--%>
            <%--<th field="planTodo" width="100" editor="text">计划</th>--%>
            <%--<th field="planResult" width="100" align="right" editor="{type:'textarea'}">执行结果</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>

    </table>

</div>

<!-- 表单处理 -->
<%--<iframe id="photo_target" name="photo_target" onload="uploaded(this)"></iframe>--%>

</body>
</html>

