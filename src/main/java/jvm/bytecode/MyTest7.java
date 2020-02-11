package jvm.bytecode;

/**
 * invokevirtual
 *针对于方法调用动态分派的过程,虚拟机会在类方法区建立一个虚方法表的数据结构(virtual method table,vtable)
 * 针对于invokeinterface指令来说,虚拟机会建立一个叫做接口方法表的数据结构(interface method table ,itable)
 *
 */
public class MyTest7 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.test1();

        Animal animal1 = new Cat();
        animal1.test1();
        /*
        jvm.bytecode.Animal animal1 = new jvm.bytecode.Cat();
        animal1.test2();
        * 为什么通过父类引用调用子类的非重写方法会编译报错？
        * invokevirtual #4 <jvm.bytecode.Animal.test1>
        * 从字节码分析父类需要通过invokevirtual指令来查找方法,
        * 在这之前需要先确定父类是否存在此方法,没有则报错,
        * 存在则前往操作数栈获取实际类型,从实际类型中查找是否存在目标方法,
        * 存在执行,不存在依次在实际类型的父类进行查找.
        * */
    }
}
class Animal{
    public void test1(){
        System.out.println("animal test1执行");
    }
}
class Cat extends Animal{
    public void test1(){
        System.out.println("cat test1执行");
    }
    public void test2(){
        System.out.println("cat test2");
    }
}
