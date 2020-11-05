package com.demo.base.bean;

import com.demo.base.reflect.MyAnnatation;
import com.demo.base.reflect.MyInterface;
import lombok.Data;

/**
 * @author:autumn
 * @date: 2019/11/18 10:59 PM
 * @description:
 */
@Data
public class Person extends Creature<String> implements Comparable, MyInterface {

    public String name;
    private int age;



    @MyAnnatation(value = "123")
    public void show() {
        System.out.println("java反射");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private int display(String b) {
        System.out.println("private method:"+b);
        return 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public static void info(){
        System.out.println("persion");
    }
}
