package com.example.customview.book.custom._9canvas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class SaveFlagMatrixActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_book_9_canvas_flag_matrix);
        //通过两个例子，理解 canvas.save(Canvas.MATRIX_SAVE_FLAG)
        // 总结：
//       1. Canvas.MATRIX_SAVE_FLAG 标识只会保存位置矩阵，在恢复时也只会恢复画布的位置，
//           除此之外的任何信息（比如 画布大小）都不会恢复；save()和saveLayer()函数相同;
//       2. saveLayer()函数在使用用Canvas.MATRIX_SAVE_FLAG 标识时需要与 Canvas.HAS_ALPHA_LAYER_SAVE_FLAG
//           标识一起使用，否则新建的画布所在区域原来的图像将被清空
    }
}
