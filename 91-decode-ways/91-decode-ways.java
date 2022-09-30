class Solution {
    public int numDecodings(String s) {
        if (s==null || s.isEmpty()) 
            return 0;
        int[] arr = new int[s.length()];
        if (s.charAt(0) == '0')
            return 0;
        arr[0] = 1;
        
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i), cp = s.charAt(i-1);
            if (c == '0') {
                if (cp != '1' && cp != '2')
                    return 0;
                if (i==1)
                    arr[i] = 1;
                else
                    arr[i] = arr[i-2];
            } else if (cp == '1') {
                arr[i] = arr[i-1]+ ((i-2)>=0?arr[i-2]:1);
            }  else if (cp == '2' && c >= '1' && c <= '6') {
                arr[i] = arr[i-1]+ ((i-2)>=0?arr[i-2]:1);
            } else {
                arr[i] = arr[i-1];
            }
        }
        return arr[s.length()-1];
    }
}