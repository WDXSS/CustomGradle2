package com.design.patterns.prototype;

import android.support.v4.widget.TextViewCompat;

/**
 * 原型模式<br/>
 * 1.Project.clone(); 实现接口 Cloneable ，不会调用构造方法<br/>
 * 2.new 对象 <br/>
 *
 *
 * 原型模式分为：浅拷贝和深拷贝；<br/>
 * 推荐深拷贝：1.对象的引用也进行克隆 ，2序列化<br/>
 *八种基础类型和String引用类型可以直接clone
 *
 * 原型模式模式实战：保护性拷贝，只读不修改 <br/>
 *
 */
public class PrototypeMain {

    public static void main(String[] args) {
        WordDocument wordDocument = new WordDocument();
        wordDocument.setStrTitle("原型文档！！！");
        wordDocument.addImagePath("图片地址001");
        wordDocument.addImagePath("图片地址002");
        wordDocument.addImagePath("图片地址003");
        wordDocument.printlnInfo();

        WordDocument wordClone = wordDocument.clone();
        wordClone.setStrTitle("副本文档！！！");
        wordClone.addImagePath("副本文档----图片地址001");
        wordClone.addImagePath("副本文档----图片地址002");
        wordClone.addImagePath("副本文档----图片地址003");
        wordClone.printlnInfo();

        //打印原文档
        wordDocument.printlnInfo();  
    }


}
