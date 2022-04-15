//Minimun of a Stack Without Extra Space - GFG
//Link - https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/

import java.util.*;

class MinimumOfStackNoExtraSpace {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        
        System.out.println("Empty: " + stack.isEmpty());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Min: " + stack.getMin());

        System.out.println("Push: 5");
        stack.push(5);
        System.out.println("Min: " + stack.getMin());

        System.out.println("Push: 3");
        stack.push(3);
        System.out.println("Min: " + stack.getMin());

        System.out.println("Push: 1");
        stack.push(1);
        System.out.println("Min: " + stack.getMin());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Min: " + stack.getMin());
        
        System.out.println("Empty: " + stack.isEmpty());
    }   
}

class CustomStack {
    int minEle;
    Stack<Integer> stack = new Stack<Integer>();
    
    int getMin() {
	    if(isEmpty()) {
	        return -1;
	    }
	    return minEle;
    }
    
    int pop() {
        if(isEmpty()) {
	        return -1;
	    }
        if(stack.peek() >= minEle) {
            return stack.pop();
        }
        int temp = minEle;
        minEle = ((2 * minEle) - stack.pop());
        return temp;
    }
    
    void push(int x) {
        if(isEmpty()) {
            stack.push(x);
            minEle = x;
        }
	    else {
    	    if(x < minEle) {
    	        stack.push((2 * x) - minEle);
    	        minEle = x;
    	    }
    	    else {
    	        stack.push(x);
    	    }
	    }
    }
    
    int peek() {
        if(isEmpty()) {
	        return -1;
	    }
        if(stack.peek() >= minEle) {
            return stack.peek();
        }
        return ((2 * minEle) - stack.peek());
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }
}
