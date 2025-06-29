package com.saeed.stream;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> digits = new ArrayList<>();
        while (x != 0) {
            digits.add(x % 10);
            x /= 10;
        }
        int length = digits.size();
        for (int i = 0; i < length; i++) {
            if(!digits.get(i).equals(digits.get(length - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));     // Expected: true
        System.out.println(isPalindrome2(-121));    // Expected: false
        System.out.println(isPalindrome2(10));      // Expected: false
        System.out.println(isPalindrome2(0));       // Expected: true
    }
}
