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
    <title>客户信息管理</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" charset="utf-8">
        // var beginDate = new Date(new Date().toLocaleDateString()).getTime()/1000;
        // var endDate = (new Date(new Date().toLocaleDateString()).getTime()+24*60*60*1000)/1000-1;
        var beginDate = null;
        var endDate = null;
        var today =  moment().format('YYYY-MM-DD');
        var satisfyData = [{id:1,name:"❤"},{id:2,name:"❤❤"},{id:3,name:"❤❤❤"},{id:4,name:"❤❤❤❤"},{id:5,name:"❤❤❤❤❤"}]
        var creditData = [{id:1,name:"❤"},{id:2,name:"❤❤"},{id:3,name:"❤❤❤"},{id:4,name:"❤❤❤❤"},{id:5,name:"❤❤❤❤❤"}]
        var levelData = []
        //DOM加载完成后执行的回调函数
        $(function () {
            var table;
            $.ajax({
                type: "post",
                url: "/crm/dict/getCstLevel?t=" + new Date().getTime(),
                data: {dictType: '企业客户等级'},
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        levelData = data.data
                        $('#edit_level').combobox('loadData',data.data)
                    } else {
                        $.messager.alert("消息提醒", "服务器端发生异常! 获取用户等级失败!", "warning");
                    }
                }
            });
            //初始化datagrid
            $('#dataList').datagrid({
                iconCls: 'icon-more',//图标
                border: true,
                collapsible: false,//是否可折叠
                fit: true,//自动大小
                method: "post",
                url: "getClientList?t=" + new Date().getTime(),
                // data: {"beginDate":beginDate,"endDate":endDate},
                queryParams: {"userId": ${userInfo.userId}},
                idField: 'cstId',
                singleSelect: false,//是否单选
                rownumbers: true,//行号
                pagination: true,//分页控件
                sortName: 'cstId',
                sortOrder: 'desc',
                // remoteSort: false,
            columns: [[
                    {field: 'chk', checkbox: true, width: 50},
                    {field: 'cstId', title: '编号', width: 50, sortable: true},
                    {field: 'cstAddr', title: '地址', width: 100},
                    {field: 'cstBank', title: '开户银行', width: 100},
                    {field: 'cstBankAccount', title: '银行账号', width: 100},
                    {field: 'cstBankroll', title: '注册资金', width: 50},
                    {field: 'cstChieftain', title: '法人', width: 50},
                    {field: 'cstCredit', title: '客户信用度', width: 80,
                        formatter:function(value){
                            var result="";
                            for(var i=1;i<=value;i++){
                                result = result + "❤"
                            }
                            return result;
                        }},
                    {field: 'cstFax', title: '传真', width: 100},
                    {field: 'cstLevel', title: '客户等级', width: 100,
                        formatter:function(value){
                            for(var i=0; i<levelData.length; i++){
                                if (levelData[i].dictValue == value) return levelData[i].dictItem;
                            }
                            return value;
                        }},
                    // {field: 'cstLevelLabel2', title: '客户等级', width: 100},
                    {field: 'cstLicenceNo', title: '营业执照', width: 100},
                    {field: 'cstLocalTaxNo', title: '地税登记号', width: 100},
                    {field: 'cstManagerId', title: '客户经理ID', width: 50, hidden:true},
                {field: 'cstName', title: '客户名称', width: 100},
                {field: 'cstNationalTaxNo', title: '国税等级好', width: 100},
                {field: 'cstRegion', title: '地区', width: 60},
                {field: 'cstSatisfy', title: '满意度', width: 80,
                    formatter:function(value){
                        var result="";
                        for(var i=1;i<=value;i++){
                            result = result + "❤"
                        }
                        return result;
                    }},
                {field: 'cstTel', title: '电话', width: 100},
                {field: 'cstTurnover', title: '营业额', width: 100},
                {field: 'cstWebsite', title: '官网', width: 100},
                {field: 'cstZip', title: '邮编', width: 50},
                {field: 'custManagerName2', title: '客户经理名称', width: 100},
                {field: 'cstStatus', title: '状态', width: 50},
                ]],
                loadFilter: function(data){
                    var rows=[];
                    var total=0;
                    if (data.success){
                        total = data.total
                        for(var i=0; i<data.data.length; i++){
                            rows.push(data.data[i]);
                            rows[i].cstLevelLabel2 = data.data[i].cstLevelInfo.dictItem
                            rows[i].custManagerName2 = data.data[i].managerInfo.userName
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

            //打开联系人窗口
            $("#linkman").click(function () {
                // table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择数据!", "warning");
                } else {
                    $("#linkmanDialog").dialog("open");
                }
            });

            //打开交往记录窗口
            $("#activity").click(function () {
                // table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择数据!", "warning");
                } else {
                    $("#activityDialog").dialog("open");
                }
            });

            //打开历史订单窗口
            $("#order").click(function () {
                // table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择数据!", "warning");
                } else {
                    $("#orderDialog").dialog("open");
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
                title: "修改客户信息窗口",
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
                                    url: "editClient?t=" + new Date().getTime(),
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
                            // $("#edit_source").textbox('setValue', "");
                            // $("#edit_cust_name").textbox('setValue', "");
                            // $("#edit_desc").textbox('setValue', "");
                            // $("#edit_title").textbox('setValue', "");
                            // $("#edit_linkman").textbox('setValue', "");
                            // $("#edit_rate").textbox('setValue', "");
                            // $("#edit_tel").textbox('setValue', "");
                        }
                    }
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    $("#edit_id").val(selectRow.cstId);//初始化id值
                    $("#edit_address").textbox('setValue', selectRow.cstAddr);
                    $("#edit_bank").textbox('setValue', selectRow.cstBank);
                    $("#edit_bank_account").textbox('setValue', selectRow.cstBankAccount);
                    $("#edit_bankroll").textbox('setValue', selectRow.cstBankroll);
                    $("#edit_chieftain").textbox('setValue', selectRow.cstChieftain);
                    $("#edit_credit").combobox('setValue', selectRow.cstCredit);
                    $("#edit_fax").textbox('setValue', selectRow.cstFax);
                    $("#edit_level").combobox('setValue', selectRow.cstLevel);
                    $("#edit_licence_no").textbox('setValue', selectRow.cstLicenceNo);
                    $("#edit_local_tax_no").textbox('setValue', selectRow.cstLocalTaxNo);
                    $("#edit_name").textbox('setValue', selectRow.cstName);
                    $("#edit_national_tax_no").textbox('setValue', selectRow.cstNationalTaxNo);
                    $("#edit_region").textbox('setValue', selectRow.cstRegion);
                    $("#edit_satisfy").combobox('setValue', selectRow.cstSatisfy);
                    $("#edit_tel").textbox('setValue', selectRow.cstTel);
                    $("#edit_turnover").textbox('setValue', selectRow.cstTurnover);
                    $("#edit_website").textbox('setValue', selectRow.cstWebsite);
                    $("#edit_zip").textbox('setValue', selectRow.cstZip);
                }
            });

            //联系人窗口
            $("#linkmanDialog").dialog({
                title: "联系人窗口",
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
                            $('#linkmanList').edatagrid('addRow',{	row:{
                                    cstCustomerTCstId: $("#dataList").datagrid("getSelected").cstId,
                                }});

                        }
                    },
                    {
                        text: '删除',
                        plain: true,
                        iconCls: 'icon-some-delete',
                        handler: function () {
                            $('#linkmanList').edatagrid('destroyRow');
                        }
                    },
                    {
                        text: '取消',
                        plain: true,
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#linkmanList').edatagrid('cancelRow');
                        }
                    },
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    // $("#edit_id").val(selectRow.chcId);//初始化id值,需根据id更新教师信息
                    $('#linkmanList').edatagrid({
                        iconCls: 'icon-more',//图标
                        border: true,
                        collapsible: false,//是否可折叠
                        fit: true,//自动大小
                        method: "post",
                        url: "/crm/linkman/getLinkmanList?t=" + new Date().getTime(),
                        destroyUrl:"/crm/linkman/deleteLinkman",
                        saveUrl: "/crm/linkman/addLinkman",
                        updateUrl:"/crm/linkman/editLinkman",
                        // data: {"beginDate":beginDate,"endDate":endDate},
                        queryParams: {"cstId":selectRow.cstId},
                        idField: 'linkId',
                        singleSelect: true,//是否单选
                        rownumbers: true,//行号
                        pagination: false,//分页控件
                        sortName: 'linkId',
                        sortOrder: 'asc',
                        autoSave: true,
                        // remoteSort: false,
                        columns: [[
                            {field: 'cstCustomerTCstId', title: '客户ID', width: 120, editor:{options:{readonly:true}}},
                            {field: 'linkName', title: '联系人', width: 120, editor:{type:'text',options:{required:true}}},
                            {field: 'linkSex', title: '性别', width: 150, editor:{
                                    type:'combobox',
                                    options:{
                                        valueField:'id',
                                        textField:'name',
                                        data:[{id:'1',name:'男'},{id:'2',name:'女'}]
                                    },
                                },
                                formatter: function(value,row,index){
                                    if (value == '1'){
                                        return '男';
                                    } else if (value == '2'){
                                        return '女';
                                    } else {
                                        return value;
                                    }
                                }},
                            {field: 'linkPosition', title: '职位', width: 150,editor:{type:'text',options:{required:true}} },
                            {field: 'linkTel', title: '办公电话', width: 150, editor:{type:'text',options:{required:true}}},
                            {field: 'linkMobile', title: '手机', width: 150, editor:"text"},
                            {field: 'linkMemo', title: '备注', width: 150, editor:"text"},
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
                        onSave:function(index,row){
                            console.log("onSave index",index)
                            console.log("onSave row",row)
                            if(row.success){
                                $.messager.alert("系统消息","编辑成功"+row.linkId);
                            }else{
                                $.messager.alert("系统消息","编辑失败");
                                $("#linkmanList").datagrid("reload");//刷新表格
                                $("#linkmanList").datagrid("uncheckAll");//取消勾选当前页所有的行
                            }
                        },
                        onDestroy:function(index,row){
                            console.log("onDestroy index",index)
                            console.log("onDestroy row",row)
                            if(row.success){
                                $.messager.alert("系统消息","删除成功"+row.linkId);
                            }else{
                                $.messager.alert("系统消息","删除失败");
                                $("#linkmanList").datagrid("reload");//刷新表格
                                $("#linkmanList").datagrid("uncheckAll");//取消勾选当前页所有的行
                            }
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

            //交往记录窗口
            $("#activityDialog").dialog({
                title: "交往记录窗口",
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
                            $('#activityList').edatagrid('addRow',{	row:{
                                    cstCustomerTCstId: $("#dataList").datagrid("getSelected").cstId,
                                }});

                        }
                    },
                    {
                        text: '删除',
                        plain: true,
                        iconCls: 'icon-some-delete',
                        handler: function () {
                            $('#activityList').edatagrid('destroyRow');
                        }
                    },
                    {
                        text: '取消',
                        plain: true,
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#activityList').edatagrid('cancelRow');
                        }
                    },
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    // $("#edit_id").val(selectRow.chcId);//初始化id值,需根据id更新教师信息
                    $('#activityList').edatagrid({
                        iconCls: 'icon-more',//图标
                        border: true,
                        collapsible: false,//是否可折叠
                        fit: true,//自动大小
                        method: "post",
                        url: "/crm/activity/getActivityList?t=" + new Date().getTime(),
                        destroyUrl:"/crm/activity/deleteActivity",
                        saveUrl: "/crm/activity/addActivity",
                        updateUrl:"/crm/activity/editActivity",
                        // data: {"beginDate":beginDate,"endDate":endDate},
                        queryParams: {"cstId":selectRow.cstId},
                        idField: 'atvId',
                        singleSelect: true,//是否单选
                        rownumbers: true,//行号
                        pagination: false,//分页控件
                        sortName: 'atvId',
                        sortOrder: 'asc',
                        autoSave: true,
                        // remoteSort: false,
                        columns: [[
                            {field: 'cstCustomerTCstId', title: '客户ID', width: 120, editor:{options:{readonly:true}}},
                            {field: 'atvDate', title: '日期', width: 120, editor:{type:'datetimebox',options:{required:true}}},
                            {field: 'atvPlace', title: '地点', width: 120, editor:{type:'text',options:{required:true}}},
                            {field: 'atvTitle', title: '概要', width: 150,editor:{type:'text',options:{required:true}} },
                            {field: 'atvDesc', title: '备注', width: 150, editor:{type:'text',options:{required:true}}},
                            {field: 'atvDetail', title: '详细信息', width: 150, editor:"textarea"},
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
                        onSave:function(index,row){
                            console.log("onSave index",index)
                            console.log("onSave row",row)
                            if(row.success){
                                $.messager.alert("系统消息","编辑成功"+row.atvId);
                            }else{
                                $.messager.alert("系统消息","编辑失败");
                                $("#activityList").datagrid("reload");//刷新表格
                                $("#activityList").datagrid("uncheckAll");//取消勾选当前页所有的行
                            }
                        },
                        onDestroy:function(index,row){
                            console.log("onDestroy index",index)
                            console.log("onDestroy row",row)
                            if(row.success){
                                $.messager.alert("系统消息","删除成功"+row.atvId);
                            }else{
                                $.messager.alert("系统消息","删除失败");
                                $("#activityList").datagrid("reload");//刷新表格
                                $("#activityList").datagrid("uncheckAll");//取消勾选当前页所有的行
                            }
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

            //历史订单窗口 只有查询
            $("#orderDialog").dialog({
                title: "历史订单",
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
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    // $("#edit_id").val(selectRow.chcId);//初始化id值,需根据id更新教师信息
                    $('#orderList').datagrid({
                        iconCls: 'icon-more',//图标
                        border: true,
                        collapsible: false,//是否可折叠
                        fit: true,//自动大小
                        method: "post",
                        url: "/crm/indent/getIndentList?t=" + new Date().getTime(),
                        // data: {"beginDate":beginDate,"endDate":endDate},
                        queryParams: {"cstId":selectRow.cstId},
                        idField: 'indentId',
                        singleSelect: true,//是否单选
                        rownumbers: true,//行号
                        pagination: false,//分页控件
                        sortName: 'indentId',
                        sortOrder: 'asc',
                        autoSave: true,
                        view: detailview,
                        // remoteSort: false,
                        columns: [[
                            {field: 'cstCustomerTCstId', title: '客户ID', width: 120, editor:{options:{readonly:true}}},
                            {field: 'indentId', title: '订单编号', width: 150, editor:{type:'text',options:{required:true}}},
                            {field: 'indendDate', title: '日期', width: 120, editor:{type:'datetimebox',options:{required:true}}},
                            {field: 'indentDestination', title: '送货地址', width: 120, editor:{type:'text',options:{required:true}}},
                            {field: 'indentState', title: '状态', width: 150,editor:{type:'text',options:{required:true}} },
                            {field: 'total', title: '总金额', width: 150, editor:{type:'text',options:{required:true}}},
                        ]],
                        detailFormatter: function(rowIndex, rowData) {
                            var result = '<table border="1" cellspacing="2" cellpadding="0" width="100%"><thead><tr><th>商品</th><th>数量</th><th>单价</th><th>金额</th></tr></thead><tbody>'
                            var data = rowData.detail
                            for(var i=0;i<data.length;i++){
                                var item = '<tr><td>'+data[i].proName+'</td>'+
                                    '<td>'+data[i].amount+'</td>'+
                                    '<td>'+data[i].price+'</td>'+
                                    '<td>'+data[i].total+'</td></tr>'
                                result = result + item
                            }
                            result = result + '</tbody></table>'
                            return result;
                        },
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
                    });
                },
            });

            //搜索按钮的监听事件(将其值返回给Controller)
            $("#search-btn").click(function () {
                $("#dataList").datagrid("uncheckAll");
                $('#dataList').datagrid('load', {
                    userId: ${userInfo.userId},//开始时间
                    cstName: $('#search-name').textbox('getValue')
                });
            });


        });
    </script>
</head>
<body>

<!-- 销售机会列表信息 -->
<table id="dataList" cellspacing="0" cellpadding="0"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <%-- 客户由销售机会同步过来 不需要新增--%>
    <%--<div style="float: left;"><a id="add" href="javascript:" class="easyui-linkbutton"--%>
                                 <%--data-options="iconCls:'icon-add',plain:true">添加</a></div>--%>
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
    <div style="float: left;"><a id="linkman" href="javascript:" class="easyui-linkbutton"
                                 data-options="plain:true">联系人</a></div>
    <div style="float: left;"><a id="activity" href="javascript:" class="easyui-linkbutton"
                                 data-options="plain:true">交往记录</a></div>
    <div style="float: left;"><a id="order" href="javascript:" class="easyui-linkbutton"
                                 data-options="plain:true">历史订单</a></div>
    <!-- 销售机会搜索域 -->
    <div style="margin-left: 10px;">
        <div style="float: left;" class="datagrid-btn-separator"></div>
        <!-- 销售机会搜索框 -->
        <a href="javascript:" class="easyui-linkbutton"
           data-options="plain:true">客户名称</a>
        <input id="search-name" class="easyui-textbox" style="width:100px"/>
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
                <td>客户名称</td>
                <td colspan="1">
                    <input id="add_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstName" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>客户地址</td>
                <td colspan="1">
                    <input id="add_address" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstAddress" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>邮政编码</td>
                <td colspan="1">
                    <input id="add_zip" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstZip" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="1">
                    <input id="add_tel" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstTel" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>传真</td>
                <td colspan="1">
                    <input id="add_fax" style="width: 150px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstFax" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>官网</td>
                <td colspan="1">
                    <input id="add_website" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstWebsite" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>营业执照注册号</td>
                <td colspan="1">
                    <input id="add_licence_no" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstLicenceNo" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>法人</td>
                <td colspan="1">
                    <input id="add_chieftain" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstChieftain" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>注册资金（万元）</td>
                <td colspan="1">
                    <input id="add_bankroll" style="width: 50px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstBankroll" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>年营业额</td>
                <td colspan="1">
                    <input id="add_turnover" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstTurnover" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>开户银行</td>
                <td colspan="1">
                    <input id="add_bank" style="width: 100px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstBank" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>银行账号</td>
                <td colspan="1">
                    <input id="add_bank_account" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstBankAccount" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>地税登记号</td>
                <td colspan="1">
                    <input id="add_local_tax_no" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstLocalTaxNo" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>国税登记号</td>
                <td colspan="1">
                    <input id="add_national_tax_no" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstNationalTaxNo" data-options=""/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td colspan="1">
                    <!-- 设置为只读 -->
                    <input id="add_region" data-options="readonly: true" style="width: 200px; height: 30px;"
                           class="easyui-textbox" type="text" name="cstRegion" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>客户经理</td>
                <td colspan="1"><input id="add_manager_id" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="cstManagerId" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>客户等级</td>
                <td colspan="1">
                    <input id="add_level" class="easyui-combobox" name="cstLevel"
                           style="width: 100px; height: 30px;"
                           data-options="valueField: 'dictValue',textField: 'dictItem'"
                    >
                </td>
            </tr>
            <tr>
                <td>客户满意度</td>
                <td colspan="1">
                    <input id="add_satisfy"
                           style="width: 200px; height: 30px;"
                           class="easyui-combobox" name="cstSatisfy"
                           data-options=" valueField:'id',
                                        textField:'name',
                                        data:[{id:1,name:'❤'},{id:2,name:'❤❤'},{id:3,name:'❤❤❤'},{id:4,name:'❤❤❤❤'},{id:5,name:'❤❤❤❤❤'}],
                                        required:true,
                                        missingMessage:'必填'">
                </td>
            </tr>
            <tr>
                <td>客户信用度</td>
                <td colspan="1">
                    <input id="add_credit"
                           style="width: 200px; height: 30px;"
                           class="easyui-combobox" name="cstCredit"
                           data-options=" valueField:'id',
                                        textField:'name',
                                        data:[{id:1,name:'❤'},{id:2,name:'❤❤'},{id:3,name:'❤❤❤'},{id:4,name:'❤❤❤❤'},{id:5,name:'❤❤❤❤❤'}],
                                        required:true,
                                        missingMessage:'必填'">
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
                <td>客户名称</td>
                <td colspan="1">
                    <input id="edit_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstName" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>客户地址</td>
                <td colspan="1">
                    <input id="edit_address" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstAddress" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>邮政编码</td>
                <td colspan="1">
                    <input id="edit_zip" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstZip" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="1">
                    <input id="edit_tel" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstTel" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>传真</td>
                <td colspan="1">
                    <input id="edit_fax" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstFax" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>官网</td>
                <td colspan="1">
                    <input id="edit_website" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstWebsite" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>营业执照注册号</td>
                <td colspan="1">
                    <input id="edit_licence_no" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstLicenceNo" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>法人</td>
                <td colspan="1">
                    <input id="edit_chieftain" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstChieftain" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>注册资金（万元）</td>
                <td colspan="1">
                    <input id="edit_bankroll" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstBankroll" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>年营业额</td>
                <td colspan="1">
                    <input id="edit_turnover" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstTurnover" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>开户银行</td>
                <td colspan="1">
                    <input id="edit_bank" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstBank" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>银行账号</td>
                <td colspan="1">
                    <input id="edit_bank_account" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstBankAccount" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>地税登记号</td>
                <td colspan="1">
                    <input id="edit_local_tax_no" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstLocalTaxNo" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>国税登记号</td>
                <td colspan="1">
                    <input id="edit_national_tax_no" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="cstNationalTaxNo" data-options=""/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td colspan="1">
                    <!-- 设置为只读 -->
                    <input id="edit_region" data-options="readonly: true" style="width: 200px; height: 30px;"
                           class="easyui-textbox" type="text" name="cstRegion" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>客户经理</td>
                <td colspan="1"><input id="edit_manager_id" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="cstManagerId" data-options="required:true, missingMessage:'必填'"/>
                </td>
            </tr>
            <tr>
                <td>客户等级</td>
                <td colspan="1">
                    <input id="edit_level" class="easyui-combobox" name="cstLevel"
                           style="width: 200px; height: 30px;"
                           data-options="valueField: 'dictValue',textField: 'dictItem'">
                    <%--<select id="edit_level" style="width: 200px; height: 30px;" class="easyui-combobox"--%>
                            <%--name="cstLevel" data-options="required:true, missingMessage:'必填'">--%>
                        <%--<option value="1">❤</option>--%>
                        <%--<option value="2">❤❤</option>--%>
                        <%--<option value="3">❤❤❤</option>--%>
                        <%--<option value="4">❤❤❤❤</option>--%>
                        <%--<option value="5">❤❤❤❤❤</option>--%>
                    <%--</select>--%>
                </td>
            </tr>
            <tr>
                <td>客户满意度</td>
                <td colspan="1">
                    <input id="edit_satisfy"
                           style="width: 200px; height: 30px;"
                           class="easyui-combobox" name="cstSatisfy"
                           data-options=" valueField:'id',
                                        textField:'name',
                                        data:[{id:1,name:'❤'},{id:2,name:'❤❤'},{id:3,name:'❤❤❤'},{id:4,name:'❤❤❤❤'},{id:5,name:'❤❤❤❤❤'}],
                                        required:true,
                                        missingMessage:'必填'">
                </td>
            </tr>
            <tr>
                <td>客户信用度</td>
                <td colspan="1">
                    <input id="edit_credit"
                           style="width: 200px; height: 30px;"
                           class="easyui-combobox" name="cstCredit"
                            data-options=" valueField:'id',
                                        textField:'name',
                                        data:[{id:1,name:'❤'},{id:2,name:'❤❤'},{id:3,name:'❤❤❤'},{id:4,name:'❤❤❤❤'},{id:5,name:'❤❤❤❤❤'}],
                                        required:true,
                                        missingMessage:'必填'">
                </td>
            </tr>
        </table>
    </form>
</div>


<!-- 联系人窗口 -->
<div id="linkmanDialog" style="">
    <table id="linkmanList" cellspacing="0" cellpadding="0" ></table>
</div>

<!-- 交往记录窗口 -->
<div id="activityDialog" style="">
    <table id="activityList" cellspacing="0" cellpadding="0" ></table>
</div>

<!-- 交往记录窗口 -->
<div id="orderDialog" style="">
    <table id="orderList" cellspacing="0" cellpadding="0" ></table>
</div>

<!-- 表单处理 -->
<%--<iframe id="photo_target" name="photo_target" onload="uploaded(this)"></iframe>--%>

</body>
</html>

