class Solution {
    public int[] productExceptSelf(int[] nums) { 
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] ans = new int[nums.length];
        int prefixProduct = 1;
        int postfixProduct = 1;
        for (int i = 0; i < prefix.length; i++) {
            if (i == 0) {
                prefixProduct = nums[i];
                prefix[i] = prefixProduct;
                continue;
            }
            prefixProduct = prefixProduct * nums[i];
            prefix[i] = prefixProduct;
        }
        for (int i = postfix.length - 1; i > -1; i--) {
            if (i == 0) {
               postfixProduct = nums[i];
               postfix[i] = postfixProduct;
               continue;
            }
            postfixProduct = postfixProduct * nums[i];
            postfix[i] = postfixProduct;
        }
        for (int i = 0; i < ans.length; i++) {
           if (i == 0) ans[i] = postfix[i + 1];
           else if (i == ans.length - 1) ans[i] = prefix[i - 1];
           else ans[i] = prefix[i - 1] * postfix[i + 1];
        }
        return ans;
    }
}