class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i=0; i<dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int[] colors = new int[n+1];
        for (int i=0; i<=n; i++)
            colors[i] = -1;

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                q.add(i);
                while (!q.isEmpty()) {
                    int f = q.peek();
                    for (int j:graph.get(f)) {
                        if (colors[j] == -1) {
                            q.add(j);
                            colors[j] = (colors[f]+1)%2;
                        } else if (colors[f] == colors[j])
                            return false;
                    }
                    q.remove();
                }
            }
        }

        return true;
    }
}