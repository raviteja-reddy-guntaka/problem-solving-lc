class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stk = new Stack<>();
        int max_l = 0;
        stk.push(-1);
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if(stk.isEmpty()) {
                    stk.push(i);
                } else {
                    max_l = Math.max(max_l, i-stk.peek());
                }
            }
        }
        
        return max_l;
    }
}