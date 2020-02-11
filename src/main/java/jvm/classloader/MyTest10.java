package jvm.classloader;


/**
 *
 */
public class MyTest10{
    static {
        System.out.println("MyTest9静态方法执行");
    }
    public static void main(String[] args) {

        Parent10 parent10;
        System.out.println("----------");
        parent10 = new Parent10();
        System.out.println("----------");
        System.out.println(parent10.a);

        System.out.println("----------");
        System.out.println(Child10.b);
        /**
         * MyTest9静态方法执行
         * ----------
         * Parent9静态方法执行
         * ----------
         * 3
         * ----------
         * Child9静态代码块执行
         * 4
         */
    }
}

class Parent10{
    static int a = 3;
    static{
        System.out.println("Parent9静态方法执行");
    }
}

class Child10 extends Parent10{
    static int b = 4;
    static{
        System.out.println("Child9静态代码块执行");
    }
}

