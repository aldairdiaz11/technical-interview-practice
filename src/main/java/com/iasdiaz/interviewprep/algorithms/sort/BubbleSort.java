package com.iasdiaz.interviewprep.algorithms.sort;

public class BubbleSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        boolean swapping = true;
        while (swapping) {
            swapping = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapping = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
