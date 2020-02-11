package jvm.classloader;

public class MyTest17 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 myTest16 = new MyTest16("loader1");
        Class<?> aClass = myTest16.loadClass("JVM.classLoading.MySample");
        System.out.println(aClass.hashCode());
        //注释该行代码，那么不会实例化MySample，MySample构造方法不会被调用
        //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat Class
        Object o = aClass.newInstance();

    }
}
