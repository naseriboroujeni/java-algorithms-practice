package com.saeed.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class frequencySort {

    public static void main(String[] args) {
        String input = "tree";

        String result = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed())
                .map(entry -> entry.getKey().repeat(entry.getValue().intValue()))
                .collect(Collectors.joining());

        System.out.println(result);
    }
}
