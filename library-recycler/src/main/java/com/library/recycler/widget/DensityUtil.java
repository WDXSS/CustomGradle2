package com.library.recycler.widget;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.StyleableRes;
import androidx.core.content.ContextCompat;

/**
 *
 */
public class DensityUtil {
    public static int getDimension(Context context, TypedArray typedArray, @StyleableRes int resId, int defaultValue) {
        int value = typedArray.getResourceId(resId, 0);
        if (value == 0) {
            return typedArray.getDimensionPixelSize(resId, defaultValue);
        } else {
            return context.getResources().getDimensionPixelOffset(value);
        }
    }

    public  static int getColor(Context context, TypedArray typedArray, @StyleableRes int resId, int defaultValue) {
        int value = typedArray.getResourceId(resId, 0);
        int color;
        if (value == 0) {
            color = typedArray.getColor(resId, defaultValue);
        } else {
            color = ContextCompat.getColor(context, value);
        }
        return color == 0 ? defaultValue : color;
    }
}
