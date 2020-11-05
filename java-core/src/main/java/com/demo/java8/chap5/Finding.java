package com.demo.java8.chap5;

import com.demo.java8.chap4.Dish;

import java.util.Optional;

/**
 * @author:autumn
 * @date: 2019/12/26 11:24 PM
 * @description:
 */
public class Finding {
    public static void main(String[] args) {
        // 匹配
        System.out.println(isVegetarianFriendlyMenu());
        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu1());
        System.out.println("--------------");
        findAnyVegetarianDish();
        getFirshDish();
    }

    // 查找出任意元素
    private static Dish findAnyVegetarianDish() {
        Optional<Dish> optional = Dish.menu.stream().filter(Dish::isVegetarian)
                .findAny();
        System.out.println("是否存在值:" + optional.isPresent());
        System.out.println("存在值则打印出来");
        optional.ifPresent(System.out::println);
        // 获取值
        System.out.println("素菜:" + optional.get());
        // 值不存在. 返回默认值
        return optional.orElse(new Dish("no", false, 800, Dish.Type.MEAT));
    }

    private static Dish getFirshDish() {
        return Dish.menu.stream().filter(d -> d.getCalories() > 200).findFirst().get();
    }

    // 至少匹配一个
    private static boolean isVegetarianFriendlyMenu() {
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }

    // 匹配所有
    private static boolean isHealthyMenu() {
        return Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    // 所有的都不匹配
    private static boolean isHealthyMenu1() {
        return Dish.menu.stream().noneMatch(d -> d.getCalories() > 1000);
    }
}
