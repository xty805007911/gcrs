package com.ctsi.controller;

import com.ctsi.entity.TbUser;
import com.ctsi.service.TbUserService;
import com.ctsi.util.PhoneFormatCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : CommonController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-26 13:24
 */
@Controller
public class CommonController {
    @Autowired
    private TbUserService userService;
    @Autowired
    private UserRestController userRestController;

    //验证ca证书
    @GetMapping("/.well-known/pki-validation/fileauth.txt")
    @ResponseBody
    public String testCa() {
        return "2020122900000016gq1tn8urxcje2xcexf5yc54hhy7zbjpi60r8v7ccbgujo4c8";
    }


    //用户登陆
    @RequestMapping("/login")
    public String login(String mobile, String password, HttpServletRequest request) {
        //根据手机号和密码查询
        TbUser dbUser = userService.getUserByMobileAndPassword(mobile, password);

        //检测用户是否存在
        if(dbUser == null) {
            request.setAttribute("msg","用户名或密码错误");
            return "login";
        }
        //检测当前账户是否可用
        if(dbUser.getEnabled() == null || dbUser.getEnabled() == 0) {
            request.setAttribute("msg","当前用户不可用，请联系管理员");
            return "login";
        }

        //将用户信息设置session
        request.getSession().setAttribute("sessionUser",dbUser);

        //跳转首页
        return "redirect:/";
    }

    //用户退出登陆
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("sessionUser");
        //跳转首页
        return "redirect:/";
    }

    //用户注册
    @RequestMapping("/register")
    public String register(TbUser formUser,String selectSender,HttpServletRequest request) {

        //手机号校验
        if(formUser.getMobile() == null || formUser.getMobile().trim().equals("")) {
            request.setAttribute("msg","手机号不能为空");
            return "register";
        }
        if(!PhoneFormatCheckUtils.isChinaPhoneLegal(formUser.getMobile())) {
            request.setAttribute("msg","手机号不合法");
            return "register";
        }
        if(userService.isMobileExist(formUser.getMobile())) {
            request.setAttribute("msg","手机号已存在");
            return "register";
        }

        //密码校验
        if(formUser.getPassword() == null || formUser.getPassword().trim().equals("")) {
            request.setAttribute("msg","密码不能为空");
            return "register";
        }

        //保存用户到数据库
        userService.save(formUser,selectSender) ;

        //到登陆页面
        return "login";

    }

    //查询用户信息
    @GetMapping("/user/info")
    public String getUserInfo(HttpServletRequest request) {
        TbUser user = userService.getUserById(userRestController.getCurrentUser(request).getId());
        request.setAttribute("user",user);
        request.setAttribute("avatarList",userService.avatarListAll());
        return "/user-info";
    }

    //修改用户信息
    @PostMapping("/user/info")
    public String updateUserInfo(HttpServletRequest request,TbUser formUser) {
        userService.updateUserInfo(formUser);
        TbUser user = userService.getUserById(userRestController.getCurrentUser(request).getId());
        request.getSession().setAttribute("sessionUser",user);
        return "redirect:/user/info";
    }

}
