//Minimun of a Stack Using Extra Space - GFG
//Link - https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/

import java.util.*;

class MinimumOfStackExtraSpace {
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
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    int getMin() {
	    if(minStack.isEmpty()) {
	        return -1;
	    }
	    return minStack.peek();
    }
    
    int pop() {
        if(isEmpty()) {
            return -1;
        }
        int temp = stack.pop();
        if(temp == minStack.peek()) {
            minStack.pop();
        }
        return temp;
    }
    
    void push(int x) {
        if(isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    int peek() {
        if(isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }
}
