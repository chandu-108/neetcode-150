class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] skipLastHouse = new int[n - 1];
        int[] skipFirstHouse = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i + 1];
        }

        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int lootSkippingLast = func(0, skipLastHouse, dp1);
        int lootSkippingFirst = func(0, skipFirstHouse, dp2);

        return Math.max(lootSkippingLast, lootSkippingFirst);
    }

    public int func(int i, int[] nums, int[] dp) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + func(i + 2, nums, dp);

        int notTake = func(i + 1, nums, dp);

        return dp[i] = Math.max(take, notTake);
    }
}