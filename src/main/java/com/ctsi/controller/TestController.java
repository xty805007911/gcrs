package com.ctsi.controller;

import com.ctsi.jsoup.GetBaiduIpUtils;
import com.ctsi.rpc.BaiduRpc;
import com.ctsi.util.IpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ClassName : TestController
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-25 11:38
 */
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(HttpServletRequest request,@RequestParam(required = false) Integer login) {
        request.setAttribute("test","test succ");
        if(login != null && login == 1) {
            HashMap<String,String> map = new HashMap<>();
            map.put("realname","xty111");
            map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            request.getSession().setAttribute("sessionUser",map);
        }
        return "user/user-index.html";
    }

    @GetMapping("/test2")
    @ResponseBody
    public Object test2(HttpServletRequest request,String ip) throws IOException {

        return BaiduRpc.getAddressByIp(ip);
    }

    @GetMapping("/test3")
    @ResponseBody
    public Object test3() throws IOException {


        return "succ";
    }


}
