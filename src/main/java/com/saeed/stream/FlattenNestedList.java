package com.saeed.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlattenNestedList {

    public static void main(String[] args) {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                List.of(6)
        );

        List<Integer> result = nested.stream().flatMap(Collection::stream).toList();

        System.out.println(result);
    }
}
