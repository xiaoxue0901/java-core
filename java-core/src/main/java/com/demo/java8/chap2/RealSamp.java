package com.demo.java8.chap2;

import com.demo.java8.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author:autumn
 * @date: 2019/12/18 9:34 PM
 * @description:
 */
public class RealSamp {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

        //排序
        appleSort1(inventory);
        appleSort2(inventory);

        // 线程
        new Thread(()-> System.out.println("执行线程")).start();
    }

    public static void appleSort1(List<Apple> inventory) {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    public static void appleSort2(List<Apple> inventory) {
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }


}
