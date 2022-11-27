class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] result = new boolean[nums.length];
        result[0] = true;
        
        for (int i=0; i<nums.length-1 && !result[nums.length-1]; i++) {
            if (result[i]) {
                for (int j=1; j<=nums[i] && i+j<nums.length; j++) {
                    result[i+j] = true;
                }
            } else {
                return false;
            }
        }
        
        return result[nums.length-1];
    }
}