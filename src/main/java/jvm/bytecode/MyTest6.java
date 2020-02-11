package jvm.bytecode;

/**
 *方法的动态分派
 * 方法的动态分派涉及到一个重要概念：方法接受者
 * invokevirtual字节码指令的多态查找流程
 * 比较方法重载(@overload)和方法重写(@override)
 * 我们可以得到方法重载时静态的，是编译期行为
 * 方法重写是动态的，是jvm运行期行为。
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit fruit1 = new Apple();
        Fruit fruit2 = new Orange();
        fruit1.test1();
        fruit2.test1();
        fruit1 = new Orange();
        fruit1.test1();
        /**
         * 输出结果：
         * apple
         * orange
         * orange
         */
    }
}
class Fruit{
    public void test1(){
        System.out.println("jvm.bytecode.Fruit");
    }
}
class Apple extends Fruit{
    public void test1(){
        System.out.println("apple");
    }
}
class Orange extends Fruit{
    public void test1(){
        System.out.println("orange");
    }
}
