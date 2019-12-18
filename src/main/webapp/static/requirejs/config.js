var contextPath = window.location.protocol+"//"+window.location.host+"/";
var _common = "static/";
require.config({
    baseUrl: contextPath + _common,
    paths: {
        jquery: 'easyui/jquery.min',
        easyui: 'easyui/jquery.easyui.min',
        icheck: 'h-ui/lib/icheck/jquery.icheck.min',
        hui: 'h-ui/js/H-ui',
        md5: 'js/utils/md5',
        stringUtils: 'js/utils/StringUtils',
        domReady: 'requirejs/domReady',
        huilogin: 'h-ui/js/H-ui',
        outlook2: 'easyui/outlook2'
    },
    map:{
        "*":{
            "css": "requirejs/css.min"
        }
    },
    shim: {
        hui: {deps: ["jquery","icheck",
                        "css!" + contextPath + _common + "h-ui/css/H-ui.min.css",
                // "css!" + contextPath + _common + "h-ui/css/H-ui.login.css",
                "css!" + contextPath + _common + "h-ui/lib/icheck/icheck.css",
                "css!" + contextPath + _common + "h-ui/lib/Hui-iconfont/1.0.1/iconfont.css"]} ,
        huilogin: {deps: ["jquery","icheck",
                "css!" + contextPath + _common + "h-ui/css/H-ui.min.css",
                "css!" + contextPath + _common + "h-ui/css/H-ui.login.css",
                "css!" + contextPath + _common + "h-ui/lib/icheck/icheck.css",
                "css!" + contextPath + _common + "h-ui/lib/Hui-iconfont/1.0.1/iconfont.cs"
            ]} ,
        icheck: {deps: ["jquery",
                        "css!" + contextPath + _common + "h-ui/lib/icheck/icheck.css",
                        "css!" + contextPath + _common + "h-ui/lib/Hui-iconfont/1.0.1/iconfont.css"]} ,
        easyui: {deps: ["jquery",
                        "css!" + contextPath + _common + "easyui/themes/icon.css",
                        "css!" + contextPath + _common + "easyui/themes/default/easyui.css"]} ,
        oulock2: {}
        // login: {deps: ["jquery", "css!" + contextPath + _common + "css/login.css"]}
    }
});