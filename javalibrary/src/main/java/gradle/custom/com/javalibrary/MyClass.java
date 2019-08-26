package gradle.custom.com.javalibrary;

import java.util.ArrayList;

public class MyClass {
    public static void main(String[] args) {
        Class a = new ArrayList<Integer>().getClass();
        Class b = new ArrayList<String>().getClass();

        System.out.println(a == b);
    }
}
