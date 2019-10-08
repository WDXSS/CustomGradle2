package com.example.jetpack.navigation;

public class NavigationMain {
    // navigation.xml
    //TODO action属性
    //app:popUpTo="@id/match"// 返回到 stack 指定的activity/fragment
    //app:popUpToInclusive="false"// 配合popUpTo 使用
    //false 返回到 stack 指定的activity/fragment ， 默认值false
    //true 指定的fragment/activity 也会被销毁

//如：
    /*<action
        android:id="@+id/action_in_game_to_gameOver"
        app:destination="@id/game_over"
        app:enterAnim="@anim/fade_in"
        app:exitAnim="@anim/fade_out"
        app:popEnterAnim="@anim/slide_in_left"
        app:popExitAnim="@anim/slide_out_right"
        app:popUpTo="@id/match"

        app:popUpToInclusive="false" />*/
}
