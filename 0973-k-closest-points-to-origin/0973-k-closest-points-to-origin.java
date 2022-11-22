class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>(k, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                if (n1.d > n2.d)
                    return -1;
                return 1;
            }
        });
        
        for (int i=0; i<k; i++) {
            pq.add(new Node(points[i][0], points[i][1], getDistance(points[i][0], points[i][1])));
        }
        
        for (int i=k; i<points.length; i++) {
            int d = getDistance(points[i][0], points[i][1]);
            if (pq.peek().d > d) {
                pq.poll();
                pq.add(new Node(points[i][0], points[i][1], d));
            }
        }
        
        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            result[i][0] = pq.peek().x;
            result[i][1] = pq.peek().y;
            pq.poll();
        }
        
        return result;
    }
    
    private int getDistance(int x, int y) {
        return x*x + y*y;
    }
    
    class Node {
        int x;
        int y;
        int d;
        
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}