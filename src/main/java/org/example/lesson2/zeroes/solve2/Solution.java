package org.example.lesson2.zeroes.solve2;

import java.util.Arrays;

class Solution {

    public void moveZeroes(int[] nums) {
        int count = 0;
        while (count < nums.length) {
            for (int i = 0; i < nums.length - 1; i++) {
                int current = nums[i];
                int next = nums[i + 1];

                if(current == 0 && next == 0) {
                    continue;
                }

                if(current == 0) {
                    nums[i] = next;
                    nums[i + 1] = current;
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[] { 0, 1, 0, 3, 12 };

        System.out.println(Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));   // Output: [1,3,12,0,0]

        int[] nums1 = new int[] { 0 };               // Output: [0]
        System.out.println(Arrays.toString(nums1));
        sol.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }

}
