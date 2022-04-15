//503. Next Greater Element II - Leetcode
//Link - https://leetcode.com/problems/next-greater-element-ii

import java.util.*;

class NextGreaterElementCyclic {
    public static void main(String[] args) {
        long[] que = new long[]{2, 10, 12, 1, 11};
        int n = que.length;

        long startTime = System.nanoTime();
        
        long[] ans = nextGreaterElementCyclic(que, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(ans));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static long[] nextGreaterElementCyclic(long[] nums, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();

        for(int i = (2 * n) - 1; i >= 0; i--) {
            int temp = i % n;
            while(!stack.empty() && nums[temp] >= stack.peek()) {
                stack.pop();
            }
            if(i == temp) {
                if(!stack.empty()) {
                    result[temp] = stack.peek();
                }
                else {
                    result[temp] = -1;
                }
            }
            stack.push(nums[temp]);
        }
        
        return result;
    }
}