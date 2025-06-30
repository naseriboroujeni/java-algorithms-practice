package com.saeed.stream;

public class StringToInteger {

    public static int myAtoi(String s) {
        boolean otherThanSpaceSeen = false;
        int sign = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!otherThanSpaceSeen && s.charAt(i) == ' ') {
                continue;
            }
            if (!otherThanSpaceSeen && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                sign = s.charAt(i) == '-' ? -1 : 1;
                otherThanSpaceSeen = true;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            } else {
                int digit = s.charAt(i) - '0';
                if ((result == Integer.MAX_VALUE / 10 && digit > 7) || result > Integer.MAX_VALUE / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
                otherThanSpaceSeen = true;
            }
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("    +42"));
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("0-1"));
    }
}
