//69. Sqrt(x) - Leetcode
//Link - https://leetcode.com/problems/sqrtx/

class SquareRoot {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        int ans = sqrt(0);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);

        System.out.println("Time: " + (totalTime / 1000000) + "ms");
    }

    static int sqrt(int n) {
        if(n == 1) {
            return 1;
        }

        int start = 1;
        int end = n / 2;
        int res = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            long temp = mid * mid;
            if(temp == n) {
                return mid;
            }
            if(temp < n) {
                res = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return res;
    }
}