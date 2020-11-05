package com.demo.designpattern.singleton;

/**
 * @author xql132@zcsmart.com
 * @date 2020/11/5
 * @time 9:49 下午
 * @description 单例模式: 静态内部类方式
 */
public class StaticInnerClassSingleton {

    /**
     * 私有构造方法
     */
    private StaticInnerClassSingleton() {
    }

    /**
     * 静态内部类->jvm加载机制保证了安全性
     */
    static class StaticPerson {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    /**
     * 提供给外部使用的获取单例的方法
     * @return
     */
    public static StaticInnerClassSingleton getInstance() {
        return StaticPerson.staticInnerClassSingleton;
    }
}
