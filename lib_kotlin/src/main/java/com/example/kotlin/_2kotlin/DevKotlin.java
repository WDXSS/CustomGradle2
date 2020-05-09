package com.example.kotlin._2kotlin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DevKotlin {
    String value() default "";
}
