package com.example.jetpack;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;

@DevDescribe(value = "JetPack 概要说明")
public class JetpackMain {
    /**
     *
     * 官方文档和Demo
     * https://developer.android.google.cn/topic/libraries/architecture/livedata?hl=zh_cn#java
     * Sunflower，这是一个演示应用，演示架构组件的最佳做法
     * https://github.com/android/sunflower
     * Android 架构组件基本示例
     * https://github.com/android/architecture-components-samples/tree/master/BasicSample
     *
     * http://liuwangshu.cn/application/jetpack/1-study-jetpack.html
     *
     * LiveData 的实例
     * https://github.com/yuanweiwork/liveDataDemo
     *
     *
     * 分类：{@link ..\jetpack\src\main\res\drawable\jetpack.png}
     * 1. Architecture（架构组件）
     *   1.1 Lifecycle 用于帮助开发者管理Activity和Fragment 的生命周期，由于Lifecycle是LiveData和ViewModel的基础
     */
private Lifecycle mLifecycle;

//1. 在project  build.gradle 中添加  jcenter()
//    allprojects {
//        repositories {
//            google()
//            jcenter()
//        }
//    }

// ViewModel
// LiveData
//    ViewModelProviders
//    Fragment.setRetainInstance(boolean) 是Fragment中的一个方法。将这个方法设置为true就可以使当前Fragment在Activity重建时存活下来
}
