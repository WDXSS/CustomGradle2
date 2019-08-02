#### 1. Android Dynamic Delivery

- ##### Android App Bundles

  - [16 个使用 App Bundle 发布应用和游戏的理由](https://mp.weixin.qq.com/s/BWg8M4t0KgFkdbG9gmT4Xg)
  - [**android-dynamic-features**](https://github.com/googlesamples/android-dynamic-features)
  

Android app bundles 的使用

- **Dynamic Delivery**

  - [About Dynamic Delivery](https://developer.android.google.cn/studio/projects/dynamic-delivery)

#### 2.App links

#### 3.Now on Top

#### 4. compileSDKVersion 和 targetSdkVersion

#### 5.permissionsDispatcher 框架的使用

#### 6. Android 的新特性

##### 				6.1 DataSaver

##### 				6.2 多窗口模式

##### 		6.3toolbar

##### 		6.4 drawerLayout 实现侧滑效果

#####    6.5 AppBarLayout

#### 7.DesignSupportLibrary 常用控件

##### 			7.1 snackbar

 		snackebar 是一种轻量级的弹出框

##### 			7.2 TextInputLayout

##### 	7.3 FloatingActionButton

> ```xml
> app:backgroundTint 设置背景颜色
> app：elevation 设置正常状态下的阴影大小
> app：pressedTranslationZ 用来设置点时阴影的大小
> ```

##### 	7.4 TabLlayout

##### 	7.5 NavigationView 实现侧滑菜单的界面

- DarwerLayout 作为顶级layout

##### 7.6 CoordinatorLayout

###### 7.6.1 CoordinatorLayout 实现Toolbar隐藏效果

 - 实现隐藏的主要属性

 - coordinatorLayout + floatingActionButton + snackbar 效果

   当点击floatingActionButton弹出snackbar时，位了给snackbar留出显示空间，浮动的floatingActionButton会向上移动，这是因为配合CoordinatorLayout，floatingActionButton有一个默认的Behavior来检测Snackbar的添加

###### 7.6.2 CoordinatorLayout 结合CollapsingToolbarLayout 实现Toolbar折叠效果

###### 7.6.3 自定义Behavior

#### 8 .View体系

> checkedTextView
>
> QuickContactBadge

##### 8.1 scrollby 和scrollto

```java
//入参使用负数的原因：参考物是手机屏幕，入参为正数，屏幕移动X，Y轴的正方向移动，view看到效果和想要的效果是相反的，所以要使用负值，才能达到想要的效果
scrollBy(-offsetX,-offsetY)
```

