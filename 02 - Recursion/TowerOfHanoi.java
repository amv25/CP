//Tower Of Hanoi - GFG
//Link - https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1/

class TowerOfHanoi {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        long ans = towerOfHanoi(5, 1, 3, 2);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);

        System.out.println("Time: " + (totalTime / 1000000) + "ms");
    }

    static long towerOfHanoi(int N, int from, int to, int aux) {
        if(N == 1) {
            System.out.println("move disk 1 from rod " + from + " to rod " + to);
            return 1;
        }

        long temp = 1 + towerOfHanoi(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        
        return temp + towerOfHanoi(N - 1, aux, to, from);
    }
}