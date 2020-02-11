package jvm.memory;

import java.util.ArrayList;

/*
虚拟机栈:Stack Frame 栈帧
程序计数器:(Program Counter)
本地方法栈:主要用于处理本地方法
堆(heap):JVM管理的最大的一块内存,与堆相关的一个重要概念是垃圾处理器.现代几乎所有的垃圾处理器都是采用分代手机算法.
        所以堆空间也基于这点进行了相应的划分:新生代与老年代,Eden空间,Form Survivor空间与To Survivor空间。
方法区（Method Area）：存储元信息。永久代（Permanent Generation）从JDK1.8开始就已经彻底废弃了永久代，使用元空间（MetaSpace)
运行时常量池：方法区的一部分内存
直接内存：Direct Memory,与java NIO密切相关，JVM通过堆上的DirectByteBuffer来操作直接内存

关于JAVA对象创建的过程

new 关键字创建对象的3个步骤

1，在堆内存中开辟内存，创建出对象的实例。
2，为对象的实例成员变量赋初始值。
3，将对象的引用返回。

指针碰撞（前提是堆中的内存通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间）
空闲列表（前提是堆中的内存是被已使用和未被使用的空间交织在一起的，这时候虚拟机就需要通过一个列表来记录那些空间是可以使用的和不可以使用的，接下来找出可以容纳下新创建对象的且未被使用的空间，在此空间存放该对象，同时还要修改列表上的记录）

对象在内存中的布局：

1，对象头
2，实例数据（即在类中声明的各项数据）
3，对其填充（可选）

引用访问对象的方式：
1，
 */
public class MyTest1 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (;;){
            arrayList.add(new MyTest1());
            System.gc();
        }
    }
}
