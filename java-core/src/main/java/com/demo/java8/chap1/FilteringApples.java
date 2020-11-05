package com.demo.java8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author:autumn
 * @date: 2019/12/18 12:39 AM
 * @description:
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 170),
                new Apple("red", 130)
        );

        // lambda表达式
        List<Apple> greeApples2 = filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(greeApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple apple) -> apple.getWeight() > 150);
        System.out.println(heavyApples2);

        // lambda复合使用.
        List<Apple> senorApple = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()) || apple.getWeight()> 130);
        System.out.println(senorApple);

        // 方法引用: 将lambda表达式的语句抽出来, 放入一个单独的方法中. 此方法满足函数描述符
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApply);
        System.out.println(heavyApples);
    }

    /**
     * 需求1: 挑选绿苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 需求2: 挑选重量超过150的苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 升级版: 满足需求1和需求2
     *
     * @param inventory
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 选择绿苹果方法
     *
     * @param apple
     * @return
     */
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    /**
     * 选择超重的苹果方法
     *
     * @param apple
     * @return
     */
    public static boolean isHeavyApply(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static class Apple {
        private String color = "";
        private int weight = 0;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
