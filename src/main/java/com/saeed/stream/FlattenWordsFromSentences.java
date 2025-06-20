package com.saeed.stream;

import java.util.Arrays;
import java.util.List;

public class FlattenWordsFromSentences {

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is fun",
                "Streams are powerful",
                "FlatMap flattens streams"
        );

        List<String> result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .toList();

        System.out.println(result);
    }
}
