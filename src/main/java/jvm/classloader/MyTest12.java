package jvm.classloader;

/**
 * 调用ClassLoader的classLoader方法，并不是对类的主动使用，不会对类进行初始化
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("JVM.classLoading.C12");
        System.out.println(aClass);
        System.out.println("#################");
        Class<?> aClass1 = Class.forName("JVM.classLoading.C12");
        System.out.println(aClass1);
        /**
         * class JVM.classLoading.C12
         * #################
         * C静态代码块执行
         * class JVM.classLoading.C12
         */
    }
}

class C12{
    static{
        System.out.println("C静态代码块执行");
    }
}
