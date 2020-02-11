package jvm.bytecode;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * this参数
 *this参数会在jvm运行期间自动向每个方法传入this参数。
 * 所以在程序运行期间，在实例方法的局部变量表中，至少会有一个参数this
 */

/**
 * java字节码异常处理方式
 * 1，同一采用异常表方式来对异常进行处理
 * 2，在JDK1.4.2之前，并不是使用异常表的方式对异常进行处理，而是采用特定的指令方式
 * 3，在异常处理存在finally语句块时，现代化的JVM采用的处理方式是将finally语句块拼接到每一个catch块后面
 *  换句话说,程序中存在多个catch语句块，就会在catch块后面重复多个finally语句块的字节码
 */
public class MyTest3 {
    static int a = 1;
    static{
        float f = 100;
        System.out.println("999");
    }

    public static void test(){
        double d = 1.00;
    }
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(new File(""));
            ServerSocket socket = new ServerSocket(99);
            socket.accept();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("finally执行");
    }
        /**
         * getstatic #10 <java/lang/System.out>
         *  35 ldc #11 <finally执行>
         *  37 invokevirtual #12 <java/io/PrintStream.println>
         *  40 goto 102 (+62)
         *  43 astore_1
         *  44 aload_1
         *  45 invokevirtual #14 <java/io/FileNotFoundException.printStackTrace>
         *  48 getstatic #10 <java/lang/System.out>
         *  51 ldc #11 <finally执行>
         *  53 invokevirtual #12 <java/io/PrintStream.println>
         *  56 goto 102 (+46)
         *  59 astore_1
         *  60 aload_1
         *  61 invokevirtual #16 <java/io/IOException.printStackTrace>
         *  64 getstatic #10 <java/lang/System.out>
         *  67 ldc #11 <finally执行>
         *  69 invokevirtual #12 <java/io/PrintStream.println>
         *  72 goto 102 (+30)
         *  75 astore_1
         *  76 aload_1
         *  77 invokevirtual #18 <java/lang/Exception.printStackTrace>
         *  80 getstatic #10 <java/lang/System.out>
         *  83 ldc #11 <finally执行>
         *  85 invokevirtual #12 <java/io/PrintStream.println>
         *  88 goto 102 (+14)
         *  91 astore_3
         *  92 getstatic #10 <java/lang/System.out>
         *  95 ldc #11 <finally执行>
         *  97 invokevirtual #12 <java/io/PrintStream.println>
         * 100 aload_3
         * 101 athrow
         * 102 return
         */
    }}
