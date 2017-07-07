package com.ywgroup.iecloud.bagshare.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/6.
 */
public class StringTestUtil {

    public static boolean isContainChinese(String str) {// 检测是否包含中文
        String regEx = "[\\u4E00-\\u9FA5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

}
