package com.self.training.algorithm.array;

/**
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(solutionBruteForce(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solutionBruteForce(new int[]{1}));
        System.out.println(solutionBruteForce(new int[]{5, 4, -1, 7, 8}));

        System.out.println(solutionBruteForceReuse(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solutionBruteForceReuse(new int[]{1}));
        System.out.println(solutionBruteForceReuse(new int[]{5, 4, -1, 7, 8}));

        System.out.println(solutionDivideAndConquer(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solutionDivideAndConquer(new int[]{1}));
        System.out.println(solutionDivideAndConquer(new int[]{5, 4, -1, 7, 8}));

        System.out.println(solutionLinearTimeConsumingAlgorithm(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solutionLinearTimeConsumingAlgorithm(new int[]{1}));
        System.out.println(solutionLinearTimeConsumingAlgorithm(new int[]{5, 4, -1, 7, 8}));

    }


    public static int solutionBruteForce(int array[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            for (int j = i + 1; j < array.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int solutionBruteForceReuse(int array[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * function findMaxSubArray(A, low, high)
     * if low = high then
     * return (low,high,A[low]);
     * else
     * mid = (low +high)/2
     * L = findMaxSubArray(A, low, mid);
     * R = findMaxSubArray(A, mid + 1, high);
     * C = findMaxCrossing(A, low, mid, high) -- maximum sub array that contains the midpoint
     * if L.maxSum >= R.maxSum  and L.maxSum >= C.maxSum  then
     * return L;
     * else if R.maxSum >= L.maxSum and R.maxSum >= C.maxSum then
     * return R;
     * else
     * return C;
     * <p>
     * findMaxCrossing(A, low, mid, mid, right)
     * maxCLeft = MIN;
     * maxCRight = MIN;
     * sumLeft = 0;
     * sumRight = 0;
     * for i = mid down to low do
     * sumLeft += A[i]
     * maxCLeft = max(maxCLeft, sumLeft)
     * for i = mid +1 upto right do
     * sumRight += A[i]
     * maxCRight = max(maxCRight, sumRight)
     * return maxCLeft + maxCRight;
     */
    public static int solutionDivideAndConquer(int array[]) {

        return maximumSubArrayRecursively(array, 0, array.length - 1);

    }

    private static int maximumSubArrayRecursively(int[] A, int l, int r) {

        if (l == r) {
            return A[l];
        }
        int mid = (l + r) / 2;
        int maxLeft = maximumSubArrayRecursively(A, l, mid);
        int maxRight = maximumSubArrayRecursively(A, mid + 1, r);
        int maxCross = maximumSubArrayCrossing(A, l, r, mid);
        return Math.max(Math.max(maxLeft, maxRight), maxCross);
    }

    private static int maximumSubArrayCrossing(int[] A, int l, int r, int m) {

        int maxCLeft = Integer.MIN_VALUE;
        int maxCRight = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = m; i >= l; i--) {
            sum += A[i];
            maxCLeft = Math.max(maxCLeft, sum);
        }
        sum = 0;
        for (int i = m + 1; i <= r; i++) {
            sum += A[i];
            maxCRight = Math.max(maxCRight, sum);
        }

        return maxCLeft + maxCRight;

    }

    /**
     * Kadance algorithm
     * <p>
     * Thinking about the maximum ending by each index
     */
    public static int solutionLinearTimeConsumingAlgorithm(int array[]) {

        int max = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = 0; i < array.length; i ++) {
            sum += array[i];
            if(sum < array[i]) {
                sum = array[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
