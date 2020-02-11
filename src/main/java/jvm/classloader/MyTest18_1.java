package jvm.classloader;

/**
 * 将任意类的.class文件放到BootstrapClassLoader负责加载的范围内
 */
public class MyTest18_1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 myTest16 = new MyTest16("loader1");

        myTest16.setPath("G:\\test-code\\JVM-test\\");
        Class<?> aClass = myTest16.loadClass("JVM.classLoading.MySample");
        aClass.newInstance();


    }
}
