class MinStackNode {
    int val;
    int min;
    MinStackNode next;
    public MinStackNode(int val, int min, MinStackNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

class MinStack {

    MinStackNode head;
    
    public void push(int val) {
        if (head == null)
            head = new MinStackNode(val, val, null);
        else
            head = new MinStackNode(val, Math.min(head.min, val), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */