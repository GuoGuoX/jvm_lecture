package jvm.classloader;
/**
    对于数组实例来说，其类型是由JVM运行期动态生成的

    助记符：
    anewarray:表示创建一个引用类型的（如类，接口，数组）数组，将其引用值压入栈顶
    newarray:表示创建一个指定的原始类型（如int，float，char）数组，并将其引用值压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        Parent4[] parent = new Parent4[1];
        System.out.println(parent.getClass());//class [LJVM.classLoading.Parent4;
        System.out.println(parent.getClass().getSuperclass());//class java.lang.Object
        Parent4[][] parent1 = new Parent4[1][1];
        System.out.println(parent1.getClass()); //class [[LJVM.classLoading.Parent4;
        System.out.println(parent1.getClass().getSuperclass());//class java.lang.Object


    }
}

class Parent4{
    static{
        System.out.println("parent静态代码块执行");
    }
}
