class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generateParenthesis(ans, "", 0, 0, n);
        
        return ans;
    }
    
    private void generateParenthesis(List<String> ans, String curr, int open, int close, int n) {
        if (open>n || close>n || open<close)
            return;
        
        if (open+close == 2*n) {
            ans.add(curr);
            return;
        }
        
        generateParenthesis(ans, curr + "(", 1+open, close, n);
        generateParenthesis(ans, curr + ")", open, 1+close, n);
    }
}