//Find the Safe Position - GFG
//Link - https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1

import java.util.*;

class FindSafePosition {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int ans = safePos(4, 2, 0, makeList(4));

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);

        System.out.println("Time: " + (totalTime / 1000000) + "ms");
    }

    static ArrayList<Integer> makeList(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        while(n != 0) {
            list.add(0, n--);
        }

        return list;
    }

    static int safePos(int n, int k, int index, ArrayList<Integer> list) {
        if(list.size() == 1) {
            return list.get(0);
        }

        index = (k - 1 + index) % list.size();
        list.remove(index);

        return safePos(n, k, index, list);
    }
}