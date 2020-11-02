package com.example.lib_java.java_8;

/**
 * @FunctionalInterface 注解要求接口有且只有一个抽象方法，JDK中有许多类用到该注解，比如 Runnable，它只有一个 Run 方法。
 */
//@FunctionalInterface
public interface IConvert<F,T> {
	T convert(F form);
}
