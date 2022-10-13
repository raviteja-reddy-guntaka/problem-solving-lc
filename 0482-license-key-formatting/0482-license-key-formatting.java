class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        s = s.toUpperCase();
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '-')
                continue;
            
            sb.append(s.charAt(i));
            if (sb.length() == k) {
                stk.push(sb.reverse().toString());
                sb.setLength(0);
            }
        }
        if (!sb.isEmpty()) {
            stk.push(sb.reverse().toString());
        }
        sb.setLength(0);
        
        while (!stk.isEmpty()) {
            sb.append(stk.peek());
            sb.append("-");
            stk.pop();
        }
        if (!sb.isEmpty())
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}