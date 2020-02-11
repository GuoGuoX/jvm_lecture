package jvm.GC;

/**
 * 垃圾回收日志深度解读
 * -verbose:GC  //打印冗余的GC信息
 * -Xms20M  //堆初始化容量大小为20M
 * -Xmx20M  //堆最大容量大小为20M
 * -Xmn10M  //堆新生代大小为20M
 * -Xlog:gc*    //打印GC详细信息
 * -XX:SurvivorRatio=8  //分配新生代Eden和Survivor空间比例为8:1:1
 */

/**
 * PretenureSizeThreshold 设置对象超过多大时直接在老年代分配
 */
public class MyTest2 {
    public static void main(String[] args) {
        int bytes = 1024 * 1024;
        byte[] bytes1 = new byte[4 * bytes];
        try {
            //Thread.currentThread().sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
