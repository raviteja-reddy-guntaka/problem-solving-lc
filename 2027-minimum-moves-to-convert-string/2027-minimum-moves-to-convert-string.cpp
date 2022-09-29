class Solution {
public:
    int minimumMoves(string s) {
        
        int l = s.length(), curr = 0, count = 0;
        while(curr<l) {
            if (s[curr] == 'X') {
                count++;
                curr += 2;
            }
            curr++;
        }
        
        return count;
    }
};