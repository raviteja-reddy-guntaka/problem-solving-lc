class MyCalendarThree {
    
    private Node head;

    public MyCalendarThree() {
        this.head = null;
    }
    
    public int book(int start, int end) {
        Node s = new Node(start, 1);
        Node e = new Node(end, -1);
        
        insert(s);
        insert(e);
        return max_k(start, end);
    }
    
    void insert(Node n) {
        if (this.head == null) {
            this.head = n;
            return;
        }
        
        Node p = this.head, prev = this.head;
        while(p!=null) {
            if (p.pos<=n.pos) {
                prev = p;
                p = p.next;
            } else if (p == this.head) {
                n.next = this.head;
                this.head = n;
                break;
            } else {
                prev.next = n;
                n.next = p;
                break;
            }
        }
        if (p == null) {
            prev.next = n;
        }
    }
    
    int max_k(int s, int e) {
        //System.out.println(this.head.pos);
        int max_so_far = 0, curr = 0;
        Node k = this.head;
        while(k!=null) {
            curr += k.val;
            if (k.next==null || k.next.pos != k.pos)
                max_so_far = Math.max(max_so_far, curr);
            k = k.next;
        }
        return max_so_far;
    }
    
    class Node {
        int pos;
        int val;
        Node next;
        
        public Node() {}
        
        public Node(int pos, int val) {
            this.pos = pos;
            this.val = val;
            this.next = null;
        }
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */