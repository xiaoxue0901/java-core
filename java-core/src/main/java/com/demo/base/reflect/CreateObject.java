package com.demo.base.reflect;

import com.demo.base.bean.Person;

import java.lang.reflect.InvocationTargetException;

/**
 * @author:autumn
 * @date: 2019/11/18 10:59 PM
 * @description:
 */
public class CreateObject {

    // 如何获取对象对应的Class
    public void createObject() throws ClassNotFoundException {
        // 方式1:
        Class clazz1 = Person.class;
        System.out.println(clazz1.getName());

        // 方式2:
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2.getName());

        // 方式3:
        String className = "com.demo.base.bean.Person";
        Class clazz3 = Class.forName(className);
        System.out.println(clazz3.getName());

        // 方式4: 类加载器



    }

    private static void getClassInstance() {
        try {
            Class clazz = Class.forName("com.demo.base.bean.Person");
            Object object = clazz.newInstance();
            Person p = (Person) object;
            System.out.println(p);

            // 调用指定的构造器创建运行时类的对象
            java.lang.reflect.Constructor cons =clazz.getConstructor(String.class, int.class);
            cons.setAccessible(true);
            Person p2 =  (Person) cons.newInstance("tome", 23);
            System.out.println(p2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        getClassInstance();
    }
}
