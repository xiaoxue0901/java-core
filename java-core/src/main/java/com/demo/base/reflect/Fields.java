package com.demo.base.reflect;

import com.demo.base.bean.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author:autumn
 * @date: 2019/11/18 11:28 PM
 * @description:
 */
public class Fields {

    // 获取对应的运行时类的属性
    public static void getField() {
        Class clazz = Person.class;

        // 1. getFields(): 只能获取运行时类及其父类中声明为public的属性
        Field[] field= clazz.getFields();
        for (int i=0; i< field.length; i++) {
            System.out.println(field[i]);
        }

        // 2.getDeclaredFields: 获取运行时的类本身(不包含父类)所有声明的属性.

        Field[] field1 = clazz.getDeclaredFields();
        for (Field f: field1){
            // 1. 获取每个属性的权限修饰符
           int i = f.getModifiers();
           String modifier = Modifier.toString(i);
            System.out.println(modifier);
            // 2. 获取属性的变量类型
            Class type = f.getType();
            System.out.println(type.getName());
            // 获取属性名
            System.out.println(field[i]);
        }

        // 调用静态方法
        try {
            Method method = clazz.getDeclaredMethod("info");
            method.invoke(Person.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void getMethod() {
        // 获取运行时类的方法
        Class clazz = Person.class;

        //1. getMethods: 获取运行时类及其父类中所有的声明为public的方法.
        Method[] methods = clazz.getMethods();

        for (Method m: methods) {
            System.out.println(m);
        }
        //2. getDeclaredMethods: 获取运行时类本身所有的方法.
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m: methods1) {
            System.out.println(m);

        }
    }

    public void getMethod2() {
        Class clazz = Person.class;
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m:methods1) {
            // 获取方法的所有结构
            // 注解
            Annotation[] annotations = m.getAnnotations();
            System.out.println(annotations);
            // 权限修饰符
            String str = Modifier.toString(m.getModifiers());
            // 返回值类型
            Class clazz2= m.getReturnType();
            System.out.println(clazz2.getName());
            // 形参列表
           Class[] params =  m.getParameterTypes();
           for (Class param: params) {
               System.out.println(param.getName());
           }

            // 异常
            Class[] excps = m.getExceptionTypes();
           for (Class e: excps) {
               System.out.println(e.getName());
           }
        }
    }

    public void getConstruct() {
        Class clazz  = Person.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
    }

    public static void getInterface() {
        Class clazz = Person.class;
       Class[] interfaces =  clazz.getInterfaces();
       for (Class cla: interfaces) {
           System.out.println(cla);
           ParameterizedType superclass = (ParameterizedType) cla.getGenericSuperclass();
           System.out.println(superclass);
       }
    }

    public static void main(String[] args) {
        getField();
    }
}
