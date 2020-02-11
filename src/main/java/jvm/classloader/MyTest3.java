package jvm.classloader;

import java.util.UUID;

/**
 * 当一个常亮的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中
 * 这时在程序运行时，会导致主动使用这个常亮所在的类，进而对这个类进行初始化
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(Parent3.uuid);
        /**
         * System.out.println(Parent3.uuid);
         * 执行结果：
         * parent静态方法执行
         * dcca7278-33ea-4c38-8c54-06d32350f459
         */
    }

}

class Parent3{
    public static final String uuid = UUID.randomUUID().toString();
    static {
        System.out.println("parent静态方法执行");
    }
}
