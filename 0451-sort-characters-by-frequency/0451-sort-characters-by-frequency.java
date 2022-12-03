class Solution {
    public String frequencySort(String s) {
        
        Map<Character, CharCount> counter = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            if (counter.get(s.charAt(i)) == null) {
                counter.put(s.charAt(i), new CharCount(s.charAt(i), 0));
            }
            counter.get(s.charAt(i)).count++;
        }
        
        List<CharCount> sorted = new ArrayList<>(counter.values());
        Collections.sort(sorted, new Comparator<CharCount>() {
            public int compare(CharCount a, CharCount b) {
                if (a.count < b.count)
                    return 1;
                return -1;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<sorted.size(); i++) {
            for (int j=0; j<sorted.get(i).count; j++) {
                sb.append(sorted.get(i).ch);
            }
        }
        
        return sb.toString();
    }
    
    class CharCount {
        char ch;
        int count;
        
        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}