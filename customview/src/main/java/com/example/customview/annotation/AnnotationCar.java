package com.example.customview.annotation;

/**
 * @author zhouchao
 * @date 2020/8/4
 */
//自定义的类

import java.lang.reflect.Field;

/**
 * Created by WANG on 17/11/21.
 */

public class AnnotationCar {
    private static AnnotationCar annotationCar;
    public static AnnotationCar instance(){
        synchronized (AnnotationCar.class){
            if(annotationCar == null){
                annotationCar = new AnnotationCar();
            }
            return annotationCar;
        }
    }

    public void inject(Object o){
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field:declaredFields) {
            //注意 field.getName() 是定义的属性 名称
            if(field.getName().equals("mCat") && field.isAnnotationPresent(MyTag.class)) {
                MyTag annotation = field.getAnnotation(MyTag.class);
                Class<?> type = field.getType();
                if(Cat.class.equals(type)) {
                    try {
                        field.setAccessible(true);
                        field.set(o, new Cat(annotation.name(), annotation.size()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}