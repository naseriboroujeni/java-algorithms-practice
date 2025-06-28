package com.saeed.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramChecker {

    public static boolean areAnagrams(String s1, String s2) {
        s1 = s1.replaceAll("\\s+", "").toLowerCase();
        s2 = s2.replaceAll("\\s+", "").toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<String, Long> map1 = Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map2 = Arrays.stream(s2.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<String, Long> stringLongEntry : map1.entrySet()) {
            if (!stringLongEntry.getValue().equals(map2.get(stringLongEntry.getKey()))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("Li st   en", "Silent")); // true
        System.out.println(areAnagrams("Hello", "Olelh")); // true
        System.out.println(areAnagrams("Apple", "Pabble")); // false
    }
}
