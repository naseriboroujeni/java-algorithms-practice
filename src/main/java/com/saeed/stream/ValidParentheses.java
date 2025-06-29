package com.saeed.stream;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                bracketStack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if (bracketStack.isEmpty()) {
                    return false;
                }
                char temp = bracketStack.pop();
                if ((s.charAt(i) == '}' && temp != '{')
                        || (s.charAt(i) == ')' && temp != '(')
                        || (s.charAt(i) == ']' && temp != '[')) {
                    return false;
                }
            }
        }
        return bracketStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));       // Expected: true
        System.out.println(isValid("()[]{}"));   // Expected: true
        System.out.println(isValid("(]"));       // Expected: false
        System.out.println(isValid("([)]"));     // Expected: false
        System.out.println(isValid("{[]}"));     // Expected: true
    }
}
