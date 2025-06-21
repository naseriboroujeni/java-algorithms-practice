package com.saeed.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyByLength {

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java streams are powerful",
                "Streams can be tricky",
                null,
                "",
                "Java is fun with streams"
        );

        Map<Integer, List<String>> result = sentences.stream()
                .filter(Objects::nonNull)
                .filter(sentence -> !sentence.isBlank())
                .map(String::toLowerCase)
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                word -> word,
                                Collectors.collectingAndThen(
                                        Collectors.groupingBy(
                                                Function.identity(),
                                                Collectors.counting()
                                        ),
                                        map -> map.entrySet().stream()
                                                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue)
                                                        .reversed()
                                                        .thenComparing(Map.Entry::getKey)
                                                )
                                                .map(entry -> entry.getKey() + "(" + entry.getValue() + ")")
                                                .toList()
                                )
                        )
                ));

        System.out.println(result);
    }
}
