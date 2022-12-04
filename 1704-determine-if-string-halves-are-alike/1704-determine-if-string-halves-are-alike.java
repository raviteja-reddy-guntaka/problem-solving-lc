class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        for (int i=0; i<n/2; i++) {
            if (first.get(s.charAt(i)) == null)
                first.put(s.charAt(i), 0);
            first.put(s.charAt(i), 1 + first.get(s.charAt(i)));
            if (second.get(s.charAt(n/2 + i)) == null)
                second.put(s.charAt(n/2 + i), 0);
            second.put(s.charAt(n/2 + i), 1 + second.get(s.charAt(n/2 + i)));
        }
        int firstCount = first.getOrDefault('a', 0) + first.getOrDefault('e', 0) + 
            first.getOrDefault('i', 0) + first.getOrDefault('o', 0) + first.getOrDefault('u', 0) +
            first.getOrDefault('A', 0) + first.getOrDefault('E', 0) + first.getOrDefault('I', 0) +
            first.getOrDefault('O', 0) + first.getOrDefault('U', 0);
        
        int secondCount = second.getOrDefault('a', 0) + second.getOrDefault('e', 0) + 
            second.getOrDefault('i', 0) + second.getOrDefault('o', 0) + second.getOrDefault('u', 0) +
            second.getOrDefault('A', 0) + second.getOrDefault('E', 0) + second.getOrDefault('I', 0) +
            second.getOrDefault('O', 0) + second.getOrDefault('U', 0);
        
        if (firstCount != secondCount)
            return false;
        
        return true;
    }
}