package com.example.lib_java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain2 {
    private String scriptStr = "<script>" +
            "window.sysTime=1609675467;" +
            "</script>" +
            "<script>" +
            "body.className += ' browser-edge';" +
            "</script>";

    public static void main(String[] args) {
        // 元字符:点 .
        RegexMain2 regexMain2 = new RegexMain2();
//        regexMain2.pint2();
        //匹配优先量词
//        regexMain2.test();
        //忽略优先量词
//        regexMain2.test2();
//        regexMain2.test3();//获取多条数据
        regexMain2.path();
    }

    // 点的 用法 . 可以匹配任意字符，除了換行符
    private void pint() {
        String str = "3.1 \n" + "4";
        String regexRule = ".*";
        Pattern p = Pattern.compile(regexRule);
        Matcher m = p.matcher(str);
        boolean find = m.find();
        System.out.println("find = " + find);//true
        String result = m.group();
        System.out.println("result = " + result);//3.1
    }

    private void pint2() {
        String str = "3a14";
        String str2 = "sa3.14";
        String regexRule = ".*";
        //有无 ^ 的区别
        String regexRuleRight = "\\d+\\.\\d*$";
//        Pattern p = Pattern.compile(regexRule);
        Pattern p = Pattern.compile(regexRuleRight);
        Matcher m = p.matcher(str);
        Matcher m2 = p.matcher(str2);
        boolean find = m.find();
        boolean find2 = m2.find();
        System.out.println("find = " + find);//regexRuleRight false; regexRule trueregexRule
        System.out.println("find2 = " + find2);//true
        if (find) {
            String result = m.group();
            System.out.println("result = " + result);
        }
        if (find2) {
            String result2 = m2.group();
            System.out.println("result2 = " + result2);//3a14
        }
    }

    private void test() {
        //匹配优先量词
        String str = "12312312 \" quote string 123\"  and another \" ";
        String regexRule = "\".*\"";//滥用 . 号的
        String regexRuleRight = "\"[^\"]*\"";// [^"] 非 “ 的字符
        Pattern pattern = Pattern.compile(regexRuleRight);
        Matcher matcher = pattern.matcher(str);
        boolean find = matcher.find();
        if (find) {
            String group = matcher.group();
            System.out.println("group = " + group);//获取 双引号 中的数据
        }
    }

    private void test2() {
        //把 * 改成 *? 就是使用了忽略优先量词
        //匹配优先量词
        String str = "12312312 \" quote string 123\"  and another \" 8999 \"";
//        String regexRule = "\".*?\"";
        String regexRule = "\".*?\"";
        String regexRuleRight = "\"[^\"]*\"";// [^"] 非 “ 的字符
        Pattern pattern = Pattern.compile(regexRule);
        Matcher matcher = pattern.matcher(str);
//        boolean find = matcher.find();
//        if (find) {
//            String group = matcher.group();
//            System.out.println("group = " + group);//获取 双引号 中的数据
//
//        }
        while (matcher.find()) {
            String group = matcher.group();
//            str = str.replace(group, "");
//            System.out.println(group);
            System.out.println("groupCount = " + matcher.groupCount());
        }
    }

    private void test3() {
        //匹配所有的 script 标签
        String regexStr = "<script>[\\s\\S]*?</script>";
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(scriptStr);
        while (matcher.find()) {
            System.out.println("result = " + matcher.group());
        }
    }


    String path = "C:\\Android\\SDK\\sources\\android-29\\android\\app";

    private void path() {
        String regexPath = "^.*\\\\";//匹配文件路径 以 \ 最后一个
        Pattern pattern = Pattern.compile(regexPath);
        Matcher matcher = pattern.matcher(path);
        while (matcher.find()) {
            System.out.println("path = " + matcher.group());
        }
        fileName();
    }

    private void fileName() {
        int index = 0;
        String regexFileName = "[^\\\\]*$";//匹配文件名： [^\]使用 非  最后 有无$ 还是有区别的
        Pattern patternName = Pattern.compile(regexFileName);
        Matcher matcherName = patternName.matcher(path);


        if(matcherName.find()){
            String group = matcherName.group(0);
            System.out.println("group = " + group);
        }
//        while (matcherName.find()) {
//            System.out.println("index = " + ++index);
//            System.out.println("FileName = " + matcherName.group());
//        }

    }

}
