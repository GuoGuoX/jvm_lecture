package jvm.classloader;

import java.util.Random;

/**
 *final修饰的并且引用随机类的常量在被调用时，会对常量所在类造成主动调用，进而对该类进行初始化
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.I);
    }
}

class FinalTest{
    //public static final int I = 1;//1
    //public static  int I = 1;//FinalTest静态代码块执行 // 1
    public static final int I = new Random().nextInt(3);//FinalTest静态代码块执行 // 1

    static{
        System.out.println("FinalTest静态代码块执行");
    }
}
