package jvm.classloader;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用父接口的时候，引用接口中所定义的常亮时，才会初始化
 *
 * 注意：这里涉及接口和类的字段是否指定为final的区别
 *      接口的属性默认为final，而类中的字段需要手动指定final关键字
 *
 *      而添加了final的属性会放到使用类的常量池中，
 *      所以执行mian方法所在类的class文件时可以将定义常量的类的class文件删除，也能正常运行
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(Child.STRING2);
    }
}

interface Parent{
    public static String STRING1 = "hello";
}

interface Child extends Parent{
    public static String STRING2 = "world";
}
