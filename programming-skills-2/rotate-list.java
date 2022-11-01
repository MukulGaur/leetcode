// 61. Rotate Listclass Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        
        int count=0;
        
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        
        k=k%count;
        
        if(k==0) return head;
        
        ListNode cycledNode = new ListNode();
        count -= k;
        
        temp=head;
        
        while(count>1){
            temp=temp.next;
            count--;
        }
        
        cycledNode = temp.next;
        temp.next=null;
        temp=cycledNode;
        
        while(temp.next!=null)
            temp=temp.next;
        
        temp.next=head;
        
        return cycledNode;
        
    }
}
