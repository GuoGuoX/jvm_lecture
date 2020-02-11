package jvm.classloader;

/**
 * 类加载的层级关系
 */
public class MyTest13 {
    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        while (systemClassLoader!=null){
            systemClassLoader = systemClassLoader.getParent();
            System.out.println(systemClassLoader);
        }
        /**输出结果：
         * jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
         * jdk.internal.loader.ClassLoaders$PlatformClassLoader@e73f9ac
         * null
         *
         * 在一些虚拟机实现制，BootstrapClassLoader使用null来表示，即获取根类加载器会返回一个null
         */
    }
}
