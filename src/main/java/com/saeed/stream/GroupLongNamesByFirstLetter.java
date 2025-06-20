package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupLongNamesByFirstLetter {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Reza", "Sara", "Mo", "Amir", "Bob");

        Map<Character, List<String>> result = names.stream()
                .filter(name -> name.length() > 3)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0)
                ));

        System.out.println(result);
    }
}
