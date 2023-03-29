package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FortySix {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList,int[] nums) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backTrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 5, 9}));

    }
}
