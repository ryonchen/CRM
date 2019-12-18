//加载页面函数
$(function () {
    //消息推送窗口
    $.messager.show({
        width: 360,
        height: 50,
        title: '推送',
        msg: '消息内容',
        showSpeed: 1500,
        timeout: 0,
        showType: 'slide'
    });
});
//设置系统功能菜单栏
var _menus = {
    "menus": [
        {
            "menuid": "1", "icon": "", "menuname": "学生信息管理",
            "menus": [
                {
                    "menuid": "21",
                    "menuname": "学生列表",
                    "icon": "icon-student",
                    "url": "../student/goStudentListView"
                }
            ]
        },
<c:if test="${userType == 1 || userType == 3}">
    {
        "menuid": "2", "icon": "", "menuname": "教师信息管理",
        "menus": [
            {
                "menuid": "22",
                "menuname": "教师列表",
                "icon": "icon-teacher",
                "url": "../teacher/goTeacherListView"
            }
        ]
    },
    </c:if>
<%-- 通过JSTL设置用户查看权限:  仅管理员可以查看年级,班级,管理员列表信息 --%>
<c:if test="${userType == 1}">
    {
        "menuid": "3", "icon": "", "menuname": "班级信息管理",
        "menus": [
            {
                "menuid": "23",
                "menuname": "班级列表",
                "icon": "icon-class",
                "url": "../clazz/goClazzListView"
            }
        ]
    },
    {
        "menuid": "4", "icon": "", "menuname": "年级信息管理",
        "menus": [
            {
                "menuid": "24",
                "menuname": "年级列表",
                "icon": "icon-grade",
                "url": "../grade/goGradeListView"
            }
        ]
    },
    {
        "menuid": "5", "icon": "", "menuname": "系统用户管理",
        "menus": [
            {
                "menuid": "25",
                "menuname": "管理员列表",
                "icon": "icon-admin",
                "url": "../admin/goAdminListView"
            }
        ]
    },
    </c:if>
{
    "menuid": "6", "icon": "", "menuname": "个人信息管理",
    "menus": [
    {
        "menuid": "26",
        "menuname": "修改密码",
        "icon": "icon-settings",
        "url": "../common/goSettingView"
    }
]
}
]
};