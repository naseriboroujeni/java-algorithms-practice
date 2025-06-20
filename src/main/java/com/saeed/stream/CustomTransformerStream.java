package com.saeed.stream;

import java.util.Arrays;
import java.util.List;

public class CustomTransformerStream {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        NumberTransformer makeSquare = a -> a * a;

        List<Integer> result = numbers.stream().filter(a -> a % 2 == 0).map(makeSquare::transform).toList();

        System.out.println(result);

    }
}
