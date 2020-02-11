package jvm.classloader;

/**
 * 数组的Class对象都是由java虚拟机运行期动态创建的
 *
 * int，short，char
 * 原始类型数组是没有类加载器的，通过getClass.getClassLoader(),返回的是null
 *
 * String由根类加载器加载，而根类加载器表示为null
 *
 * 引用类型的数组实例的getClass.getClassLoader().返回的是该引用类型
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] stringArray = new String[2];//String类型是由根加载器加载的,根加载器是null表示的
        System.out.println(stringArray.getClass().getClassLoader());
        int[] ints = new int[2];//原始类型的的Class对象,是由jvm运行期动态创建的,它没有类加载器,也是返回null
        System.out.println(ints.getClass().getClassLoader());
        char[] chars = new char[2];
        System.out.println(chars.getClass().getClassLoader());
        MyTest15[] myTest15 = new MyTest15[2];//引用类型(自定义类型)是由自定义类加载器或者应用类加载器加载的
                                                //AppClassLoader
        System.out.println(myTest15.getClass().getClassLoader());
        /**
         * null
         * null
         * null
         * jdk.internal.loader.ClassLoaders$AppClassLoader@726f3b58
         */
    }
}
