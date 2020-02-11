package jvm.classloader;

public class MySample {
    public MySample(){
        System.out.println("MySample构造方法执行"+this.getClass().getClassLoader());
        new MyCat();
    }
}
