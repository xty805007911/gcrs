package com.ctsi.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName : CookieUtils
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-07 18:16
 */
public class CookieUtils {

    public static void setCookie(HttpServletResponse response,String key,String value) {
        Cookie cookie = new Cookie(key,value);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request,String key) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || key == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(key)) {
                    retValue = cookieList[i].getValue();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }
}
