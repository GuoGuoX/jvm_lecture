package jvm.classloader;

/**
    在运行期，一个java类是由该类的完全限定名（binary name）和用于加载类的定义类加载器（defining loader）所共同决定的
    如果同样名字的类是由两个不同的加载器所加载，那么这两个类就是不同的，即便相同路径下的.class文件一样，


 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    /**
        内建于jvm中的类加载器会加载java.lang.ClassLoader以及其他的java平台类
        在jvm启动时，一块特殊的机器码会运行，它会加载扩展类加载器和应用类加载器，
        这块特殊机器码就是启动类加载器

        启动类加载器并不是java类，其由c代码编写，启动类加载器特定于平台的机器指令，它负责开启整个加载过程

        启动类加载器还会加载保证JRE正常运行所需的基本组件，如java.util和java.lang包中的类
     */
        System.out.println("---------------------");

        System.out.println(ClassLoader.class.getClassLoader());//null
        System.out.println("mytest23.classloader="+MyTest23.class.getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
        System.out.println("java.system.class.loader="+System.getProperty("java.system.class.loader"));//null
        /**
         * 负责加载classpath路径下的class文件的默认类加载器是可以修改的
         * 使用java.system.class.loader
         * 在修改默认的AppClassLoader之后
         *
         D:\IDEA\javaProject\out\production\javaProject>java -Djava.system.class.loader=JVM.classLoading.MyTest16 JVM.classLoading.MyTest23
         *
         *  null
         * mytest23.classloader=jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
         * java.system.class.loader=JVM.classLoading.MyTest16
         */

    }

}

