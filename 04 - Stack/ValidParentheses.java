// 20.Valid Parentheses - LeetCode
// Link - https://leetcode.com/problems/valid-parentheses/

import java.util.*;

class ValidParentheses {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        boolean t1 = isValid("([]{})");
        boolean t2 = isValid("([]{}");

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(')');
            }
            else if(s.charAt(i) == '[') {
                stack.push(']');
            }
            else if(s.charAt(i) == '{') {
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.peek() != s.charAt(i)) {
                return false;
            }
            else {
                stack.pop();
            }
        }

        return stack.empty();
    }
}
