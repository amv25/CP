//Trapping Rain Water - GFG
//Link - https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;

        long startTime = System.nanoTime();

        long area = trappingWater(arr, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(area);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static long trappingWater(int[] arr, int n) {
        int area = 0;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];

        leftMax(arr, leftArr, rightArr, n);

        for (int i = 0; i < n; i++) {
            int temp = Math.min(leftArr[i], rightArr[i]) - arr[i];
            if(temp > 0) {
                area += temp;
            }
        }

        return area;
    }

    static void leftMax(int[] arr, int[] leftArr, int[] rightArr, int n){
        int maxright = 0;
        int maxleft = 0;

        for(int i = 0; i < n; i++) {
            if(maxleft < arr[i]) {
                leftArr[i] = maxleft;
                maxleft = arr[i];
            }
            else {
                leftArr[i] = maxleft;
            }
            if(maxright < arr[n - i - 1]) {
                rightArr[n - i - 1] = maxright;
                maxright = arr[n - i - 1];
            }
            else {
                rightArr[n - i - 1] = maxright;
            }
        }
    }
}

/*
* arr  :0 1 0 2 1 0 1 3 2 1 2 1
* l    :0 0 1 1 2 2 2 2 3 3 3 3
* r    :3 3 3 3 3 3 3 2 2 2 1 0
*
* min(left, right) - n
* area :0 0 1 0 1 2 1 0 0 1 0 0 => 6
*/