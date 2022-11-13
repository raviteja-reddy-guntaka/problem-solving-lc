class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stk = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (stk.empty() || !stk.peek().equals(s.charAt(i))) {
                stk.push(s.charAt(i));
            } else if (!stk.empty()){
                while(!stk.empty() && stk.peek().equals(s.charAt(i))) {
                    stk.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stk.empty()) {
            sb.append(stk.peek());
            stk.pop();
        }
        return sb.reverse().toString();
    }
}