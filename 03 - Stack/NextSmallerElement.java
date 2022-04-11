//Help Classmates - GFG
//Link - https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1/

import java.util.*;

class NextSmallerElement {
    public static void main(String[] args) {
        int[] que = new int[]{3, 8, 5, 2, 25};
        int n = que.length;

        long startTime = System.nanoTime();
        
        //int[] ans = nextSmallerElementBF(que, n);
        int[] ans = nextSmallerElement(que, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(ans));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int[] nextSmallerElementBF(int[] nums, int n) {
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = -1;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] < nums[i]) {
                    temp = nums[j];
                    break;
                }
            }
            ans[i] = temp;
        }

        return ans;
    }

    static int[] nextSmallerElement(int[] nums, int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            if(stack.empty()) {
                result[i] = -1;
            }
            else {
                while(!stack.empty() && nums[i] <= stack.peek()) {
                    stack.pop();
                }
                if(!stack.empty()) {
                    result[i] = stack.peek();
                }
                else {
                    result[i] = -1;
                }
            }
            stack.push(nums[i]);
        }

        return result;
    }
}