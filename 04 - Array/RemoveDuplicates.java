//26. Remove Duplicates from Sorted Array - Leetcode
//Link - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8};

        long startTime = System.nanoTime();
        
        int n = removeDuplicates(nums);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        for(int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        
        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int removeDuplicates(int[] nums) {
        int i = 0;

        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        
        return i + 1;
    }
}