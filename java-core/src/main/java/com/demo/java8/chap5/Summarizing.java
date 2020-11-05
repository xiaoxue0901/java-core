package com.demo.java8.chap5;

import com.demo.java8.chap4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * @author:autumn
 * @date: 2019/12/29 5:09 PM
 * @description:
 */
public class Summarizing {
    public static void main(String[] args) {
        System.out.println("数一数菜单里有多少种菜"+howManyDishs());
        System.out.println("数一数菜单里有多少种菜"+howManyDishs2());
        System.out.println("总卡路里:" + dishCaloric());
        System.out.println("统计数:"+getStatistics().getAverage()+"::" + getStatistics().getSum()+"::"
        +getStatistics().getMax());
        System.out.println("菜名"+getDishTotalName());
        System.out.println("菜名"+getDishTotalName2());
    }

    // 数一数菜单里有多少种菜
    private static long howManyDishs() {
        return Dish.menu.stream()
                .collect(counting());
    }

    private static long howManyDishs2() {
        return Dish.menu.stream()
                .count();
    }


    private static Dish mostCaloriesDish() {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> most = Dish.menu.stream()
                .collect(maxBy(dishComparator));
        return most.get();
    }

    private static Dish minCaloriesDish() {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> most = Dish.menu.stream()
                .collect(minBy(dishComparator));
        return most.get();
    }

    // 总卡路里
    private static int dishCaloric() {
    int total = Dish.menu.stream()
                .collect(summingInt(Dish::getCalories));
        return total;
    }

    // 平均数
    private static double dishAverage() {
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

    // 统计数
    private static IntSummaryStatistics getStatistics() {
        return Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    // 连接字符串
    private static String getDishTotalName() {
        return Dish.menu.stream().map(Dish::getName).collect(joining());
    }
    // 连接字符串2
    private static String getDishTotalName2() {
        return Dish.menu.stream().map(Dish::getName).collect(joining(": "));
    }

    // 广义归约汇总
    private static int useReducing() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));
    }

    private static int useReducing2() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int useReduce() {
        Optional<Integer> r = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum);
        return r.get();
    }


}
