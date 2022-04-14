//Maximum size rectangle binary sub-matrix with all 1s - GFG
//Link - https://practice.geeksforgeeks.org/problems/max-rectangle/1/

import java.util.*;

class MaximumSizeRectange {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 1, 1, 0},
                                   {1, 1, 1, 1},
                                   {1, 1, 1, 1},
                                   {1, 1, 0, 0}};
        int n = nums.length;
        int m = nums[0].length;

        long startTime = System.nanoTime();

        int max = maximumSizeRectange(nums, m, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(max);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int maximumSizeRectange(int[][] nums, int m, int n) {
        int max = -1;
        int[] lr = new int[n];

        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                if(nums[i][j] == 0) {
                    lr[i] = 0;
                    continue;
                }
                lr[i]++;
            }
            max = Math.max(max, maximunAreaHistogram(lr, n));
            System.out.println(Arrays.toString(lr) + " | " + max);
        }

        return max;
    }

    static int maximunAreaHistogram(int[] nums, int n) {
        int max = -1;
        
        int[] left = new int[n];
        int[] right = new int[n];
        bothSmaller(nums, n, left, right);

        for(int i = 0; i < n; i++) {
            max = Math.max(max, (left[i] + right[i] - 1) * nums[i]);
        }

        return max;
    }

    static void bothSmaller(int[] nums, int n, int[] left, int[] right) {
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
}
