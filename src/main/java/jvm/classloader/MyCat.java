package jvm.classloader;

public class MyCat {
    public MyCat(){
        System.out.println("MyCat构造方法执行"+this.getClass().getClassLoader());
        System.out.println(MySample.class);
    }
}
