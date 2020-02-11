package jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**

 */
public class MyTest20 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        System.out.println();
        MyTest16 myTest1 = new MyTest16("loader1");
        MyTest16 myTest2 = new MyTest16("loader2");
        myTest1.setPath("G:\\test-code\\JVM-test\\");
        myTest2.setPath("G:\\test-code\\JVM-test\\");
        Class<?> aClass1 = myTest1.loadClass("JVM.classLoading.MyPerson");
        Class<?> aClass2 = myTest2.loadClass("JVM.classLoading.MyPerson");
        boolean b = aClass1 == aClass2;
        //System.out.println(b);//未删除classpath下的MySample.class 结果为true
        System.out.println(b);//删除classpath下的MySample.class 结果为false
        ClassLoader parent = ClassLoader.getSystemClassLoader();
        System.out.println(parent);
        Object o1 = aClass1.newInstance();
        Object o2 = aClass2.newInstance();
        System.out.println(o1==o2);
        Method setPerson = aClass1.getMethod("setMyPerson", Object.class);
        setPerson.invoke(o1,o2);

        /**
         * 场景一：删除classp下的MyPerson.class文件
         * 输出结果,提示类型转换异常，
         * 原因：加载MyPerson的是两个自定义类加载器，而两个没有继承关系的自定义类加载器的命名空间是独立的
         *      当其中一个自定义类加载器调用另一个自定义类加载器加载的类的时候就会报错
         * findClass invoke#############
         * JVM.classLoading.MyPerson
         * findClass invoke#############
         * JVM.classLoading.MyPerson
         * false
         * MyPerson构造方法执行JVM.classLoading.MyTest16@96532d6
         * MyPerson构造方法执行JVM.classLoading.MyTest16@67b64c45
         * Exception in thread "main" java.lang.reflect.InvocationTargetException
         * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
         * 	at JVM.classLoading.MyTest20.main(MyTest20.java:26)
         * Caused by: java.lang.ClassCastException: JVM.classLoading.MyPerson cannot be cast to JVM.classLoading.MyPerson
         * 	at JVM.classLoading.MyPerson.setMyPerson(MyPerson.java:7)
         * 	... 5 more
         */
    }

}

