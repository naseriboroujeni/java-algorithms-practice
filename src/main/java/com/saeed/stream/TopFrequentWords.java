package com.saeed.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopFrequentWords {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "java", "stream", "java", "map", "filter", "java", "stream", "collect", "filter", "filter"
        );

        List<Map.Entry<String, Long>> result = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Comparator.comparing(
                        Map.Entry<String, Long>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .limit(3)
                .toList();

        System.out.println(result);
    }
}
