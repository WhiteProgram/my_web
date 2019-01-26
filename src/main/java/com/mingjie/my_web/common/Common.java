package com.mingjie.my_web.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    /**
     * @return 获取本地最新时间
     */
    public static String getNowTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
