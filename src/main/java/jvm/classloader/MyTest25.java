package jvm.classloader;


public class MyTest25 implements Runnable{
    private Thread thread;
    public MyTest25(){
        this.thread = new Thread(this);
        this.thread.start();
    }
    public static void main(String[] args) {
        MyTest25 myTest25 = new MyTest25();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.currentThread().getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);

        System.out.println(classLoader.getClass());
        System.out.println(classLoader.getParent().getClass());
        /**
         * 输出
         * class jdk.internal.loader.ClassLoaders$AppClassLoader
         * class jdk.internal.loader.ClassLoaders$PlatformClassLoader
         */
    }
}

