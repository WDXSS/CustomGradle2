package com.example.book._01cammera

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Matrix
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * 第一章 Camera 的基本用法
 */
class CameraMainView : AppCompatImageView {
    lateinit var camera:Camera

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    fun init() {
        camera = Camera()
        camera.save();//保存状态
        camera.restore()//恢复状态

    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //camera 用于Canvas 有两个方法
        // 函数一：camera.getMatrix()
        val  matrix = Matrix()
        camera.save()
        //.....Camera 的各种操作
        camera.getMatrix(matrix)
        camera.restore()

        canvas?.let {
            canvas.save()
            canvas.setMatrix(matrix)
            //canvas 的绘制操作
            canvas.restore()
        }

       // 函数二：通过Camera.applyToCanvas（canvas）
        canvas?.save()
        camera.save()
        //.....Camera 的各种操作
        camera.applyToCanvas(canvas)
        camera.restore()

        //.....canvas 的绘制操作
        canvas?.restore()
        //需要注意，为了防止原来的Canvas改变，需要在调用camera.applyToCanvas（canvas）函数前，使用save函数保存原始的Canvas
    }
}