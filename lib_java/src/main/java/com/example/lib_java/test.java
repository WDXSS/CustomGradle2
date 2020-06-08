package com.example.lib_java;

public class test {
    public static void main(String[] args) {
        test test = new test();
        test.test2();
    }
    public void test2(){
        do {
            System.out.println("wwwwwwwwwwwwwwwwwww");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (true);


    }
}
