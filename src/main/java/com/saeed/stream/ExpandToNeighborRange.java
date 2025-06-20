package com.saeed.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ExpandToNeighborRange {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20);

        List<Integer> result = input.stream()
                .map(a -> List.of(a-1, a, a+1))
                .flatMap(Collection::stream)
                .toList();

        System.out.println(result);
    }
}
