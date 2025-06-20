package com.saeed.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DebugStreamWithPeek {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "Awesome", "fun", "Streams", "are", "Powerful");

        List<String> result = words.stream()
                .map(String::toLowerCase)
                .peek(word -> System.out.println("LowerCase: " + word))
                .sorted(Comparator.comparingInt(String::length))
                .peek(word -> System.out.println("Sorted: " + word))
                .limit(3)
                .peek(word -> System.out.println("Limit: " + word))
                .map(String::toUpperCase)
                .toList();

        System.out.println(result);
    }
}
