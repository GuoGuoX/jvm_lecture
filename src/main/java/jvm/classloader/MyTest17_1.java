package jvm.classloader;

/**
 * 本节要点：
 *  双亲委托机制
 *  命名空间
 *  子类加载器命名空间包含了父类加载器所加载的类
 *  父类加载器命名空间不包含子类加载器所加载的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 myTest16 = new MyTest16("loader1");
        myTest16.setPath("G:\\test-code\\JVM-test\\");
        //当删除MySample.class和MyCat.class字节码文件，则使用自定义类加载器来进行加载
        Class<?> aClass = myTest16.loadClass("JVM.classLoading.MySample");
        System.out.println(aClass.hashCode());
        //注释该行代码，那么不会实例化MySample，MySample构造方法不会被调用
        //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat Class
        Object o = aClass.newInstance();
        /**
         * 场景一：删除MyCat.class,保留MySample.class
         * 如果只删除classpath下的MyCat.class文件，首先由于类路径下有MySample.class，
         * AppClassLoader会加载成功MySample类，在执行newInstance()时，由于此操作对MySample进行了主动调用，
         * 会调用MySample的无参构造方法，而在MySample无参构造方法中又主动new MyCat(),
         * 这里对MyCat进行了主动调用，那么此时AppClassLoader会尝试加载MyCat类，由于之前已经把MyCat.class文件删除
         * AppClassLoader找不到MyCat.class文件，则会报错抛异常
         */
        /**
         * 场景二：删除MySample.class保留MyCat.class
         *
         * findClass invoke#############
         * JVM.classLoading.MySample
         * 1740000325
         * MySample构造方法执行JVM.classLoading.MyTest16@96532d6
         * MyCat构造方法执行jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
         *
         * 由于在classpath下找不到MySample.class，会启动自定义类加载器进行加载该类，
         * 在执行new Instance()方法，主动调用了MyCat，此时尝试查找并加载MyCat.class
         * 由于双亲委托机制，自定义类加载器委托父类加载器AppClassLoader尝试加载，
         * 由于MyCat.class并没有被删除，那么AppClassLoader会加载成功，
         * 所以最终在MyCat无参构造方法打印的当前对象的类加载器是AppClassLoader
         */

        /**
         * 场景三：删除MySample.class，保留MyCat.class,在MyCat无参构造方法中引用MySample.class
         *
         * findClass invoke#############
         * JVM.classLoading.MySample
         * 1740000325
         * MySample构造方法执行JVM.classLoading.MyTest16@96532d6
         * MyCat构造方法执行jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
         * Exception in thread "main" java.lang.NoClassDefFoundError: JVM/classLoading/MySample
         * 	at JVM.classLoading.MyCat.<init>(MyCat.java:6)
         * 	at JVM.classLoading.MySample.<init>(MySample.java:8)
         * 	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
         * 	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
         * 	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
         * 	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:488)
         * 	at java.base/java.lang.Class.newInstance(Class.java:558)
         * 	at JVM.classLoading.MyTest17_1.main(MyTest17_1.java:19)
         * Caused by: java.lang.ClassNotFoundException: JVM.classLoading.MySample
         * 	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:582)
         * 	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:185)
         * 	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:496)
         * 	... 8 more
         */
    }
}
