package com.example.book._5view.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

internal class MultiTouchViewJavaK : View {
    //用于判断第二个手指是否存在
    private val hasSecondPoint = false

    //用于记录第二根手指位置
    private val mPointF = PointF(0F, 0F)
    private val mDefaultPaint = Paint()

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mDefaultPaint.color = Color.WHITE
        mDefaultPaint.isAntiAlias = true
        mDefaultPaint.textAlign = Paint.Align.CENTER
        mDefaultPaint.textSize = 30f
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val index = event.actionIndex //多点触摸 第index 个点
        when (event.actionMasked) { // event.getActionMasked() 多点触摸 用event.getActionMasked() 获取事件
            MotionEvent.ACTION_DOWN ->                 //手指1按下时会触发
                Log.d(TAG, "onTouchEvent: 第一根手指按下")
            MotionEvent.ACTION_POINTER_DOWN ->                 //手指 2,3....按下时会触发
                Log.d(TAG, "onTouchEvent: 又一根手指按下")
            MotionEvent.ACTION_POINTER_UP ->                 //非最后一个手指抬起
                Log.d(TAG, "onTouchEvent: 又一个手指抬起")
            MotionEvent.ACTION_UP ->                 //最后一个手指抬起时触发
                Log.d(TAG, "onTouchEvent: 最后一个手指抬起")
        }
        return super.onTouchEvent(event)
    }

    companion object {
        private const val TAG = "MultiTouchViewJava"
    }
}