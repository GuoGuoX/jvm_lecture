package jvm.classloader;

/**
 * 在一个类初始化的时候,必须在初始化完毕其父类之后
 */
public class MyTest1 {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("JVM.classLoading.Child1");//仅仅是加载并没有实例化
        /**
         结果：
         parent1类静态代码块执行----
         child1类静态代码块执行----
        */
        /**
         * System.out.println(Child1.str1);
         * 输出结果:
         *  parent类静态代码块执行----
         *  hello
         */

        /*
         * System.out.println(Child1.str1);
         * 输出结果:
            parent类静态代码块执行----
            child类静态代码块执行----
            world
         */
       // System.out.println(Child1.str1);
    }
}

class Parent1{
    public static String str1 = "hello";
    public Parent1(){
        System.out.println("Parent1初始化方法执行");
    }
    static {
        System.out.println("parent1类静态代码块执行----");
    }

}

class Child1 extends Parent1{
    public static String str2 = "world";
    public Child1(){
        System.out.println("Child1初始化方法执行");
    }
    static {
        System.out.println("child1类静态代码块执行----");
    }
    }

