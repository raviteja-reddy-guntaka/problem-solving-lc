class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> m = new HashMap<>();
        for (String e : emails) {
            StringBuilder sb = new StringBuilder();
            int c = 0;
            while(e.charAt(c) != '@' && e.charAt(c) != '+') {
                if (e.charAt(c) != '.')
                    sb.append(e.charAt(c));
                c++;
            }
            while(e.charAt(c) != '@') {
                c++;
            }
            sb.append('@');
            c++;
            while(c<e.length()) {
                sb.append(e.charAt(c));
                c++;
            }
            m.put(sb.toString(), 1);
        }
        return m.keySet().size();
    }
}