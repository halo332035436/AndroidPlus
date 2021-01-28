package com.example.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySolution {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        //暴力遍历三遍
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int h = j + 1; h < nums.length; h++) {
                    if (nums[i] + nums[j] + nums[h] == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[h]);
                        list.add(integers);
                    }
                }
            }
        }*/

        Arrays.sort(nums);
        if (nums.length < 3) return list;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    list.add(integers);
                    k--;
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;

    }

}
