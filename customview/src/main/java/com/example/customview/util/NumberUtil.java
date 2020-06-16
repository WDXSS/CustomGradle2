package com.example.customview.util;

import android.util.Log;

import java.util.regex.Pattern;

/**
 * @author zhouchao
 * @date 2020/6/16
 */
public class NumberUtil {

    /**
     * 判断一个字符串是否是数字。
     *
     * @param string
     * @return
     */
    public static boolean isNumber(String string) {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }


    public static boolean LuhnCheck(int[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {

            // get digits in reverse order
            int digit = digits[length - i - 1];

            // every 2nd number multiply with 2
            if (i % 2 == 1) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum % 10 == 0;
    }

    public static boolean LuhnCheck(String strDigits) {
        String result = strDigits.replaceAll(" ", "");
        System.out.println("result 去除 空格 = " + result);
        if (!isNumber(result)) {
            return false;
        }

        int[] digits = stringToInt(result);
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            // get digits in reverse order
            int digit = digits[length - i - 1];
            // every 2nd number multiply with 2
            if (i % 2 == 1) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum % 10 == 0;
    }

    private static int[] stringToInt(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));//substring是找出包含起始位置，不包含结束位置，到结束位置的前一位的子串
        }
        System.out.println("输出数组 ：");
        for (int i : arr) {
            //输出数组arr
            Log.d("stringToInt", i + " ");
        }
        return arr;
    }
}
