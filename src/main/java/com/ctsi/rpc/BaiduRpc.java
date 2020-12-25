package com.ctsi.rpc;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Description:
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/25  22:03
 */
public class BaiduRpc {

    public static HashMap getAddressByIp(String ip) {
        Document document = null;
        try {
            document = Jsoup
                    .connect("http://api.map.baidu.com/location/ip?ak=DvwyNimy8CXKEZG9Lxeo6G7zxBjxnsz8&amp;ip="+ip+"amp;coor=bd09ll")
                    .ignoreContentType(true)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonStr = document.body().text().toString();
        System.out.println(jsonStr);
        Object parse = JSON.parse(jsonStr);

        return (HashMap) parse;
    }

}
