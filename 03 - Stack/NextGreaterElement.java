import java.util.*;

class NextGreaterElement {
    public static void main(String[] args) {
        long[] que = new long[]{1, 3, 2, 4};
        int n = que.length;

        long startTime = System.nanoTime();
        
        //long[] ans = nextGreaterElementBF(que, n);
        long[] ans = nextGreaterElement(que, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(Arrays.toString(ans));

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static long[] nextGreaterElementBF(long[] nums, int n) {
        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            long temp = -1;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] > nums[i]) {
                    temp = nums[j];
                    break;
                }
            }
            ans[i] = temp;
        }

        return ans;
    }

    static long[] nextGreaterElement(long[] nums, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            if(stack.empty()) {
                result[i] = -1;
                stack.push(nums[i]);
            }
            else {
                while(!stack.empty() && nums[i] >= stack.peek()) {
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