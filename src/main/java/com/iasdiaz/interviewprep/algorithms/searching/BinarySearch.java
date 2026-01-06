package com.iasdiaz.interviewprep.algorithms.searching;

public class BinarySearch {

    public static int search(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr[mid];

            if (target == midValue) {
                return mid;
            } else if (target > midValue) {
                left = mid + 1;
            }  else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
