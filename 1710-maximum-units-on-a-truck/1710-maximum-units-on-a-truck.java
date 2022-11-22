class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1])
                    return -1;
                return 1;
            }
        });
        
        int remaining = truckSize, units = 0;
        int i = 0;
        while (i<boxTypes.length && remaining > 0) {
            int curr = Math.min(remaining, boxTypes[i][0]);
            units += curr*boxTypes[i][1];
            remaining -= curr;
            i++;
        }
        
        return units;
    }
}