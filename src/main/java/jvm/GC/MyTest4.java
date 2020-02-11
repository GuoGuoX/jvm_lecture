package jvm.GC;

/**
 * 以下JVM启动参数运行在JDK1.8环境下
 -verbose:gc
 -Xmx200M
 -Xmn50M
 -XX:TargetSurvivorRatio=6
 -XX:+PrintTenuringDistribution
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps
 -XX:+UseConcMarkSweepGC
 -XX:+UseParNewGC
 -XX:MaxTenuringThreshold=3 指定survivor区晋升老年代年龄最大值。该值会依据survivor的内存使用率动态变更，但不会超过指定的最大值


 输出结果

 1111111111111111111111
 2020-02-10T16:53:59.753+0800: [GC (Allocation Failure) 2020-02-10T16:53:59.753+0800: [ParNew
 Desired survivor size 314572 bytes, new threshold 1 (max 3)
 - age   1:    1697736 bytes,    1697736 total
 : 40346K->1682K(46080K), 0.0023349 secs] 40346K->1682K(50176K), 0.0024014 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 2222222222222
 2020-02-10T16:54:00.758+0800: [GC (Allocation Failure) 2020-02-10T16:54:00.758+0800: [ParNew
 Desired survivor size 314572 bytes, new threshold 3 (max 3)
 - age   1:         56 bytes,         56 total
 : 42421K->58K(46080K), 0.0032689 secs] 42421K->1718K(50176K), 0.0032988 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 33333333333333
 2020-02-10T16:54:01.764+0800: [GC (Allocation Failure) 2020-02-10T16:54:01.764+0800: [ParNew
 Desired survivor size 314572 bytes, new threshold 3 (max 3)
 - age   1:         56 bytes,         56 total
 - age   2:         56 bytes,        112 total
 : 40793K->43K(46080K), 0.0004684 secs] 42453K->1704K(50176K), 0.0005021 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 444444444444444
 555555555555
 2020-02-10T16:54:03.767+0800: [GC (Allocation Failure) 2020-02-10T16:54:03.767+0800: [ParNew
 Desired survivor size 314572 bytes, new threshold 1 (max 3)
 - age   1:    2097304 bytes,    2097304 total
 - age   2:         56 bytes,    2097360 total
 - age   3:         56 bytes,    2097416 total
 : 40780K->2066K(46080K), 0.0054769 secs] 42440K->3726K(50176K), 0.0055456 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 66666666666666
 Heap
 par new generation   total 46080K, used 33383K [0x05a00000, 0x08c00000, 0x08c00000)
 eden space 40960K,  76% used [0x05a00000, 0x078954c8, 0x08200000)
 from space 5120K,  40% used [0x08200000, 0x08404968, 0x08700000)
 to   space 5120K,   0% used [0x08700000, 0x08700000, 0x08c00000)
 concurrent mark-sweep generation total 4096K, used 1660K [0x08c00000, 0x09000000, 0x12200000)
 Metaspace       used 220K, capacity 2280K, committed 2368K, reserved 4480K
 */
public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        byte[] bytes1 = new byte[512*1024];
        byte[] bytes2 = new byte[512*1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("1111111111111111111111");
        myGC();
        Thread.sleep(1000);
        System.out.println("2222222222222");
        myGC();
        Thread.sleep(1000);
        System.out.println("33333333333333");
        myGC();
        Thread.sleep(1000);
        System.out.println("444444444444444");
        byte[] bytes3 = new byte[1024*1024];
        byte[] bytes4 = new byte[1024*1024];
        myGC();
        Thread.sleep(1000);
        System.out.println("555555555555");
        myGC();
        Thread.sleep(1000);
        System.out.println("66666666666666");
    }

    private static void myGC() {
        for (int i=0;i<30;i++){
            byte[] bytes = new byte[1024*1024];
        }
    }
}
