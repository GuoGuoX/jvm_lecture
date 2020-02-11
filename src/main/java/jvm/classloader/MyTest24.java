package jvm.classloader;

/**
    当前类加载器（current ClassLoader）

 上下文类加载器的由来：弥补双亲委托模型父类加载器无法使用子类加载器命名空间的短板

 每个类都有自己的类加载器(即加载自身的类加载器)来加载其他的类（指所依赖的类），
 如果ClassA引用了ClassB，那么加载了ClassA的类加载器就会去加载ClassB（前提ClassB没有被加载）

 contextClassLoader：线程上下文类加载器
 线程上下文类加载器于JDK1.2开始引入，类Thread中的getCurrentClassLoader()和setCurrentClassLaoder(ClassLoader classLoader)
 分别用来获取和设置线程上下文类加载器

 如果没有通过setCurrentClassLoader(ClassLoader cl)设置父类加载器，线程将继承父线程的上下文类加载器
 java运行时初始线程的上下文类加载器时系统类加载器，那么默认当前线程上下文类加载器为AppClassLoader，
 线程中运行的代码可以通过该类加载器来加载类与资源

 线程上下文类加载器的重要性：
 SPI（Server Provider Interface）
 父类加载器可以使用Thread.currentThread().getContextClassLoader()所指定的类加载器,
 这就改变了父类加载器不能使用子类加载器或者两个没有关联的自定义类加载所加载的类的局限，
 即改变了双亲委托模型

 在双亲委托模型下，类加载是自下而上进行加载类的，即下层类加载器会委托上层类加载来加载类，
 但是对于SPI来说，有些接口是由java核心类库提供的，java核心类库是启动类加载器进行加载的，
 这些接口的实现却来自不同的jar包，这样传统的双亲委托模型就无法满足SPI需求。
 而通过设置当前线程上下文类加载器，可以用设置的线程上下文类加载器来实现加载接口的实现类。




 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());//AppClassLoader
        System.out.println(Thread.class.getClassLoader());//null

    }

}

