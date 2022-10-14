class Solution {
    public int totalFruit(int[] fruits) {
        
        int max_c = 0, window_start = 0, window_end = 0, f_count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        
        while (window_end < fruits.length) {
            if (f_count == 2 && (m.get(fruits[window_end])==null || m.get(fruits[window_end]).equals(0))) {
                //System.out.println(fruits[window_end]);
                while(f_count == 2) {
                    m.put(fruits[window_start], m.get(fruits[window_start])-1);
                    
                    if (m.get(fruits[window_start]) == 0)
                        f_count--;
                    
                    window_start++;
                }
            }
            
            if (m.get(fruits[window_end])==null || m.get(fruits[window_end])==0) {
                m.put(fruits[window_end], 1);
                f_count++;
            } else {
                m.put(fruits[window_end], m.get(fruits[window_end])+1);
            }
            max_c = Math.max(max_c, window_end-window_start+1);
            window_end++;
        }
        return max_c;
    }
}