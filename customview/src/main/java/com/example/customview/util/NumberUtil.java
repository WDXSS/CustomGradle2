package com.example.customview.util;

import android.util.Log;

import org.jetbrains.annotations.TestOnly;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author zhouchao
 * @date 2020/6/16
 */
public class NumberUtil {
	private static final String TAG = "NumberUtil";

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

	public static void generateNum5() {
		Random random = new Random();
		//生成5位的随机数
		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
		double dou = random.nextDouble() * 90000 + 10000;
		Log.d(TAG, "startBookMain() random.nextDouble() = [" + dou + "]");
		Log.d(TAG, "startBookMain() random.nextDouble() = [" + (99999 - 10000 + 1) + "]");
		Log.d(TAG, "startBookMain() rannum = [" + rannum + "]");
		Log.d(TAG, "startBookMain() Math.random()*100 = [" + Math.random() * 100 + "]");

		for (int i = 0; i < 100; i++) {
			Log.d(TAG, "startBookMain() random.nextDouble() *100 = [" + random.nextDouble() * 100000 + "]");
		}
	}

	public static long generateUnpredictableNumber() {
		// 整形取值范围 ： -2^31 —— 2^31 -1, 即-2147483648——2147483647
		// 返回 允许的 最大值 2^32 - 1 = 4294967296 - 1
		int size = 100;
		long[] num = new long[size + 1];
		Random random = new Random();
		for (int i = 1; i < size + 1; i++) {
			num[i] = (long) random.nextInt() + (long) (1L << 31);
//            num[i] = (long) random.nextInt();
//            System.out.println(num[i]);
			if (num[i] >= ((1L << 32) - 2)) {
				System.out.println("最大值" + ((1L << 32) - 1));
				System.out.println(num[i]);
			}
		}
//        将1解释为int,将其移位31位使其成为最大的负int,然后将其转换为long(仍为负数).你要1L << 31
		System.out.println("end " + (1L << 32));
		return (long) random.nextInt() + (long) (1L << 31);
	}


	/**
	 *  四舍五入
	 */

	public static String decimalScale() {
		float value = 3.1500f;
		BigDecimal bigD = new BigDecimal(value);

//		bigD.setScale(1);//表示保留一位小数，默认用四舍五入方式
		Log.d(TAG, "decimalScale: 原始数 = " + bigD.floatValue());

//		bigD.setScale(1, BigDecimal.ROUND_DOWN);//直接删除多余的小数位，如2.35会变成2.3
		Log.d(TAG, "decimalScale: 直接删除多余的小数位，如2.35会变成2.3 = " + bigD.setScale(1, BigDecimal.ROUND_DOWN).floatValue());

//		bigD.setScale(1, BigDecimal.ROUND_UP);//进位处理，2.35变成2.4
		Log.d(TAG, "decimalScale: 进位处理，2.35变成2.4 = " + bigD.setScale(1, BigDecimal.ROUND_UP).floatValue());


//		bigD.setScale(1, BigDecimal.ROUND_HALF_UP);//四舍五入，2.35变成2.4
		Log.d(TAG, "decimalScale:/四舍五入，2.35变成2.4 = " + bigD.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());

//		bigD.setScale(1, BigDecimal.ROUND_HALF_DOWN);//四舍五入，2.35变成2.3，如果是5则向下舍
		Log.d(TAG, "decimalScale: 四舍五入，2.35变成2.3，如果是5则向下舍 = "+ bigD.setScale(1, BigDecimal.ROUND_HALF_DOWN).floatValue());


		Log.d(TAG, "decimalScale: 四舍五入，RoundingMode.HALF_UP  = "+
				bigD.setScale(1, RoundingMode.HALF_UP).toPlainString());

		return bigD.floatValue() + "";
	}
}
