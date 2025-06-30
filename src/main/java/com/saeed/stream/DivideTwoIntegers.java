package com.saeed.stream;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        boolean isNegative = dividend < 0 != divisor < 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int temp = 1 + divide(dividend - divisor, divisor);
        return isNegative? -1 * temp : temp;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(-7, -3));
        System.out.println(divide(-2147483648, -1));
    }
}
