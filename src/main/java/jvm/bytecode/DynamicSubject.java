package jvm.bytecode;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
    public Object realSubject;
    public DynamicSubject(Object sub){
        this.realSubject = sub;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before"+method);
        method.invoke(this.realSubject,args);
        System.out.println("after"+method);
        return null;
    }
}
