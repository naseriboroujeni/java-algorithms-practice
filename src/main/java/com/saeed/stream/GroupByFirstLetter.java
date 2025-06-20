package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstLetter {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry", "apricot");

        Map<Character, List<String>> result = words.stream().collect(Collectors.groupingBy(
                word -> word.charAt(0),
                Collectors.mapping(String::toUpperCase, Collectors.toList())
        ));

        System.out.println(result);
    }
}
