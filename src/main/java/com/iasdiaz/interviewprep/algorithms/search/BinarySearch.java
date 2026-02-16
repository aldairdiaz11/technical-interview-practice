package com.iasdiaz.interviewprep.algorithms.search;

public class BinarySearch {

    public static <T extends Comparable<T>> int search(T[] arr, T target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = target.compareTo(arr[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                right = mid - 1;
            }  else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
