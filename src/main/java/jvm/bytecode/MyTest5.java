package jvm.bytecode;

/**
 * 方法的静态分派
 * jvm.bytecode.Grandpa g1 = new jvm.bytecode.Father();
 * 以上代码，g1的静态类型是Grandpa，
 * 而g1的实际类型（真正指向的类型）是Father。
 *
 * 我们可以得出一个结论：变量的静态类型是不会发生变化的，
 * 而变量的实际类型是可以发生变化的(多态的一种体现)
 * 实际类型是在运行期方可确定。
 */
public class MyTest5 {
    public static void main(String[] args) {
        MyTest5 myTest4 = new MyTest5();
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();
        myTest4.test(g1);
        myTest4.test(g2);
        /**
         * 输出结果：
         * grandpa
         * grandpa
         */
    }

    public void test(Grandpa grandpa ){
        System.out.println("grandpa");
    }
    public void test(Father father ){
        System.out.println("father");
    }
    public void test(Son son ){
        System.out.println("son");
    }
}
class Grandpa{

}
class Father extends Grandpa{

}
class Son extends Father{

}
