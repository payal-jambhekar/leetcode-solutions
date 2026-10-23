class MyLinkedList {
    Node head;
    Node tail;
    class Node{
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    public int get(int index) {

        if( head == null || index < 0) return -1;

        Node curr = head;
        for(int i =0; i < index; i++){
            curr = curr.next;
            if(curr == null){
                return -1;
            }
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
    
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void addAtIndex(int index, int val) {

        if(index == 0){
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node curr = head;
        for(int i =0; i< index ; i++){
            curr = curr.next;
        }
        if(curr == null){
            addAtTail(val);
            return;
        }
        newNode.prev = curr.prev;
        newNode.next = curr;
        curr.prev.next = newNode;
        curr.prev = newNode;

    }
    
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) {
        return;
    }
        
        Node curr = head;

        if(index == 0){
            head = curr.next;

            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }
            return;
        }

        for(int i =0; i < index; i++){
            curr = curr.next;
            if(curr == null){
                return;
            }
        }
        if (curr == tail) {
            tail = curr.prev;

            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
                }

            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */