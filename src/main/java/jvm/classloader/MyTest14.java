package jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args)throws IOException {
        System.out.println();

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> enumeration = contextClassLoader.getResources("JVM/classLoading/MyTest13.class");

        while(enumeration.hasMoreElements()){
            URL url = enumeration.nextElement();
            System.out.println(url);
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            /**
             * file:/D:/IDEA/javaProject/out/production/javaProject/JVM/classLoading/MyTest13.class
             * /D:/IDEA/javaProject/out/production/javaProject/JVM/classLoading/MyTest13.class
             * /D:/IDEA/javaProject/out/production/javaProject/JVM/classLoading/MyTest13.class
             */
        }
    }
}
