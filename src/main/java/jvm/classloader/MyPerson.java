package jvm.classloader;

public class MyPerson {
    private MyPerson myPerson;

    public void setMyPerson(Object obj) {
        this.myPerson = (MyPerson)obj;
    }

    public MyPerson(){
        System.out.println("MyPerson构造方法执行"+this.getClass().getClassLoader());

    }
}
