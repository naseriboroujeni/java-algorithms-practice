package com.saeed.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredDoubledNumbers = numbers.stream().filter(a -> a % 2 == 0).map(a -> a * 2).toList();

        System.out.println(filteredDoubledNumbers);

    }
}
