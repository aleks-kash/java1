package org.example.lesson2.zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        boolean swap;

        for (int i = 0; i < n - 1; i++) {
            swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if ((nums[j] < nums[j + 1] || nums[j] > nums[j + 1]) && nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("lesson 2 HW - 3");

        Solution solution = new Solution();

        int[] array = {64, 0, 25, 0, -1, 0, 90};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\n--------------------");

        solution.moveZeroes(array);

        System.out.println("\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("\n========================================================================");

        int[] nums = {0,1,0,3,12};

        System.out.println("\nOriginal array:");

        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\n--------------------");

        solution.moveZeroes(nums);

        System.out.println("\nSorted array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
