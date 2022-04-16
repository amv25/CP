//Bubble Sort

import java.util.*;

class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 2, 3, 6, 7, 8, 9, 0};

        long startTime = System.nanoTime();
        
        //bubbleSortLeft(nums);
        bubbleSortRight(nums);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(nums));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static void bubbleSortLeft(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    static void bubbleSortRight(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}