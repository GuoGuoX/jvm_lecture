package jvm.classloader;


/**
 *
 */
public class MyTest11{
    public static void main(String[] args) {

        System.out.println(Child11.b);
        Child11.doSomeThing();
        /**
         Parent11静态方法执行
         Child11静态代码块执行
         4
         doSomeThing方法执行
         */
    }
}

class Parent11{
    static int a = 3;
    static{
        System.out.println("Parent11静态方法执行");
    }
    static void doSomeThing(){
        System.out.println("doSomeThing方法执行");
    }
}

class Child11 extends Parent11{
    static int b = 4;
    static{
        System.out.println("Child11静态代码块执行");
    }
}

