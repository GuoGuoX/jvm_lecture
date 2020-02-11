package jvm.classloader;


/**
 *
 */
public class MyTest9 {
    static {
        System.out.println("MyTest9静态方法执行");
    }
    public static void main(String[] args) {
        System.out.println(Child9.a);
    }
}

class Parent9{
    static int a = 3;
    static{
        System.out.println("Parent9");
    }
}

class Child9 extends Parent9{
    static int b = 4;
    static{
        System.out.println("Child9静态代码块执行");
    }
}

