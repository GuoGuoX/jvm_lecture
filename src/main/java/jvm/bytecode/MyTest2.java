package jvm.bytecode;

import java.util.concurrent.SynchronousQueue;

public class MyTest2 {

    private String str = "welcome";
    private  int s = 5;
    public MyTest2(String str){

    }
    public MyTest2(){

    }
    public static Integer i = 10;

    public  void   setS(int s) {

         this.s = s;
    }
    public static int   getS(int s) {
        int a ;
        return a=12;
    }




    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
       // jvm.bytecode.MyTest2 myTest2 = new jvm.bytecode.MyTest2();
        //myTest2.setS(2);
        //i = 23;
    }
}
