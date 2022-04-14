//Quick Sort

import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        int n = nums.length;

        long startTime = System.nanoTime();
        
        quickSort(nums, 0, n - 1);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(nums));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        
        int st = start;
        int et = end;
        int mid = start + (end - start) / 2;

        while(st <= et) {
            while(nums[st] < nums[mid]) {
                st++;
            }
            while(nums[et] > nums[mid]) {
                et--;
            }
            if(st <= et) {
                int temp = nums[st];
                nums[st++] = nums[et];
                nums[et--] = temp;
            }
        }
        quickSort(nums, start, et);
        quickSort(nums, st, end);
    }
}