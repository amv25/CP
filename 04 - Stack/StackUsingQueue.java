//Stack implementation using a queue
//Link - https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/

import java.util.*;

class StackUsingQueue {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Push: 1");
        stack.push(1);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Push: 2");
        stack.push(2);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty: " + stack.isEmpty());
    }    
}

class CustomStack {
    Queue<Integer> queue = new LinkedList<>();

    void push(int val) {
        int n = queue.size();
        queue.add(val);
        for(int i = 0; i < n; i++) {
            int temp = queue.remove();
            queue.add(temp);
        }
    }

    int pop() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.remove();
    }

    int peek() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }
}