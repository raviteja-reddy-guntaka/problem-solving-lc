class Solution {
    public int kthGrammar(int n, int k) {
        return recursive(n-1, k-1);
    }
    
    private int recursive(int level, int k) {
        if (level == 0)
            return 0;
        
        if (level == 1) {
            return k;
        }
        
        int previous = recursive(level-1, k/2);
        if (previous == 0) {
            if (k%2==0)
                return 0;
            return 1;
        }
        
        if (k%2 == 0)
            return 1;
        return 0;
    }
}