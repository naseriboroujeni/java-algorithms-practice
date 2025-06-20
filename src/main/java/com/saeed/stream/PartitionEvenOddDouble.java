package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEvenOddDouble {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Map<Boolean, List<Integer>> result =  numbers.stream().collect(
                Collectors.partitioningBy(
                        a -> a % 2 == 0,
                        Collectors.mapping(a -> a * 2, Collectors.toList())
                )
        );

        System.out.println(result);
    }
}
