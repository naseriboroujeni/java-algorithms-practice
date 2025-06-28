package com.saeed.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

    public static char firstNonRepeatingChar(String s) {
        s = s.replaceAll("\\s+", "");
        Map<String, Long> charCount = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        for (char c: s.toCharArray()) {
            if (charCount.get(String.valueOf(c)) == 1) {
                return c;
            }
        }
        return '\0';  // default if no non-repeating char found
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("swiss"));      // Expected: w
        System.out.println(firstNonRepeatingChar("redivider"));  // Expected: v
        System.out.println(firstNonRepeatingChar("aabbcc"));     // Expected: \0 (no unique char)
    }
}
