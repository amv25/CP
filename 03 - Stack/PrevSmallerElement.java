//Smallest number on left - GFG
//Link - https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1/

import java.util.*;

class PrevSmallerElement {
    public static void main(String[] args) {
        int[] que = new int[]{1, 5, 0, 3, 4, 5};
        int n = que.length;

        long startTime = System.nanoTime();
        
        //ArrayList<Integer> ans = prevSmallerElementBF(que, n);
        ArrayList<Integer> ans = prevSmallerElement(que, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static ArrayList<Integer> prevSmallerElementBF(int[] nums, int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int temp = -1;
            for(int j = i - 1; j > -1; j--) {
                if(nums[j] < nums[i]) {
                    temp = nums[j];
                    break;
                }
            }
            result.add(temp);
        }

        return result;
    }

    static ArrayList<Integer> prevSmallerElement(int[] nums, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.empty() && nums[i] <= stack.peek()) {
                stack.pop();
            }
            if(!stack.empty()) {
                result.add(stack.peek());
            }
            else {
                result.add(-1);
            }
            stack.push(nums[i]);
        }
        
        return result;
    }
}