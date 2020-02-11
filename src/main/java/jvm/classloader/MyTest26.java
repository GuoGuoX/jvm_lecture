package jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 《本节讲解线程上下文类加载器源码及执行流程》
 * 运用线程上下文类加载器普遍的编码方式
 *  try{
 *     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 *      Thread.currentThread().setContextClassLoader(targetCcl);
 *      myMethod();
 *  }catch(){}
 *  finally{
 *      Thread.currentThread.setContextClassLoader(classLoader);
 *  }
 *
 *  myMethod里面调用了Thread.currentThread().getContextClassLoader();获取当前线程上下文类加载器做某些事情
 *  如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器来加载（该依赖类之前没被加载过）
 *
 *  contextClassLoader的作用就是为了破坏java的双亲委托模型
 *
 *  当高层提供了统一的接口让低层去实现，同时又在高层加载（或实例化）低层的类时，
 *  就必须通过线程上下文类加载器来帮助高层的ClassLoader找到并加载该类
 */
public class MyTest26 {
    public static void main(String[] args) {
        //ServiceLoader执行流程
        /**
         * ServiceLoader.load(Driver.class);//该方法内部使用了上下文类加载器
         * public static <S> ServiceLoader<S> load(Class<S> service) {
         *         ClassLoader cl = Thread.currentThread().getContextClassLoader();
         *         return new ServiceLoader<>(Reflection.getCallerClass(), service, cl);
         *     }
         * 通过META-INF/services目录下新增指定名称的文件名,获取配置文件内容,
         * 通过配置文件内容来反射创建指定服务接口的实现类.
         *
         * 常见的比如加载mysql驱动(mysql-connector-java-5.1.6.jar)
         * META-INF/services/java.sql.Driver
         * java.sql.Driver该文件中的内容为:com.mysql.jdbc.Driver
         *
         */
        ServiceLoader serviceLoader = ServiceLoader.load(Driver.class);
        Iterator iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("object:"+next);
            System.out.println("Class:"+next.getClass());
            System.out.println("classLoader:"+next.getClass().getClassLoader());
        }
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
    /**
     * 输出结果
     * Class:class com.mysql.jdbc.Driver
     * classLoader:jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
     * jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
     */
}

