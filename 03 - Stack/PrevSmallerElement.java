import java.util.*;

class PrevSmallerElement {
    public static void main(String[] args) {
        long[] que = new long[]{1, 5, 0, 3, 4, 5};
        int n = que.length;

        long startTime = System.nanoTime();
        
        //long[] ans = prevSmallerElementBF(que, n);
        long[] ans = prevSmallerElement(que, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(ans));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static long[] prevSmallerElementBF(long[] nums, int n) {
        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            long temp = -1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    temp = nums[j];
                    break;
                }
            }
            ans[i] = temp;
        }

        return ans;
    }

    static long[] prevSmallerElement(long[] nums, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(stack.empty()) {
                result[i] = -1;
                stack.push(nums[i]);
            }
            else {
                while(!stack.empty() && nums[i] <= stack.peek()) {
                    stack.pop();
                }
                if(!stack.empty()) {
                    result[i] = stack.peek();
                }
                else {
                    result[i] = -1;
                }
                stack.push(nums[i]);
            }
        }
        
        return result;
    }
}