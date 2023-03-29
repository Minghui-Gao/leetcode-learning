package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FortySeven {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList,int[] nums, boolean[] used) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backTrack(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 3, 1}));

    }
}
