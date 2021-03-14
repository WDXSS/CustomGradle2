package com.example.customview.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhouchao
 * @date 2020/6/1
 */
public class RegexUtil {
    /**
     * 判断一个字符串是否是数字。
     */
    public static boolean isNumber(String string) {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }


    public static boolean isLegalName(String name) {
        if (name == null)
            return false;
        Pattern pattern = Pattern.compile("[-_,'.A-Za-z& ]{3,260}");
        Matcher matcher = pattern.matcher(name);
        matcher.group();
        return pattern.matcher(name).matches();

    }

}
