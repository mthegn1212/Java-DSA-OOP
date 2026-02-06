package algorithms.maximum_subarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum = currentSum + nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println("Ket qua mong doi: 6");
        System.out.println("Ket qua thuc te: " + solver.maxSubArray(nums));
    }
}