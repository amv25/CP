//Nth term in Fibonacci Series - GFG
//Link - https://practice.geeksforgeeks.org/problems/rohans-love-for-matrix4723/1/ (not sure)

class NthFibonacciSlow {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int ans = fibo(10);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);

        System.out.println("Time: " + (totalTime / 1000000) + "ms");
    }

    static int fibo(int n) {
        if(n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}