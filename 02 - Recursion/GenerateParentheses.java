//Generate All Parentheses II - InterviewBit
//Link - https://www.interviewbit.com/problems/generate-all-parentheses-ii/

import java.util.*;

class GenerateParentheses {
    public static void main(String[] args) {
		new ArrayList<>();
        
        long startTime = System.nanoTime();
		
		//ArrayList<String> list = generate(16 * 2, 1, new StringBuilder("("), new ArrayList<String>());
		//ArrayList<String> list = generateFaster(16 * 2, 1, new StringBuilder("("), 1, new ArrayList<String>());
		//ArrayList<String> list = generateEvenFaster(16 * 2, 1, new StringBuilder("("), 1, 1, new ArrayList<String>());
        ArrayList<String> list = generateFastest(16 - 1, 16, new ArrayList<String>(), new StringBuilder("("));

		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;

		System.out.println(list.size());

		System.out.println("Time: " + (totalTime / 1000000) + "ms");
	}

    static ArrayList<String> generateFastest(int open, int close, ArrayList<String> resultList, StringBuilder output){
        if(open == 0 && close == 0){
            resultList.add(output.toString());
            return resultList;
        }

        int n = output.length();
        if(open != 0) {
        	output.append('(');
        	generateFastest(open - 1, close, resultList, output);
        	output.delete(n, n + 1);
        }
        if(close > open) {
        	output.append(')');
            generateFastest(open, close - 1, resultList, output);
            output.delete(n, n + 1);
        }

        return resultList;
    }

	static ArrayList<String> generateEvenFaster(int N, int index, StringBuilder s, int checker1, int checker2, ArrayList<String> list) {
		if(checker1 < 0) {
			return list;
		}
		if(checker2 > N / 2) {
			return list;
		}
		if(index == N) {
			list.add(s.toString());
	    	return list;
    	}
    	
    	int n = s.length();
    	s.append('(');
    	generateEvenFaster(N, index + 1, s, checker1 + 1, checker2 + 1, list);
		s.delete(n, n + 1);
    	s.append(')');
    	generateEvenFaster(N, index + 1, s, checker1 - 1, checker2, list);
    	s.delete(n, n + 1);
    	
    	return list;
	}
 	
	static ArrayList<String> generateFaster(int N, int index, StringBuilder s, int checker, ArrayList<String> list) {
		if(checker < 0) {
			return list;
		}
		if(index == N) {
			if(checker == 0) {
	    		list.add(s.toString());
    		}
	    	return list;
    	}
    	
		int n = s.length();
    	s.append('(');
    	generateFaster(N, index + 1, s, checker + 1, list);
    	s.delete(n, n + 1);
    	s.append(')');
    	generateFaster(N, index + 1, s, checker - 1, list);
    	s.delete(n, n + 1);
    	
    	return list;
	}

    static ArrayList<String> generate(int N, int index, StringBuilder s, ArrayList<String> list) {
    	if(index == N) {
    		if(isBalanced(s)) {
    			list.add(s.toString());
    		}
    		return list;
    	}

    	int n = s.length();
    	s.append('(');
    	generate(N, index + 1, s, list);
    	s.delete(n, n + 1);
    	s.append(')');
    	generate(N, index + 1, s, list);
    	s.delete(n, n + 1);

    	return list;
    }

    static boolean isBalanced(StringBuilder s) {
    	Stack<Character> checker = new Stack<>();

    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') {
    			checker.push('1');
    		}
    		else {
    			if(checker.empty()) {
    				return false;
    			}
    			checker.pop();
    		}
    	}

    	return checker.empty();
    } 
}