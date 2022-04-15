//Queue implementation using stack
//Link - https://practice.geeksforgeeks.org/problems/queue-using-stack/1/

import java.util.*;

class QueueUsingStack {
    public static void main(String[] args) {
        SlowCustomQueue queue = new SlowCustomQueue();

        System.out.println("Empty  : " + queue.isEmpty());
        System.out.println("Peek   : " + queue.peek());
        System.out.println("Remove : " + queue.remove());
        System.out.println("Add    : 1");
        queue.add(1);
        System.out.println("Peek   : " + queue.peek());
        System.out.println("Add    : 2");
        queue.add(2);
        System.out.println("Peek   : " + queue.peek());
        System.out.println("Add    : 3");
        queue.add(3);
        System.out.println("Remove : " + queue.remove());
        System.out.println("Remove : " + queue.remove());
        System.out.println("Remove : " + queue.remove());
        System.out.println("Empty  : " + queue.isEmpty());

        System.out.println();
        System.out.println("----------");
        System.out.println();

        CustomQueue queue1 = new CustomQueue();

        System.out.println("Empty  : " + queue1.isEmpty());
        System.out.println("Peek   : " + queue1.peek());
        System.out.println("Remove : " + queue1.remove());
        System.out.println("Add    : 1");
        queue1.add(1);
        System.out.println("Peek   : " + queue1.peek());
        System.out.println("Add    : 2");
        queue1.add(2);
        System.out.println("Peek   : " + queue1.peek());
        System.out.println("Add    : 3");
        queue1.add(3);
        System.out.println("Remove : " + queue1.remove());
        System.out.println("Remove : " + queue1.remove());
        System.out.println("Remove : " + queue1.remove());
        System.out.println("Empty  : " + queue1.isEmpty());
    }    
}

class SlowCustomQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    void add(int x) {
        if(isEmpty()) {
            stack.push(x);
            return;
        }
        
        while(!isEmpty()) {
            helper.push(stack.pop());
        }
        stack.push(x);
        while(!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    int remove() {
        if(isEmpty()) {
            return -1;
        }
        return stack.pop();
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

class CustomQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void add(int x) {
        input.push(x);
    }

    int remove() {
        if(isEmpty() && output.isEmpty()) {
            return -1;
        }
        if(output.isEmpty()) {
            while(!isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    int peek() {
        if(isEmpty() && output.isEmpty()) {
            return -1;
        }
        if(output.isEmpty()) {
            while(!isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    boolean isEmpty() {
        return input.isEmpty();
    }
}