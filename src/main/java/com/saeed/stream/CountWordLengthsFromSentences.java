package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWordLengthsFromSentences {

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Spin apps are fast",
                "Streams simplify logic"
        );

        Map<Integer, Long> result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));

        System.out.println(result);
    }
}
