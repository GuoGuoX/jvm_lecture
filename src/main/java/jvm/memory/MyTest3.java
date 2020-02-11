package jvm.memory;

/**
 * 测试jconsole工具和jvisualvm工具的死锁检测功能
 */
public class MyTest3 {
    public static void main(String[] args) {
        String lock1 = "11";
        String lock2 = "22";
        Thread thread1 = new Thread(new Thread1(lock1,lock2));
        Thread thread2 = new Thread(new Thread2(lock1,lock2));
        thread1.start();
        thread2.start();
    }

}
class Thread1 implements  Runnable{
    private Object obj;
    private Object obj2;
    Thread1(Object o,Object o2){
        this.obj = o;
        this.obj2 = o2;

    }
    @Override
    public void run() {
        synchronized (obj){
            System.out.println("进入Thread1类的第一层同步代码块"+obj);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println("进入Thread1类的第二层同步代码块"+obj2);

            }
        }
    }
}
class Thread2 implements  Runnable{
    private Object obj;
    private Object obj2;
    Thread2(Object o,Object o2){
        this.obj = o;
        this.obj2 = o2;
    }
    @Override
    public void run() {
        synchronized (obj2){
            System.out.println("**进入Thread2类的第一层同步代码块"+obj2);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                System.out.println("**进入Thread2类的第二层同步代码块"+obj);

            }
        }
    }
}
