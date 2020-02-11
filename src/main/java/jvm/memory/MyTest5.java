package jvm.memory;

/*
    jcmd(JDK1.7开始增加的命令)
    1,jcmd pid VM.flags:查看JVM的启动参数
    2,jcmd pid help:查看指定java程序的可执行命令
    3,jcmd pid help JFR.dump:查看具体命令的选项
    4,jcmd pid PerfCounter:查看JVM性能相关的参数
    5,jcmd pid VM.uptime:查看JVM启动时长
    6,jcmd pid GC.class_histogram:查看系统中类的统计信息
    7,jcmd pid Thrad.pring:查看线程堆栈的相关信息
    8,jcmd pid GC.help.dump_fileName:导出help.dump文件，导出的文件可以通过jvisualVM查看
    9,jcmd pid System_properties:查看JVM属性
    10,jcmd pid VM.version:查看JVM版本信息
 *
 */
public class MyTest5 {
    public static void main(String[] args) {
        for (;;){
            System.out.println("----");
        }
    }
}
