package jvm.GC;

/**
 * MaxTenuringThresholds
 * JVM启动参数
 *  -verbose:gc 打印GC详细信息
 *  -Xms20M 堆空间初始大小20M
 *  -Xmx20M 堆空间最大空间20M
 *  -Xmn10M 新生代分配10M
 *  -XX:+PrintGCDetails 打印GC详细信息
 *  -XX:PrintCommandLineFlags   打印命令行的所有启动参数
 *  -XX:SurvivorRatio=8    新生代分配规则（Eden占80%，To Survivor占10%，Form Survivor占10%）
 *  -XX:MaxTenuringThresholds   在可以自动调节对象晋升（Promote）到老年代阈值的GC中，设置该阈值的最大值。
 *  -XX:PrintTenuringDistribution
 *
 *
 -XX:MaxTenuringThresholds   在可以自动调节对象晋升（Promote）到老年代阈值的GC中，设置该阈值的最大值。
 *          该参数的默认值是15,CMS中默认值为6,G1中默认值为15(在JVM中,该数值是由4个bit来表示的,所以最大值1111,即15)
 *
 *          经历多次GC的过程中,存活的对象会在From Survivor与To Survivor之间来回存放,
 *          而这里的一个前提是者两个空间由足够的空间来存放这些数据,
 *          在GC算法中,会计算每个对象年龄的大小,如果达到某个年龄后发现总大小已经大于了Survivor空间的50%,
 *          那么这时就需要调整阈值,就不需要再继续等到默认的15后才晋升,因为这样会导致Survivor空间不足,
 *          所以需要调整阈值,让这些存活对象尽快完成晋升
 *          (当某个数据在From Survivor和To Survivor之间来回存放达到一定次数后会晋升到老年区)
 */
public class MyTest3 {
    public static void main(String[] args) throws InterruptedException {
        int i = 1024 * 1024;
        byte[] b1 = new byte[512 * 1024];
        byte[] b2 = new byte[512 * 1024];
        myGC();
        Thread.sleep(1000);
        System.out.println("1111");
        myGC();
        Thread.sleep(1000);
        System.out.println("2222");
        myGC();
        Thread.sleep(1000);
        System.out.println("3333");
        myGC();
        Thread.sleep(1000);
        System.out.println("4444");

    }
    public static void myGC(){
        for (int i = 1;i<40;i++){
            byte[] bytes = new byte[1024 * 1024];
        }
    }
/**
 * 当前java程序JVM启动参数
 -verbose:gc
 -Xmx200M
 -Xmn50M
 -XX:SurvivorRatio=60
 -XX:+PrintTenuringDistribution 打印对象年龄详情
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps
 -XX:+UseConcMarkSweepGC    老年代回收算法
 -XX:+UseParNewGC   年轻代回收算法
 -XX:MaxTenuringThreshold=3 分代算法晋升年龄最大阈值
 * 输出结果
 1111
 2020-01-23T21:33:02.498+0800: [GC (Allocation Failure) 2020-01-23T21:33:02.501+0800: [ParNew
 Desired survivor size 393216 bytes, new threshold 1 (max 3)
 - age   1:     782736 bytes,     782736 total
 : 49608K->767K(50432K), 0.0026166 secs] 49608K->1669K(54528K), 0.0071441 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 2222
 2020-01-23T21:33:03.508+0800: [GC (Allocation Failure) 2020-01-23T21:33:03.508+0800: [ParNew
 Desired survivor size 393216 bytes, new threshold 3 (max 3)
 - age   1:         40 bytes,         40 total
 : 49869K->25K(50432K), 0.0009040 secs] 50771K->1692K(54528K), 0.0009401 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 3333
 2020-01-23T21:33:04.512+0800: [GC (Allocation Failure) 2020-01-23T21:33:04.512+0800: [ParNew
 Desired survivor size 393216 bytes, new threshold 3 (max 3)
 - age   1:         40 bytes,         40 total
 - age   2:         40 bytes,         80 total
 : 49125K->12K(50432K), 0.0006521 secs] 50792K->1679K(54528K), 0.0006956 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 4444
 Heap
 par new generation   total 50432K, used 19386K [0x05800000, 0x08a00000, 0x08a00000)
 eden space 49664K,  39% used [0x05800000, 0x06aeb840, 0x08880000)
 from space 768K,   1% used [0x08940000, 0x08943230, 0x08a00000)
 to   space 768K,   0% used [0x08880000, 0x08880000, 0x08940000)
 concurrent mark-sweep generation total 4096K, used 1667K [0x08a00000, 0x08e00000, 0x12000000)
 Metaspace       used 220K, capacity 2280K, committed 2368K, reserved 4480K
 */
}
