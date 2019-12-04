package com.cn.crm.controller.common;

import com.cn.crm.bean.*;
import com.cn.crm.dao.SysAuthMapper;
import com.cn.crm.service.SysAuthService;
import com.cn.crm.service.SysRoleAuthService;
import com.cn.crm.service.SysRoleService;
import com.cn.crm.service.SysUserService;
import com.cn.crm.util.CreateVerifiCodeImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: crm
 * @description: 登录页面和接口
 * @author: gkt
 * @create: 2019-12-03 16:57
 */
@Controller
@RequestMapping("/account")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    //注入业务对象
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleAuthService sysRoleAuthService;
    @Autowired
    private SysAuthService sysAuthService;


     /**
      * @Author gkt
      * @Description login页面
      * @Date 2019/12/3 17:38
       * @Param: null
      * @return
      **/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String goLogin() {
        return "common/login";
    }


    /**
     * @Author gkt
     * @Description 获取并显示图片验证码
     * @Date 2019/12/3 17:37
     * @Param: request
     * @Param: response
     * @return void
     **/
    @RequestMapping(value = "/getVerifiCodeImage", method = RequestMethod.GET)
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response) {
        // 验证码图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        // 验证码
        String verifiCode = String.valueOf(CreateVerifiCodeImage.getVerifiCode());
        // 将验证码图片输出到登录页面
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 存储验证码Session
        request.getSession().setAttribute("verifiCode", verifiCode);
    }

    /**
     * @Author gkt
     * @Description 验证登录
     * @Date 2019/12/3 17:38
     * @Param: null
     * @return
     **/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(LoginForm loginForm, HttpServletRequest request) {
        //存储返回给页面的对象数据
        Map<String, Object> resultMap = new HashMap<>();

        try {
            // 校验验证码信息
            String vcode = (String) request.getSession().getAttribute("verifiCode");
            if (StringUtils.isEmpty(vcode)) {
                resultMap.put("success", false);
                resultMap.put("message", "长时间为操作,会话已失效,请刷新页面后重试!");
                return resultMap;
            } else if (!vcode.equalsIgnoreCase(loginForm.getVerifiCode())) {
                resultMap.put("success", false);
                resultMap.put("message", "验证码错误!");
                return resultMap;
            }
            request.getSession().removeAttribute("verifiCode");


            SysUser user = sysUserService.getUser(loginForm.getUserName());
            if("1".equals(user.getIsLocked())){
                resultMap.put("success", false);
                resultMap.put("message", "用户已锁定，请联系管理员解锁");
                return resultMap;
            }
            if("0".equals(user.getIsDeleted()) && loginForm.getPassword().equalsIgnoreCase(user.getUserPassword())){
                HttpSession session = request.getSession();
                UserInfo userInfo = genUserInfo(user);
                session.setAttribute("userInfo", userInfo);
                resultMap.put("success", true);
                afterLogin(user,true);
                return resultMap;
            }else{
                //登录失败
                resultMap.put("success", false);
                resultMap.put("message", "用户名或密码错误!");
                afterLogin(user,false);
            }
        } catch (Exception e) {
            logger.error("登录失败，服务器端发生未知异常，异常={}",e);
            resultMap.put("success", false);
            resultMap.put("message", "登录失败! 服务器端发生异常!");
            return resultMap;
        } finally {

        }

        return resultMap;
    }

      /**
       * @Author: gkt
       * @Description: 生成用户信息、角色、权限对象
       * @Date: 2019/12/5 0:51
        * @Param: null
       * @return
       **/
    private UserInfo genUserInfo(SysUser user){
        UserInfo userInfo = new UserInfo();
        if("1".equals(user.getIsDeleted())){
            return null;
        }
        userInfo.setUserId(user.getUserId());
        userInfo.setUserCode(user.getUserCode());
        userInfo.setRoleName(user.getUserName());
        SysRole role = sysRoleService.getRoleById(user.getUserRoleId());
        Integer roleId = role == null || "1".equals(role.getIsDeleted())?0:role.getRoleId();
        String roleName = role == null || "1".equals(role.getIsDeleted())?"":role.getRoleName();
        userInfo.setRoleId(roleId);
        userInfo.setRoleName(roleName);
        if(!"0".equals(roleId)){
            List<SysRoleAuth> roleAuths = sysRoleAuthService.getAuthListByRoleId(roleId);
            List<UserInfo.Auth> uiAuths = userInfo.getAuths();
            for (SysRoleAuth roleAuth : roleAuths) {
                Integer authId = roleAuth == null || "1".equals(roleAuth.getIsDeleted())?0:roleAuth.getAuthId();
                if("0".equals(authId)){
                    continue;
                }
                SysAuth auth = sysAuthService.getAuth(authId);
                authId = auth == null || "1".equals(auth.getIsDeleted())?0:auth.getAuthId();
                if("0".equals(authId)){
                    continue;
                }
                UserInfo.Auth uiAuth = new UserInfo.Auth();
                uiAuth.setAuthId(authId);
                uiAuth.setAuthName(auth.getAuthName());
                uiAuth.setAuthParentId(auth.getAuthParentId());
                uiAuth.setAuthUrl(auth.getAuthUrl());
                uiAuths.add(uiAuth);
            }
            userInfo.setAuths(uiAuths);
        }

        return userInfo;
    }

     /**
      * @Author: gkt
      * @Description: 登录成功失败后续处理
      * @Date: 2019/12/5 2:47
       * @Param: null
      * @return
      **/
    private void afterLogin(SysUser user, Boolean isSuccess){
        try {
            SysUser sysUser = new SysUser();
            sysUser.setUserId(user.getUserId());
            if (isSuccess) {
                sysUser.setLastLoginTime(new Date());
                sysUser.setFailLoginTimes(0);
            } else {
                sysUser.setFailLoginTimes(user.getFailLoginTimes() + 1);
            }
            sysUserService.updateByPrimaryKeySelective(sysUser);
        } catch(Exception e){
            logger.error("afterLogin发生未知异常，跳过，异常={}",e);
        }
    }


}
