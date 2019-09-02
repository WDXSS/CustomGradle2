package com.example.jetpack;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface DevDescribe {
    String value() default "";
}
