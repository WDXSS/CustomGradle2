package com.example.lib_java.regex;

import java.util.regex.Pattern;

class RegexGroup {
    //分组 ()
    public static void main(String[] args) {

        RegexGroup regexGroup = new RegexGroup();
        regexGroup.group();
    }

    private void group() {

        String regexRule = "ab";
        boolean pattern = Pattern.compile("ab+").matcher("ab").find();
        System.out.println(pattern);//true
        boolean pattern2 = Pattern.compile("^ab+$").matcher("abb").find();
        System.out.println(pattern2);//true
        boolean pattern3 = Pattern.compile("^ab+$").matcher("abab").find();
        System.out.println(pattern3);//false

        boolean pattern44 = Pattern.compile("^(ab)+$").matcher("ab").find();
        System.out.println(pattern44);//true
        boolean pattern45 = Pattern.compile("^(ab)+$").matcher("abb").find();
        System.out.println(pattern45);//false
        boolean pattern46 = Pattern.compile("^(ab)+$").matcher("abab").find();
        System.out.println(pattern46);//true
        boolean pattern47 = Pattern.compile("(ab)+").matcher("abb").find();
        System.out.println(pattern47);//true  去掉 ^ 和 $


    }

}
