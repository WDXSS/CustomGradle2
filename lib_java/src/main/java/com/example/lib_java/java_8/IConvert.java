package com.example.lib_java.java_8;
@FunctionalInterface
public interface IConvert<F,T> {
	T convert(F form);
}
