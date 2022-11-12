class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            int curr = i;
            while (curr < s.length()) {
                sb.append(s.charAt(curr));
                if (i != 0  && i != numRows-1) {
                    if ((curr + 2*numRows - 2*i - 2) < s.length())
                        sb.append(s.charAt(curr+2*numRows-2*i-2));
                }
                curr += (2*numRows - 2);
            }
        }
        return sb.toString();
    }
}