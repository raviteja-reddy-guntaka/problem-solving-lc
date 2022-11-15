class Solution {
    public int minimumOperations(int[] nums) {
        
        Set<Integer> distinct = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0)
                distinct.add(nums[i]);
        }
        
        return distinct.size();
    }
}