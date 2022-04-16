//704. Binary Search - Leetcode
//Link - https://leetcode.com/problems/binary-search/

class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int n = nums.length;
        int target = 9;

        long startTime = System.nanoTime();
        
        int ind = binarySearch(nums, target, 0, n - 1);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ind);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if(arr[mid] == target) {
            return mid;
        }

        if(arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, end);
    }
}