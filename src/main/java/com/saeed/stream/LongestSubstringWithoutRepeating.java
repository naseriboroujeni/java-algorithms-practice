package com.saeed.stream;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> seenChars = new HashMap<>();
        int max = 1;
        int start = 0;
        int end = 1;
        seenChars.put(s.charAt(0), 1);
        while (end < s.length() && start < s.length()) {
            if (seenChars.getOrDefault(s.charAt(end), 0) == 0) {
                seenChars.put(s.charAt(end), seenChars.getOrDefault(s.charAt(end), 0) + 1);
                end++;
            } else {
                seenChars.put(s.charAt(start), seenChars.get(s.charAt(start)) - 1);
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Expected: 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Expected: 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Expected: 3 ("wke")
    }
}
