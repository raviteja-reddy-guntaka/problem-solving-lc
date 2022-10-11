class Solution {
    public String removeDuplicates(String s, int k) {
        
        StringBuilder ans = new StringBuilder();
        Stack<Node> stk = new Stack<Node>();
        for (int i=0; i<s.length(); i++) {
            if (stk.isEmpty() || stk.peek().ch != s.charAt(i)) {
                stk.push(new Node(s.charAt(i), 1));
                ans.append(s.charAt(i));
            } else if (stk.peek().count==k-1) {
                stk.pop();
                for (int j=0; j<k-1; j++)
                    ans.deleteCharAt(ans.length()-1);
            } else {
                ans.append(s.charAt(i));
                stk.peek().count++;
            }
        }
        return ans.toString();
    }
    
    class Node {
        Character ch;
        int count;
        
        public Node(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}