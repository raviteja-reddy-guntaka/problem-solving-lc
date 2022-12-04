class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        
        if (word1.length() < 1)
            return true;
        
        int[] alph1 = new int[26];
        int[] alph2 = new int[26];
        
        for (int i=0; i<word1.length(); i++) {
            alph1[word1.charAt(i) - 'a']++;
            alph2[word2.charAt(i) - 'a']++;
        }
        for (int i=0; i<26; i++) {
            if ((alph1[i] != 0 && alph2[i] == 0) || (alph1[i] == 0 && alph2[i] != 0))
                return false;
        }
        Arrays.sort(alph1);
        Arrays.sort(alph2);
        for (int i=0; i<26; i++) {
            if (alph1[i] != alph2[i])
                return false;
        }
        return true;
    }
}