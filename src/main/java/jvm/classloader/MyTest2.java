package jvm.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上,调用类并没有直接引用到定义常亮的类，因此并不会触发定义常亮的类的初始化
 * 注意：这里指的是常亮存放到了MyTest2的常量池中，之后myTest2与MyParent2就没有任何关系了
 *
 *
 * 助记符：-
 *  ldc:表示将int，float，或者是String类型的常量值从常量池中推送至栈顶
 *  bipush:表示将一个短整型的常量值（-128~127）推送至栈顶
 *  sipush:表示将一个短整型常量值（-32768~32767）推送至栈顶
 *  iconst_1:表示将常量int类型1推送至栈顶（iconst_m1~iconst_5:-1 ~ 5）
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.s);
        /**
         *         System.out.println(MyParent2.s);
         *         输出结果：127
         */
    }
}

class MyParent2{
    public static final short s= 127;

    static{
        System.out.println("myParent2静态方法执行-------");
    }
}
