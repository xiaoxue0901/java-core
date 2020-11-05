package com.demo.java8.chap5;

import com.demo.java8.chap4.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author:autumn
 * @date: 2019/12/29 5:06 PM
 * @description:
 */
public class GroupingBy {

    private static Map<Dish.Type, List<Dish>> groupBy1(){
        return Dish.menu.stream().collect(groupingBy(Dish::getType));
    }

//    private static Map<Dish.Type, List<Dish>> groupBy2(){
//        return Dish.menu.stream().collect(groupingBy(Dish::getType, groupingBy()));
//    }
//
//    private static String groupCondition() {
//       Map<String, List<Dish>> Dish.menu.stream().collect(groupingBy(dish -> {
//            if (dish.getCalories() < 300) {
//                return "dief";
//            } else {
//                return "normal";
//            }
//        }));
//    }
}
