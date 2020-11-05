package com.demo.designpattern.singleton;

/**
 * @author xql132@zcsmart.com
 * @date 2020/11/5
 * @time 10:00 下午
 * @description 双重检查锁实现单例模式
 */
public class DoubleCheckLockSingleton {
    /**
     * 静态成员变量
     * volatile: 可见性, 保证了singleton的安全性->第二道锁
     */
    private static volatile DoubleCheckLockSingleton singleton;

    /**
     * 私有构造方法
     */
    private DoubleCheckLockSingleton() {
    }

    /**
     * 提供给外部使用获取单例的方法
     * @return
     */
    public static DoubleCheckLockSingleton getInstance() {
        // 第一道锁
        synchronized (DoubleCheckLockSingleton.class) {
            if (null == singleton) {
                singleton = new DoubleCheckLockSingleton();
            }
        }
        return singleton;
    }
}
