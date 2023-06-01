package org.example;

public class EightyOne {
    public static boolean search(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (nums[start] < nums[mid]) {
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[start]) {
                if (nums[end] >= target && nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start += 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int nums[] = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
