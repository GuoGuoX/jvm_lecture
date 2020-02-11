package jvm.classloader;

/**
 * 加载器双亲委托加载机制
 * BootstrapCalssLoader:启动类加载器
 * Extension ClassLoader:扩展类加载器
 * App ClassLoader：系统类加载器
 *
 * 双亲委托加载机制：首先自下而上检查类是否已加载，自顶向下尝试加载类
 */
public class MyTest7 {
    public static void main(String[] args) {
        System.out.println(C.class.getClassLoader());
        //jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
    }
}

class C{

}
