class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0)
            return true;
        
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] inwards = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for (int i=0; i<prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inwards[prerequisites[i][0]]++;
        }
        
        LinkedList<Integer> traversal = new LinkedList<Integer>();
        
        
        for (int i=0; i<numCourses; i++) {
            if (inwards[i] == 0) {
                traversal.add(i);
            }
        }
        int removedEdges = 0;
        while (!traversal.isEmpty()) {
            int curr = traversal.pop();
            if (adjList.get(curr).size() > 0) {
                for (Integer neighbour : adjList.get(curr)) {
                    inwards[neighbour]--;
                    removedEdges++;
                    if (inwards[neighbour] == 0) {
                        traversal.add(neighbour);
                    }
                }
            }
        }
        
        if (removedEdges != prerequisites.length)
            return false;
        
        return true;
    }
}