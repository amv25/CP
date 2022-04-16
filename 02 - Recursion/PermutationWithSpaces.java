//Permutation with Spaces - GFG
//Link - https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1

import java.util.*;

class PermutationWithSpaces {
    public static void main(String[] args) {
        String string = "amv";

        long startTime = System.nanoTime();
        
        ArrayList<String> list = permutationWithSpaces(new StringBuilder(string), 1, new ArrayList<String>());

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(list);
        
        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static ArrayList<String> permutationWithSpaces(StringBuilder input, int index, ArrayList<String> res) {
        if(index == input.length()) {
            res.add(input.toString());
            return res;
        }

        input.insert(index, " ");
        permutationWithSpaces(input, index + 2, res);

        input.delete(index, index + 1);
        permutationWithSpaces(input, index+1, res);

        return res;
    }
}