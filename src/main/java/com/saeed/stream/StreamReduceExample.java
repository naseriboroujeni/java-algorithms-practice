package com.saeed.stream;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int res = numbers.stream().filter(a -> a % 2 == 1)
                .reduce(1, (a, b) -> a * b);
        System.out.println(res);
    }
}
