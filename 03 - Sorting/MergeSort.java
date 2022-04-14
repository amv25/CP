//In-Place Merger Sort

import java.util.*;

class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        int n = nums.length;

        long startTime = System.nanoTime();
        
        mergeSort(nums, 0, n - 1);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(nums));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static void mergeSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merger(nums, start, mid + 1, mid, end);
    }

    static void merger(int[] nums, int s1, int s2, int e1, int e2) {
        int[] temp = new int[e2 - s1 + 1];
        int ind = 0;
        int start = s1;

        while(s1 <= e1 && s2 <= e2) {
            if(nums[s1] < nums[s2]) {
                temp[ind++] = nums[s1++];
            }
            else {
                temp[ind++] = nums[s2++];
            }
        }

        while(s1 <= e1) {
            temp[ind++] = nums[s1++];
        }
        while(s2 <= e2) {
            temp[ind++] = nums[s2++];
        }

        for(int i = start, j = 0; i <= e2; i++, j++) {
            nums[i] = temp[j];
        }
    }
}