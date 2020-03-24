package com.example.demomongodb.algorithms;

import java.util.Arrays;

/**
 * 1. Two Sum
 * <p>
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        /*int[] nums = {2, 7, 11, 15};
        int target = 9;*/
        int[] nums = {3, 2, 3};
        int target = 6;
        int[] result = test(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] test(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
