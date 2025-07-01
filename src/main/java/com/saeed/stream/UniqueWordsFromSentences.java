package com.saeed.stream;

import java.util.Arrays;
import java.util.List;

public class UniqueWordsFromSentences {

    public static List<String> extractWords(List<String> sentences) {
        return sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Hello world",
                "world of Java",
                "Streams are powerful"
        );
        System.out.println(extractWords(sentences));
    }
}
