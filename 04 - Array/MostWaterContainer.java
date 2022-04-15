//11. Container With Most Water - LeetCode
//Link - https://leetcode.com/problems/container-with-most-water/

class MostWaterContainer {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        long startTime = System.nanoTime();
        
        int ans = maxArea(nums);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);
        
        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        int start = 0;
        int end = height.length - 1;
        
        while(start < end) {
            max = Math.max(max, (Math.min(height[start], height[end]) * (end - start)));

            if(height[start] < height[end]) {
                start = start + 1;
            }
            else {
                end = end - 1;
            }
        }
        
        return max;
    }
}