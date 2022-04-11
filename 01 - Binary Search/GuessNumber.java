//374. Guess Number Higher or Lower - Leetcode
//Link - https://leetcode.com/problems/guess-number-higher-or-lower/

class GuessGame {
    public static void main(String[] args) {
        int max = 30;

        long startTime = System.nanoTime();
        
        int n = guessNumber(max);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(n);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int target = 25;

    static int guess(int n) {
        if(n == target) {
            return 0;
        }
        if(n > target) {
            return -1;
        }
        return 1;
    }

    static int guessNumber(int n) {
        int start = 0;
        int end = n;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(guess(mid) == 0) {
                return mid;
            }
            if(guess(mid) == 1) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}