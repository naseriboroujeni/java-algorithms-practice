package com.saeed.stream;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        boolean downward = true;
        int indexOfBuilder = 0;
        for (int i = 0; i < s.length(); i++) {
            builders[indexOfBuilder].append(s.charAt(i));
            if (indexOfBuilder == 0 && !downward) {
                downward = true;
            } else if (indexOfBuilder == numRows - 1 && downward) {
                downward = false;
            }
            if (downward) {
                indexOfBuilder++;
            } else {
                indexOfBuilder--;
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (StringBuilder builder : builders) {
            resultBuilder.append(builder);
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("AB", 1));
    }
}
