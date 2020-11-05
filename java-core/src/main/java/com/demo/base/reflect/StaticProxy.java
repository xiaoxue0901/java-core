package com.demo.base.reflect;

/**
 * @author:autumn
 * @date: 2019/11/21 11:44 PM
 * @description:
 */
// 1. 定义代理类和被代理都需要实现的接口, 被代理类都必须是此接口的实例对象
interface ClothFactory {
    void makeCloth();
}

// 2. 被代理类实现接口
class NikeClothFactory implements ClothFactory {
    @Override
    public void makeCloth() {
        System.out.println("NIke make cloth");
    }
}

// 3. 代理类实现接口: 通过调用被代理类的接口去实现接口
class ProxyClothFactory implements ClothFactory {
    // 1. 引用待实现接口
    ClothFactory factory;

    // 2. 构造方法中必须传入被代理对象的引用
    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    // 3. 调用被代理类的方法
    @Override
    public void makeCloth() {
        System.out.println("代理类的实现内容, 下面开始调用被代理类的makeCloth");
        factory.makeCloth();
    }
}


public class StaticProxy {

    public static void main(String[] args) {
        // 创建被代理类对象, 但是此对象不执行实现方法
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        // 创建代理类对象, 将被代理对象包装起来
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        // 代理对象决定什么时候调用被代理对象及其方法
        proxyClothFactory.makeCloth();
    }
}
