package com.demo.java8.chap5;

import com.alibaba.fastjson.JSON;
import com.demo.java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static com.demo.java8.chap4.Dish.menu;
public class Mapping {

    public static void main(String...args){

        // map
        List<String> dishNames = menu.stream()
                                     .map(Dish::getName)
                                     .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        String[] re = "Hello".split("");
        System.out.println("==========结果:"+JSON.toJSONString(re));
        // flatMap
        words.stream()
                // 对每个元素做map+流扁平化
                // Stream<String> s1 = Arrays.stream("Hello".split(""))
                // Stream<String> s1 = Arrays.stream("World".split(""))
                // 再讲s1和s2合并为一个流.
                 .flatMap((String line) -> Arrays.stream(line.split("")))
                 .distinct()
                 .forEach(System.out::println);

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                // 将number2中的每个元素和number1中的元素组合, 产生Stream<int[]> s1
                                // 将number1中的每个元素都执行上述操作, 产生Stream<int[]> sn
                                // 将s1,...sn加起来形成一个Stream<int[]>
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
