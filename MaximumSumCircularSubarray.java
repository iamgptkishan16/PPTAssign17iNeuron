/*
💡 **Question 2**

Given a **circular integer array** `nums` of length `n`, return *the maximum possible sum of a non-empty **subarray** of* `nums`.

A **circular array** means the end of the array connects to the beginning of the array. Formally, the next element of `nums[i]` is `nums[(i + 1) % n]` and the previous element of `nums[i]` is `nums[(i - 1 + n) % n]`.

A **subarray** may only include each element of the fixed buffer `nums` at most once. Formally, for a subarray `nums[i], nums[i + 1], ..., nums[j]`, there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % n`.

**Example 1:**
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.


*/

package Java_DSA.Queues.Assingment17;
public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int[] nums = {5, -3, 4, -1, 2, 6, -2};
        int maxSum = maxSubarraySumCircular(nums);
        System.out.println("Maximum sum of a non-empty circular subarray: " + maxSum);
    }
    
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;
        
        // Find the maximum sum subarray using Kadane's algorithm
        for (int num : nums) {
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);
            
            totalSum += num;
        }
        
        // If the array contains all negative numbers, return the maximum element
        if (maxSum < 0) {
            return maxSum;
        }
        
        // Find the maximum sum subarray with wrapping using totalSum - minSum
        int circularMaxSum = totalSum - minSum;
        
        // Return the maximum between the non-circular and circular max sum
        return Math.max(maxSum, circularMaxSum);
    }
}

