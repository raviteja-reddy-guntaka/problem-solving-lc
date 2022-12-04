class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        Set<Character> sett = new HashSet<>();
        sett.add('a');
        sett.add('e');
        sett.add('i');
        sett.add('o');
        sett.add('u');
        sett.add('A');
        sett.add('E');
        sett.add('I');
        sett.add('O');
        sett.add('U');
        int firstCount = 0;
        int secondCount = 0;
        for (int i=0; i<n/2; i++) {
            if (sett.contains(s.charAt(i)))
                firstCount++;
            if (sett.contains(s.charAt(n/2 + i)))
                secondCount++;
            
        }
        
        if (firstCount != secondCount)
            return false;
        
        return true;
    }
}