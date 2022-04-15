//2221. Find Triangular Sum of an Array - Leetcode
//Link - https://leetcode.com/problems/find-triangular-sum-of-an-array/

class TriangularSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        long startTime = System.nanoTime();
        
        int ans = triangularSum(nums);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);
        
        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int triangularSum(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] next = new int[--n];
        for(int i = 0; i < n; i++) {
            next[i] = (nums[i] + nums[i + 1]) % 10;
        }
        
        return triangularSum(next);
    }
}