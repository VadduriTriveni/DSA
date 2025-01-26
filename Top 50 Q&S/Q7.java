238. Product of Array Except Self
===========================================================================================
 class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix; // Store the prefix product in result
            prefix *= nums[i];   // Update the prefix product
        }

        // Step 2: Calculate suffix products and multiply with prefix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix; // Multiply with the suffix product
            suffix *= nums[i];    // Update the suffix product
        }

        return result;
    }
}
