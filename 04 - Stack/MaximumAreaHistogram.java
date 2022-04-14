//Maximum Rectangular Area in a Histogram - GFG
//Link - https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1

import java.util.*;

class MaximumAreaHistogram {
    public static void main(String[] args) {
        long[] nums = new long[]{6, 2, 5, 4, 5, 1, 6};
        int n = nums.length;

        long startTime = System.nanoTime();

        long max = maximunAreaHistogram(nums, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(max);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static long maximunAreaHistogram(long[] nums, int n) {
        long max = -1;

        // long[] left = leftSmallerElement(nums, n);
        // long[] right = rightSmallerElement(nums, n);

        long[] left = new long[n];
        long[] right = new long[n];
        bothSmaller(nums, n, left, right);

        for(int i = 0; i < n; i++) {
            max = Math.max(max, (left[i] + right[i] - 1) * nums[i]);
        }

        return max;
    }

    static void bothSmaller(long[] nums, int n, long[] left, long[] right) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!leftStack.isEmpty() && nums[leftStack.peek()] >= nums[i]) {
                leftStack.pop();
            }
            while(!rightStack.isEmpty() && nums[rightStack.peek()] >= nums[n - i - 1]) {
                rightStack.pop();
            }

            if(leftStack.isEmpty()) {
                left[i] = i + 1;
            }
            else {
                left[i] = i - leftStack.peek();
            }

            if(rightStack.isEmpty()) {
                right[n - i - 1] = i + 1;
            }
            else {
                right[n - i - 1] = rightStack.peek() - n + i + 1;
            }

            leftStack.push(i);
            rightStack.push(n - i - 1);
        }
    }
    
    static long[] leftSmallerElement(long[] nums, int n) {
        long[] res = new long[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = i + 1;
            }
            else {
                res[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return res;
    }

    static long[] rightSmallerElement(long[] nums, int n) {
        long[] res = new long[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i > -1; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = n - i;
            }
            else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }
}