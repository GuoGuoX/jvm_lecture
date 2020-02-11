package jvm.classloader;

/**
 * 连接（准备阶段）和初始化阶段
 */
public class MyTest6 {


    public static void main(String[] args) {
        Parent6 parent6 = Parent6.getParent();
        System.out.println(parent6.int1);
        System.out.println(parent6.int2);
    }
}

class Parent6{

    public static Parent6 parent = new Parent6();
    private Parent6(){
        int1++;
        int2++;//准备阶段此时int2加加后值为1；
    }

    public static int int1 ;
    public static int int2 = 22;//初始化阶段将0赋值给int2，覆盖掉了准备阶段的1,因为静态代码是按顺序执行的，如果此行在前值为1

    public static Parent6 getParent(){
        return parent;
    }
}
