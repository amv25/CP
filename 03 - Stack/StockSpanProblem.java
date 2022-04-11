//Stock span problem - GFG
//Link - https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1/

import java.util.*;

class StockSpanProblem {
    public static void main(String[] args) {
        int[] que = new int[]{10, 4, 5, 90, 120, 80};
        int n = que.length;

        long startTime = System.nanoTime();
        
        int[] ans = stockSpan(que, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(ans));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int[] stockSpan(int[] nums, int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(stack.empty()) {
                result[i] = 1;
            }
            else {
                while(!stack.empty() && nums[i] >= nums[stack.peek()]) {
                    stack.pop();
                }
                if(stack.empty()) {
                    result[i] = i + 1;
                }
                else {
                    result[i] = i - stack.peek();
                }
            }
            stack.push(i);
        }
        
        return result;
    }
}