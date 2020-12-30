package com.ctsi.rpc;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;

/**
 * @Description:
 * @Author: Tianyu Xiao
 * @CreateDate: 2020/12/25  22:03
 */
public class BaiduRpc {

    //根据ip查询地址详情
    public static HashMap getAddressByIp(String ip) {
        Document document = null;
        try {
            document = Jsoup
                    .connect("http://api.map.baidu.com/location/ip?ak=DvwyNimy8CXKEZG9Lxeo6G7zxBjxnsz8&ip="+ip+"&coor=bd09ll")
                    .ignoreContentType(true)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonStr = document.body().text().toString();
        //System.out.println(jsonStr);
        return JSON.parseObject(jsonStr,HashMap.class);
    }

    //根据经纬度查询地址详情
    public static HashMap getAddressByXY(Float x, Float y) {
        Document document = null;
        String location = y+","+x;
        try {
            document = Jsoup
                    .connect("http://api.map.baidu.com/reverse_geocoding/v3/?ak=DvwyNimy8CXKEZG9Lxeo6G7zxBjxnsz8&output=json&coordtype=wgs84ll&location="+location)
                    .ignoreContentType(true)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonStr = document.body().text().toString();
        //System.out.println(jsonStr);
        return JSON.parseObject(jsonStr,HashMap.class);
    }

}
