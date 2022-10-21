class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> store = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            if (store.get(nums[i]) != null) {
                if (i-store.get(nums[i]) <= k)
                    return true;
                store.put(nums[i], i);
            } else {
                store.put(nums[i], i);
            }
        }
        
        // for (int i=0; i<nums.length; i++) {
        //     for (int j=i+1; j<=i+k && j<nums.length; j++) {
        //         if (nums[i] == nums[j])
        //             return true;
        //     }
        // }
        
        return false;
    }
}