//784. Letter Case Permutation - Leetcode
//Link - https://leetcode.com/problems/letter-case-permutation/

import java.util.*;

class LetterCasePermutation {
    public static void main(String[] args) {
        String string = "amv";

        long startTime = System.nanoTime();
        
        ArrayList<String> list = casePerm(string.toCharArray(), 0, new ArrayList<String>());

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(list);
        
        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static ArrayList<String> casePerm(char[] charArr, int index, ArrayList<String> list) {
        if(index == charArr.length) {
            list.add(String.valueOf(charArr));
            return list;
        }

        if(Character.isLetter(charArr[index])) {
            charArr[index] = Character.toUpperCase(charArr[index]);
            casePerm(charArr, index + 1, list);

            charArr[index] = Character.toLowerCase(charArr[index]);
            casePerm(charArr, index + 1, list);

            return list;
        }

        casePerm(charArr, index + 1, list);
        return list;
    }
}