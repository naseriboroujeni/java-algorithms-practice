package com.saeed.stream;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> romanDigits = new HashMap<>();
        romanDigits.put('I', 1);
        romanDigits.put('V', 5);
        romanDigits.put('X', 10);
        romanDigits.put('L', 50);
        romanDigits.put('C', 100);
        romanDigits.put('D', 500);
        romanDigits.put('M', 1000);

        int result = 0;

        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            int temp1 = romanDigits.get(s.charAt(i));
            if (i > 0) {
                int temp2 = romanDigits.get(s.charAt(i - 1));
                if (temp2 < temp1) {
                    temp1 = temp1 - temp2;
                    i--;
                }
            }
            result += temp1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));       // Expected: 3
        System.out.println(romanToInt("IV"));        // Expected: 4
        System.out.println(romanToInt("IX"));        // Expected: 9
        System.out.println(romanToInt("LVIII"));     // Expected: 58
        System.out.println(romanToInt("MCMXCIV"));   // Expected: 1994
    }
}
