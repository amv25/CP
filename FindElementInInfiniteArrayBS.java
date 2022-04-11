package com.maha;

public class FindElementInInfiniteArrayBS {

    public static void main(String[] args) {
	// write your code here
        int arr[100] = new int[];
        for(int i = 0;i < 100; i++)
        {
            arr[i] = i + 1;
        }
        int ele = 7;
        int start = 0;
        int end = 1;
        while(arr[end] < ele)
        {
            start = end;
            end = end * 2;
        }
        System.out.println(binarySearch(arr, ele, start, end));
    }
    static int binarySearch(int[] arr, int ele, int start, int end){
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(ele == arr[mid])
                return mid;
            else if(ele < arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
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
