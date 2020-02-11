package jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器加载
 *AppClassLoader（应用程序类加载器）：
 *      负责加载用户路径（ClassPath）指定的类库，如果应用程序没有自定义类加载器，则默认使用此加载器。
 * *
 *      * 要点:
 *      *      双亲委托机制
 *      *      命名空间
 *
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;//自定义类加载器的名称
    private String path;//.class文件所在路径

    public void setPath(String path) {
        this.path = path;
    }
    /**
     * 为什么必须添加此构造方法
     * 因为在ClassLoader的initSystemClassLoader方法中有以下代码
     * Constructor<?> ctor = Class.forName(cn, false, builtinLoader)
     *                           .getDeclaredConstructor(ClassLoader.class);
     * @param classLoader
     */
    public MyTest16(ClassLoader classLoader){
        super(classLoader);
    }


    public MyTest16(String classLoadername){
        super();//默认此自定义加载器的父类加载器为AppClassLaoder
        this.classLoaderName = classLoadername;
    }
    public MyTest16(ClassLoader classLoader,String classLoadername){
        super(classLoader);//显示指定此自定义加载器的父类加载器
        this.classLoaderName = classLoadername;
    }

    /**
     * protected Class<?> findClass(String name)
     * 这个方法会在检查完父类加载器后被loadClass(String name)方法调用
        在findClass(String name)方法中必须显示指定调用this.defineClass(name,bytes,0,bytes.length);

     this.defineClass(name,bytes,0,bytes.length);此方法被native修饰
     * @param name
     * @return
     */
    @Override
    protected Class<?> findClass(String name) {
        System.out.println("findClass invoke#############");
        byte[] bytes = new byte[0];
        try {
            bytes = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> aClass = this.defineClass(name,bytes,0,bytes.length);
        return aClass;
    }

    private byte[] loadClassData(String className) throws IOException {
        System.out.println(className);
        className = className.replaceAll("\\.","/");
        int ch = 0;

        FileInputStream fileInputStream = new FileInputStream(new File(path+className+".class"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//该输出流自动维护了一个可变长度的字节数组
        while (-1 != (ch = fileInputStream.read())){
            outputStream.write(ch);
        }
        byte[] bytes = outputStream.toByteArray();

        return bytes;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 myTest16 = new MyTest16("myTest16ClassLoader");
        System.out.println(myTest16.getClass().getClassLoader());
        myTest16.setPath("G:\\test-code\\JVM-test\\");//当class文件不在用户classpath路径下,那么会用当前的类加载器来加载
        //不再通过AppClassLoader来进行加载,因为加载路径已经不在父类的加载范围内
        Class<?> aClass = myTest16.loadClass("JVM.classLoading.MyTest1");
        Object o = aClass.newInstance();
        int i = aClass.hashCode();
        //类的卸载
        System.gc();
        System.out.println("newInstance="+o);
        System.out.println("hashcode="+i);



        /**输出结果:
         findClass invoke#############
         JVM.classLoading.MyTest1
         newInstance=JVM.classLoading.MyTest1@1a407d53
         hashcode=932607259
         */
    }
   /* public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println();
        MyTest16 myTest16 = new MyTest16("myTest16ClassLoader");

        ClassLoader classLoader = myTest16.getClass().getClassLoader();
        System.out.println("classLoader="+classLoader);//classLoader=jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
        Class<?> aClass = classLoader.loadClass("JVM.classLoading.MyTest1");
        Object o = aClass.newInstance();
        int i = aClass.hashCode();
        System.out.println("newInstance="+o);
        System.out.println("hashcode="+i);
        *//**
         * newInstance=JVM.classLoading.MyTest1@7c30a502
         * hashcode=93122545
         *//*
    }*/

    public static void test1(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        System.out.println("classLoader="+classLoader);//classLoader=jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
        Class<?> aClass = classLoader.loadClass("JVM.classLoading.MyTest1");
        Object o = aClass.newInstance();
        int i = aClass.hashCode();
        System.out.println("newInstance="+o);
        System.out.println("hashcode="+i);
        /**
         * newInstance=JVM.classLoading.MyTest1@7c30a502
         * hashcode=93122545
         */
    }
}
