package com.iasdiaz.interviewprep.problems.two_pointers;

public class RainWater {

    public static int solve(int[] heights) {

        if (heights == null || heights.length == 0) return 0;

        int totalWater = 0;
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (heights[left] <=  heights[right]) {
                leftMax = Math.max(heights[left], leftMax);
                totalWater += (leftMax - heights[left]);
                left++;
            } else  {
                rightMax = Math.max(heights[right], rightMax);
                totalWater += (rightMax - heights[right]);
                right--;
            }
        }

        return totalWater;
    }
}
