package jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.ServiceLoader;

/**
 * 设置元空间最大值为200M,当元空间中产生的元数据大于200M时,抛出异常
 * 如果不设置元空间最大值,
 * 那么元空间会持续自增压缩操作系统内存,直到操作系统中的内存溢出
 */

/**
 * 当设置元空间内存最大值为200M时
 * Exception in thread "main"
 * Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
 */
public class MyTest4 {
    public static void main(String[] args) {
        while (true) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, argsl, proxy) ->
                    proxy.invokeSuper(obj, argsl));
            System.out.println("hello world");
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enhancer.create();
        }
    }
    /*  当设置元空间最大值为10m时:-XX:MetaMetaspaceSize=10m
     *  hello world
        hello world
        hello world
        hello world
        hello world
        Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
            at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:345)
            at net.sf.cglib.proxy.Enhancer.generate(Enhancer.java:492)
            at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:114)
            at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:291)
            at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
            at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:305)
            at jvm.memory.MyTest4.main(MyTest4.java:18)
             */
    public static void main1(String[] args) {
        for (int i = 1; i < 10; i++) {//i是一个乘数
            for (int j = 1; j <= i; j++) {//j是另外一个乘数
                System.out.print(j + "*" + i + "=" + (i * j < 10 ? (" " + i * j) : i * j) + " ");
            }
            System.out.println();
        }}
}
