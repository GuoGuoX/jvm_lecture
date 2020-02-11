package jvm.bytecode;

/**
 * 栈帧（stack frame）
 * 栈帧是一种可以帮助虚拟机执行方法调用与方法执行的数据结构
 * 栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息，方法的返回地址以及操作数栈等信息。
 *
 * 符号引用
 * 直接引用
 *
 * 有些符号引用是在类加载阶段或是第一次使用时就会转换为直接引用
 * 这种转换叫做静态解析；另一种符号引用是在每次运行期转换为直接引用，这种转换叫动态链接，这体现为java的多态性。
 *
 */
public class MyTest4 {
  /*
    invokevirtual字节码助记符
    jvm.bytecode.Animal animal = new jvm.bytecode.Cat();
    animal.sleep();
    animal = new Dog();
    animal.sleep();*/
}
