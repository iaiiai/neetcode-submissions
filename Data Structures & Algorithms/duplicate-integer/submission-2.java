class Solution {
    public boolean hasDuplicate(int[] nums) {
        int index = 0;
        Arrays.sort(nums);
        for (int offset = index + 1; offset < nums.length; offset++) {
            if (nums[index] == nums[offset]) return true;
            index++;
        }
        return false;
    }
}