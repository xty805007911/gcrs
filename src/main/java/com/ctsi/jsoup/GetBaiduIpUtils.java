package com.ctsi.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/25  21:06
 */
public class GetBaiduIpUtils {
    public static String getClientIp() throws IOException {
        Document document = Jsoup.connect("https://www.baidu.com/s?ie=UTF-8&wd=ip").get();
        System.out.println();
        String content = document.body().getElementsByClass("c-gap-right").text();

        String regEx="((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        String result = "36.16.64.0";//默认杭州的地址

        while (m.find()) {
            result = m.group();
        }
        System.out.println(result);
        return result;
    }
}
