package com.example.customview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouchao
 * @date 2019/11/7
 */
public class ErrorMsgUtil {
    public static Map<String, String> errorMap = new HashMap();

    //
    private static final String KEY_CCF1100001 = "CCF1100001";
    private static final String KEY_CCF1100002 = "CCF1100002";

    private static final String KEY_CCF2200001 = "CCF2200001";
    private static final String KEY_CCF2200002 = "CCF2200002";

    private static final String KEY_CCF4400002 = "CCF4400002";
    private static final String KEY_CCF4400003 = "CCF4400003";
    private static final String KEY_CCF4400004 = "CCF4400004";
    private static final String KEY_CCF4400005 = "CCF4400005";
    private static final String KEY_CCF4400006 = "CCF4400006";
    private static final String KEY_CCF4400007 = "CCF4400007";
    private static final String KEY_CCF4400008 = "CCF4400008";
    private static final String KEY_CCF4400009 = "CCF4400009";

    private static final String KEY_CCF9900001 = "CCF9900001";
    private static final String KEY_CCF9900002 = "CCF9900002";
    private static final String KEY_CCF9900003 = "CCF9900003";
    private static final String KEY_CCF9900004 = "CCF9900004";

    private static final String KEY_BCC1100001 = "BCC1100001";
    private static final String Key_BCC2200001 = "BCC2200001";
    private static final String Key_BCC3300001 = "BCC3300001";
    private static final String Key_BCC4400001 = "BCC4400001";
    private static final String Key_BCC5500001 = "BCC5500001";

    //--------------------------------------------------------
    private static final String VALUE_CCF1100001 = "参数非法";
    private static final String VALUE_CCF1100002 = "参数为空";

    private static final String VALUE_CCF2200001 = "RPC异常";
    private static final String VALUE_CCF2200002 = "卡中心RPC异常";

    private static final String VALUE_CCF4400002 = "风控拦截";
    private static final String VALUE_CCF4400003 = "渠道系统调用异常";
    private static final String VALUE_CCF4400004 = "会员信息异常";
    private static final String VALUE_CCF4400005 = "网关注册异常";
    private static final String VALUE_CCF4400006 = "解绑卡密校验失败";
    private static final String VALUE_CCF4400007 = "绑信用卡扣款失败";
    private static final String VALUE_CCF4400008 = "银行审核未通过";
    private static final String VALUE_CCF4400009 = "卡中心服务端执行失败";

    private static final String VALUE_CCF9900001 = "系统异常";
    private static final String VALUE_CCF9900002 = "解绑时被风控拦截";
    private static final String VALUE_CCF9900003 = "解绑时系统异常";
    private static final String VALUE_CCF9900004 = "预存异常";

    private static final String VALUE_BCC1100001 = "系统错误";
    private static final String VALUE_BCC2200001 = "参数错误";
    private static final String VALUE_BCC3300001 = "网络错误";
    private static final String VALUE_BCC4400001 = "请求数据不存在";
    private static final String VALUE_BCC5500001 = "数据已存在";


    static{
        errorMap.put(KEY_CCF1100001, VALUE_CCF1100001);
        errorMap.put(KEY_CCF1100002, VALUE_CCF1100002);

        errorMap.put(KEY_CCF2200001, VALUE_CCF2200001);
        errorMap.put(KEY_CCF2200002, VALUE_CCF2200002);

        errorMap.put(KEY_CCF4400002, VALUE_CCF4400002);
        errorMap.put(KEY_CCF4400003, VALUE_CCF4400003);
        errorMap.put(KEY_CCF4400004, VALUE_CCF4400004);
        errorMap.put(KEY_CCF4400005, VALUE_CCF4400005);
        errorMap.put(KEY_CCF4400006, VALUE_CCF4400006);
        errorMap.put(KEY_CCF4400007, VALUE_CCF4400007);
        errorMap.put(KEY_CCF4400008, VALUE_CCF4400008);
        errorMap.put(KEY_CCF4400009, VALUE_CCF4400009);

        errorMap.put(KEY_CCF9900001, VALUE_CCF9900001);
        errorMap.put(KEY_CCF9900002, VALUE_CCF9900002);
        errorMap.put(KEY_CCF9900003, VALUE_CCF9900003);
        errorMap.put(KEY_CCF9900004, VALUE_CCF9900004);

        errorMap.put(KEY_BCC1100001, VALUE_BCC1100001);
        errorMap.put(Key_BCC2200001, VALUE_BCC2200001);
        errorMap.put(Key_BCC3300001, VALUE_BCC3300001);
        errorMap.put(Key_BCC4400001, VALUE_BCC4400001);
        errorMap.put(Key_BCC5500001, VALUE_BCC5500001);
    }


}
