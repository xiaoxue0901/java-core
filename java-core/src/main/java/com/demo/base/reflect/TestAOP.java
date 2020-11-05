package com.demo.base.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:autumn
 * @date: 2019/11/24 12:43 PM
 * @description:
 */
// 共同接口
interface Human {
    void info();

    void fly();
}

// 被代理类
class SuperMan implements Human {
    @Override
    public void info() {
        System.out.println("我是超人, superman");
    }

    @Override
    public void fly() {
        System.out.println("i believe i can fly");

    }
}

 class HumanUtil {
    public static void method1() {
        System.out.println("===========start");
    }

     public static void method2() {
         System.out.println("===========end");
     }
}
// 动态代理实现的接口
class MyAopInvocationHandler implements InvocationHandler {
    Object object;// 被代理类对象的声明

    public void setObject(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil.method1();
       Object returnVal =  method.invoke(object, args);
       HumanUtil.method2();
        return returnVal;
    }
}

class MyProxy{
    /**
     * 动态创建一个代理类的对象
     * @param object 被代理类对象
     * @return
     */
    public static  Object getProxyInstance(Object object) {
        MyAopInvocationHandler hander = new MyAopInvocationHandler();
        hander.setObject(object);
       return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), hander);
    }

}
public class TestAOP {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 代理类对象
       Object obj = MyProxy.getProxyInstance(superMan);
       Human human = (Human) obj;
       human.info();
        System.out.println();
        human.fly();
    }
}
