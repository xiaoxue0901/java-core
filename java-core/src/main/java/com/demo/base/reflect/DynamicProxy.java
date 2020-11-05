package com.demo.base.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:autumn
 * @date: 2019/11/22 11:42 PM
 * @description: 动态代理: 代理类是运行时产生的
 */
// 1. 定义代理类和被代理类共同实现的接口
interface Subject {
    String action();
}

// 2. 定义被代理类
class RealSubject implements Subject {
    @Override
    public String action() {
        System.out.println("我是被代理类, 我要在代理类中被调用");
        return "language";
    }
}
// 3. 定义创建实现In接口的对象
class MyInvocationHander implements InvocationHandler{
    // 实现了接口subject的被代理类的引用
    Object subject;

    // 1. 给被代理的对象实例化; 2. 返回一个代理类的对象(根据被代理类对象动态产生代理对象)
    public Object bind(Object subject) {
        this.subject = subject;
        return Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类的业务操作");
        // method是subject的方法action(), 使用反射调用action方法.
        Object returnVal = method.invoke(subject, args);
        return returnVal;
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        // 例一
        // 1. 创建被代理类对象
        RealSubject realSubject = new RealSubject();
        // 2. 创建一个实现了InvocationHandler接口的类的对象
        MyInvocationHander hander = new MyInvocationHander();
        // 3. 调用bind(),动态返回一个实现了Subject接口的代理类的对象
        Subject proxy = (Subject)hander.bind(realSubject);
        // proxy就是代理类的对象
        String result = proxy.action();
        System.out.println(result);

        // 例二
        NikeClothFactory factory = new NikeClothFactory();
       ClothFactory proxyFactory = (ClothFactory)hander.bind(factory);
       proxyFactory.makeCloth();
    }
}
