package com.ctsi.util;

import com.ctsi.config.Constant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : DateUtils
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-11 09:48
 */
public class DateUtils {

    //两个日期相差的天数
    public static Integer dateGapBetween(Date endTime,Date startTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATA_FORMAT_TYPE1);
        Integer result = 0 ;
        try {
            //得到相差的天数 betweenDate
            Long betweenDate = (endTime.getTime() - startTime.getTime())/(60*60*24*1000);
            result = betweenDate.intValue();
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
