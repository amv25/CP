//1630. Arithmetic Subarrays - Leetcode
//Link - https://leetcode.com/problems/arithmetic-subarrays/

import java.util.*;

class ArithmeticSubarrays {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};

        long startTime = System.nanoTime();
        
        ArrayList<Boolean> list = arithSub(nums, l, r);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(list);
        
        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static ArrayList<Boolean> arithSub(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> res = new ArrayList<>();

        for(int i = 0; i < l.length; i++) {
            int n = r[i] - l[i] + 1;
            int[] arr = new int[n];

            for(int j = l[i], k = 0; j <= r[i]; j++, k++) {
                arr[k] = nums[j];
            }

            Arrays.sort(arr);
            int d = arr[1] - arr[0];
            boolean temp = true;
            for(int j = 1; j < n - 1; j++) {
                if(!(arr[j + 1] - arr[j] == d)) {
                    temp = !temp;
                    break;
                }
            }
            res.add(temp);
        }

        return res;
    }
}