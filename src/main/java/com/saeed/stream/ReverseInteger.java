package com.saeed.stream;

public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));          // Expected: 321
        System.out.println(reverse(-123));         // Expected: -321
        System.out.println(reverse(1200));         // Expected: 21
        System.out.println(reverse(1534236469));   // Expected: 0
        System.out.println(reverse(0));            // Expected: 0
    }
}
