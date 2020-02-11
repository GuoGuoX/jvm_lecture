package jvm.classloader;

public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("jdk.boot.class.path.append"));//BootstrapClassLoader
        System.out.println(System.getProperty("java.ext.dirs"));//ExtensionClassLoader
        System.out.println(System.getProperty("java.class.path"));//AppClassLoader
        /**
         * 输出结果
         * null
         * null
         * D:\IDEA\javaProject\out\production\javaProject
         */
    }
}
