package com.example.jetpack.workmanager;

public class WorkMain {
    //WorkManager 参考
    // https://juejin.im/post/5c4ea0686fb9a049ec6b760f

    //几个概念
    //1.Worker  指定需要执行的任务，可以继承抽象的Worker类，
    //          在实现的方法中编写执行的逻辑

    // 1.2 Constraints 指定对任务运行时间的限制（任务约束）；
    //   使用Constraints.Builder创建Constraints对象 ，
    //   并传递给WorkRequest.Builder

    //2.WorkRequest：执行一项单一任务 是一个抽象的类；
    //           系统默认实现子类
    //              OneTimeWorkRequest
    //              PeriodicWorkRequest（循环执行）
    //   WorkRequest.Builder创建WorkRequest对象；
    //   相应的子类：OneTimeWorkRequest.Builder或PeriodicWorkRequest.Builder

    //3.WorkManager 排队和管理工作请求；将WorkRequest 对象传递WorkManager的任务队列

    //4.WorkStatus 包含有关特定任务的信息；可以使用LiveData保存 WorkStatus对象，监听任务状态；
    //  如LiveData<WorkStatus>


}
