package jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理:分析其源码及字节码
 */
public class Mytest9 {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubject subject = new RealSubject();
        InvocationHandler dynamicSubject = new DynamicSubject(subject);
        Class<?> aClass = subject.getClass();
        Subject o = (Subject)Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicSubject);
        o.request();
        /**
         * 执行结果:
         * beforepublic abstract void jvm.bytecode.Subject.request()
         * realSubject request方法执行
         * afterpublic abstract void jvm.bytecode.Subject.request()
         */
    }
    /**
     * import java.lang.reflect.InvocationHandler;
     * import java.lang.reflect.Method;
     *
     * public class jvm.bytecode.DynamicSubject implements InvocationHandler {
     *     public Object realSubject;
     *     public jvm.bytecode.DynamicSubject(Object sub){
     *         this.realSubject = sub;
     *     }
     *     @Override
     *     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     *         System.out.println("before"+method);
     *         method.invoke(this.realSubject,args);
     *         System.out.println("after"+method);
     *         return null;
     *     }
     * }
     * public class jvm.bytecode.Mytest9 {
     *     public static void main(String[] args) {
     *         System.getProperties().put("","true");
     *         jvm.bytecode.RealSubject subject = new jvm.bytecode.RealSubject();
     *         InvocationHandler dynamicSubject = new jvm.bytecode.DynamicSubject(subject);
     *         Class<?> aClass = subject.getClass();
     *         jvm.bytecode.Subject o = (jvm.bytecode.Subject)Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicSubject);
     *         o.request();
     *         /**
     *          * 执行结果:
     *          * beforepublic abstract void jvm.bytecode.Subject.request()
     *          * realSubject request方法执行
     *          * afterpublic abstract void jvm.bytecode.Subject.request()
     *          */
}
