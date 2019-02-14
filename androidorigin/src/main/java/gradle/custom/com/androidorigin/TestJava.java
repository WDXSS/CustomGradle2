package gradle.custom.com.androidorigin;

import java.util.HashSet;
import java.util.Set;

public class TestJava {

    public static void main(String[] args) {

        TestJava testJava = new TestJava();
        testJava.initTest();
    }
    //set存储不重复元素
    private void initTest(){
        Test test1 = new Test();
        test1.name= "test1";
        Test test2 = new Test();
        test2.name= "test1";
        Test test3 = new Test();
        test3.name= "test3";
        Test test4 = new Test();
        test4.name= "test4";

        Set set = new HashSet();
        System.out.println(set.add(test1));//true
        System.out.println(set.add(test2));//true
        System.out.println(set.add(test3));//true
        System.out.println(set.add(test4));//true
        System.out.println(set.add(test4));//false
        System.out.println(set.add("a"));//true
        System.out.println(set.add("a"));//false
    }

    public class Test{
        public Test() {
        }

        String name ;

    }
}
