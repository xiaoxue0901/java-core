package com.demo.base;

import com.demo.base.bean.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author:autumn
 * @date: 2019/11/21 10:53 PM
 * @description:
 */
public class TestReflectTest {

    @Test
    public void test() throws Exception {
        Class clazz = Person.class;
        // 1. 创建Class类对应运行时类的对象
        Person p = (Person) clazz.newInstance();
        System.out.println();

        // 2. 通过反射调用运行时类的指定属性
        // 获取public属性
        Field field = clazz.getField("name");
        field.set(p, "测试");
        System.out.println(p);

        // 获取private属性
        Field priField = clazz.getDeclaredField("age");
        priField.setAccessible(true);
        priField.set(p, 13);
        System.out.println(p);

        // 3. 通过反射调用运行时类的指定方法
        Method m = clazz.getMethod("show");
        m.invoke(p);
        System.out.println();

        Method display = clazz.getDeclaredMethod("display", String.class);
        display.setAccessible(true);
        Object b = display.invoke(p, "heallo");
        System.out.println(b);

    }

    // 调用运行时类的指定属性
    @Test
    public void test2() throws Exception {
        // 1. 获取Class
        Class clazz = Person.class;
        // 2. 获取指定属性: 获取到声明为public的属性
        Field field = clazz.getField("name");
        // 3. 创建运行时类的对象
        Person person = (Person) clazz.newInstance();
        // 4. 将运行时类的对象赋值
        field.set(person, "测试二");
        System.out.println(person);

        // 获取到所有声明的属性
        Field field1 = clazz.getDeclaredField("age");
        // 设置权限
        field1.setAccessible(true);
        field1.set(person, 32);
        System.out.println(person);
    }

    // 调用指定的构造器
    @Test
    public void test4() throws Exception {
        Class clazz = Person.class;
       Constructor constructor =  clazz.getDeclaredConstructor(String.class, int.class);
       constructor.setAccessible(true);
       Person p = (Person)constructor.newInstance("构造器", 5);
        System.out.println(p);
    }
}