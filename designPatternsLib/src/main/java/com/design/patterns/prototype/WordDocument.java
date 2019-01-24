package com.design.patterns.prototype;

import java.util.ArrayList;


/**
 * 原型模式-->游戏规则：
 * 1.保护原文档不被修改 <br/>
 * 2.新建文档副本在副本上进行修改 <br/>
 * 3.文档含有文字和图片<br/>
 */
public class WordDocument implements Cloneable{
    private String strTitle;
    private ArrayList<String> imgList = new ArrayList<>();
     void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    void addImagePath(String imgPath){
       imgList.add(imgPath);
   }

    void printlnInfo(){
        System.out.println("title ="+ strTitle);
       for (String imgPath : imgList) {
           System.out.println("图片地址 ="+imgPath);
       }
       System.out.println("---------------------------");
   }

    @SuppressWarnings("unchecked")
    @Override
    protected WordDocument clone() {
        WordDocument doc = null;
        try {
            //浅拷贝：
           // doc = (WordDocument) super.clone();
            //深拷贝
            doc = (WordDocument) super.clone();
            doc.imgList = (ArrayList<String>) (this.imgList).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
