//704. Binary Search - Leetcode
//Link - https://leetcode.com/problems/binary-search/

class GuessGame {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        int ind = binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ind);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}