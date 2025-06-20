package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionAndCubeByDiv3 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 7, 9);

        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(
                        a -> a % 3 == 0,
                        Collectors.mapping(
                                a -> a * a * a,
                                Collectors.toList()
                        )
                ));

        System.out.println(result);
    }
}
