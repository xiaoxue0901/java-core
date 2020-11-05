package com.demo.java8;

import lombok.Data;

/**
 * @author:autumn
 * @date: 2019/12/18 9:41 PM
 * @description:
 */
@Data
public class Apple {
    private String color;
    private int weight;

    public Apple(int weight,String color) {
        this.color = color;
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }
}
