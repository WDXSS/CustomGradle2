package com.example.customview.annotation;

/**
 * @author zhouchao
 * @date 2020/8/4
 */
public class Cat {
    private String name;
    private int size;

    public Cat(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
