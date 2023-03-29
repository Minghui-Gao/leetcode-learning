package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backTracing(nums, 0);

        HashSet<List<Integer>> result = new HashSet<>(res);
        res = new ArrayList<>(result);
        return res;
    }

    public static void backTracing(int[] nums, int start){
        // 每更新一次list  都加入结果集  首次进来加的是空集
        res.add(new ArrayList<>(list));
        // 到数组末尾结束当前递归
        if(start == nums.length){
            return;
        }
        for(int i = start; i < nums.length; i++){
            // 将当前数加入list
            list.add(nums[i]);
            // 递归 不能重复使用当前数 因此下一轮从i+1开始
            backTracing(nums, i+1);
            // 回溯 回退刚刚加的数
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {

        int[] nums = {1,2,2};

        subsets(nums);

        System.out.println(res);

    }
}