package com.saeed.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopLongestWords {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "banana", "apple", "strawberry", "kiwi", "grape", "blueberry", "melon"
        );

        List<String> result = words.stream()
                .sorted((word1, word2) -> Integer.compare(word2.length(), word1.length()))
                .limit(3).collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println(result);
    }
}
