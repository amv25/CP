public class FindElementInInfiniteArrayBS {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int target = 7;
        int start = 0;
        int end = 1;

        long startTime = System.nanoTime();
        
        while(arr[end] < target) {
            start = end;
            end = end * 2;
        }
        int ans = binarySearch(arr, target, start, end);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println(ans);

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(target > arr[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

/*
*  Find the pos of X in an infinite sorted arr
*  0 1 2 3 4 5 6 7 8 9
*  1 2 3 4 5 6 7 8 9 10 ..........
* 1st :
* start = 0;
* end = 1;
*
* 2nd :
* start = 1;
* end = 1 * 2 = 2;
*
* 3rd :
* start = 2
* end = 4
*
* 4th
* start = 4
* end = 8
*
*  start = 0;
*  end = 1 * 2;
*
*  ele = 7
*  6
*
* */
