package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupFlattenedWordsByLength {

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Streams flatten collections",
                "Group words by length"
        );

        Map<Integer, List<String>> result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(String::length));

        System.out.println(result);
    }
}
