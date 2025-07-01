package com.saeed.stream;

public class OriginalTypedString {

    public static int possibleStringCount(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        int result = 1;

        int currentCharCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i > 0 && word.charAt(i) != word.charAt(i - 1)) {
                currentCharCount = 0;
            }
            currentCharCount++;
            if (currentCharCount > 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        System.out.println(possibleStringCount("abcd"));
        System.out.println(possibleStringCount("aaaa"));
        System.out.println(possibleStringCount("aabbccdd"));
        System.out.println(possibleStringCount("ere"));
    }
}
