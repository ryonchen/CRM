//DOM加载完成后执行的回调函数
$(function () {
    var table;
    //初始化datagrid
    $('#dataList').datagrid({
        iconCls: 'icon-more',//图标
        border: true,
        collapsible: false,//是否可折叠
        fit: true,//自动大小
        method: "post",
        url: "getTeacherList?t" + new Date().getTime(),
        idField: 'id',
        singleSelect: false,//是否单选
        rownumbers: true,//行号
        pagination: true,//分页控件
        sortName: 'id',
        sortOrder: 'DESC',
        remoteSort: false,
        columns: [[
            {field: 'chk', checkbox: true, width: 50},
            {field: 'id', title: '编号', width: 50, sortable: true},
            {field: 'clazz_name', title: '客户名称', width: 150},
            {field: 'name', title: '概要', width: 150},
            {field: 'tno', title: '联系人', width: 150},
            {field: 'gender', title: '联系电话', width: 50},
            {field: 'email', title: '创建日期', width: 150},
            {field: 'telephone', title: '电话', width: 150},
            {field: 'address', title: '住址', width: 150}
        ]],
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
    });

    //信息修改按钮事件
    $("#edit").click(function () {
        table = $("#editTable");
        var selectRows = $("#dataList").datagrid("getSelections");
        if (selectRows.length !== 1) {
            $.messager.alert("消息提醒", "请单条选择想要修改的数据哟!", "warning");
        } else {
            $("#editDialog").dialog("open");
        }
    });

    //信息删除按钮事件
    $("#delete").click(function () {
        var selectRows = $("#dataList").datagrid("getSelections");//返回所有选中的行,当没有选中的记录时,将返回空数组
        var selectLength = selectRows.length;
        if (selectLength === 0) {
            $.messager.alert("消息提醒", "请选择想要删除的数据哟!", "warning");
        } else {
            var ids = [];
            $(selectRows).each(function (i, row) {
                ids[i] = row.id;//将预删除行的id存储到数组中
            });
            $.messager.confirm("消息提醒", "删除后将无法恢复该教师信息! 确定继续?", function (r) {
                if (r) {
                    $.ajax({
                        type: "post",
                        url: "deleteTeacher?t" + new Date().getTime(),
                        data: {ids: ids},
                        dataType: 'json',
                        success: function (data) {
                            if (data.success) {
                                $.messager.alert("消息提醒", "删除成功啦!", "info");
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

    //设置添加教师信息窗口
    $("#addDialog").dialog({
        title: "添加教师信息窗口",
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
                        $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                    } else {
                        var data = $("#addForm").serialize();//序列化表单信息
                        $.ajax({
                            type: "post",
                            url: "addTeacher?t" + new Date().getTime(),
                            data: data,
                            dataType: 'json',
                            success: function (data) {
                                if (data.success) {
                                    $("#addDialog").dialog("close"); //关闭窗口
                                    $('#dataList').datagrid("reload");//重新刷新页面数据
                                    $.messager.alert("消息提醒", "添加成功啦!", "info");
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
                    $("#add_tno").textbox('setValue', "");
                    $("#add_name").textbox('setValue', "");
                    $("#add_gender").textbox('setValue', "男");
                    $("#add_password").textbox('setValue', "");
                    $("#add_email").textbox('setValue', "");
                    $("#add_telephone").textbox('setValue', "");
                    $("#add_address").textbox('setValue', "");
                }
            }
        ]
    });

    //设置编辑教师信息窗口
    $("#editDialog").dialog({
        title: "修改教师信息窗口",
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
                        $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                    } else {
                        var data = $("#editForm").serialize();//序列化表单信息
                        $.ajax({
                            type: "post",
                            url: "editTeacher?t=" + new Date().getTime(),
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
                                    $.messager.alert("消息提醒", "修改成功啦!", "info");
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
                    $("#edit_name").textbox('setValue', "");
                    $("#edit_gender").textbox('setValue', "男");
                    $("#edit_password").textbox('setValue', "");
                    $("#edit_email").textbox('setValue', "");
                    $("#edit_telephone").textbox('setValue', "");
                    $("#edit_address").textbox('setValue', "");
                    $("#edit_introducation").textbox('setValue', "");
                }
            }
        ],
        //打开窗口前先初始化表单数据(表单回显)
        onBeforeOpen: function () {
            var selectRow = $("#dataList").datagrid("getSelected");
            $("#edit_id").val(selectRow.id);//初始化id值,需根据id更新教师信息
            $("#edit_tno").textbox('setValue', selectRow.tno);
            $("#edit_name").textbox('setValue', selectRow.name);
            $("#edit_gender").textbox('setValue', selectRow.gender);
            $("#edit_password").textbox('setValue', selectRow.password);
            $("#edit_email").textbox('setValue', selectRow.email);
            $("#edit_telephone").textbox('setValue', selectRow.telephone);
            $("#edit_address").textbox('setValue', selectRow.address);
            //通过获取头像路径来显示该教师的头像
            $("#edit-portrait").attr('src', selectRow.portrait_path);
            //初始化头像路径(已优化:在执行SQL语句时通过判断头像路径是否为空,为空则代表用户并未修改头像)
            //$("#edit_portrait-path").val(selectRow.portrait_path);
        }
    });

    //教师与班级名搜索按钮的监听事件(将其值返回给Controller)
    $("#search-btn").click(function () {
        $('#dataList').datagrid('load', {
            teachername: $('#search-teachername').val(),//获取教师名称
            clazzname: $('#search-clazzname').combobox('getValue')//获取年级名称
        });
    });

    //添加信息窗口中上传头像的按钮事件
    $("#add-upload-btn").click(function () {
        if ($("#choose-portrait").filebox("getValue") === '') {
            $.messager.alert("提示", "请选择图片!", "warning");
            return;
        }
        $("#add-uploadForm").submit();//提交表单

    });

    //修改信息窗口中上传头像的按钮事件
    $("#edit-upload-btn").click(function () {
        if ($("#edit-choose-portrait").filebox("getValue") === '') {
            $.messager.alert("提示", "请选择图片!", "warning");
            return;
        }
        $("#edit-uploadForm").submit();

    });

});

//上传头像按钮事件
function uploaded() {
    var data = $(window.frames["photo_target"].document).find("body pre").text();
    data = JSON.parse(data);//将data装换为JSON对象
    if (data.success) {
        $.messager.alert("提示", "图片上传成功!", "info");
        //切换头像
        $("#add-portrait").attr("src", data.portrait_path);
        $("#edit-portrait").attr("src", data.portrait_path);
        //将头像路径存储到教师信息表单中(利用从用户信息中读取头像路径来显示头像)
        $("#add_portrait-path").val(data.portrait_path);
        $("#edit_portrait-path").val(data.portrait_path);
    } else {
        $.messager.alert("提示", data.msg, "warning");
    }
}
