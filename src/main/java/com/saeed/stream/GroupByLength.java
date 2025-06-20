package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "bat", "car", "door", "egg", "fan", "go");

        Map<Integer, List<String>> result = words.stream().collect(Collectors.groupingBy(String::length));

        System.out.println(result);
    }
}
