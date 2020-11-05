package com.demo.java8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author:autumn
 * @date: 2019/12/27 12:04 AM
 * @description:
 */
public class Reducing {
    public static void main(String[] args) {
        // 元素求和
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 初始值0
        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = numbers.stream().reduce(1, (a, b) -> a*b);

        // 无初始值
        // 考虑到流中可能没有任何元素. 会返回空值.
        Optional<Integer> sum3 = numbers.stream().reduce((a,b) -> a+b);

        // 最大值
        numbers.stream().reduce(Integer::max);

        // 最小值
        numbers.stream().reduce(Integer::min);


    }
}
