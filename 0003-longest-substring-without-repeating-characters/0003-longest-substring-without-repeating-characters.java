class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, ans = 0;
        Map<Character, Integer> last_index = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (last_index.get(s.charAt(i)) != null && last_index.get(s.charAt(i)) >= start) {
                start = 1 + last_index.get(s.charAt(i));
            }
            last_index.put(s.charAt(i), i);
            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}