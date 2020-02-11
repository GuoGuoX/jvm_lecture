package jvm.classloader;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MyTest27 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //分析以下两行代码的执行流程
       // Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

      //  System.out.println( aClass.getClassLoader());
        DriverManager.getConnection("","","");

        /**
         * 添加参数后:-XX:+TraceClassLoading
         * [0.191s][info   ][class,load] java.sql.Driver source: jrt:/java.sql
         * 以下两行输出证明驱动通过SPI被加载成功
         * [0.191s][info   ][class,load] com.mysql.jdbc.NonRegisteringDriver source: file:/D:/IDEA/javaProject/src/lib/mysql-connector-java-5.1.6.jar
         * [0.192s][info   ][class,load] com.mysql.jdbc.Driver source: file:/D:/IDEA/javaProject/src/lib/mysql-connector-java-5.1.6.jar
         *
         * [0.192s][info   ][class,load] java.lang.NumberFormatException source: jrt:/java.base
         * [0.192s][info   ][class,load] java.sql.Wrapper source: jrt:/java.sql
         * [0.193s][info   ][class,load] java.sql.Connection source: jrt:/java.sql
         * [0.193s][info   ][class,load] java.lang.reflect.InvocationHandler source: jrt:/java.base
         */
    }
}
