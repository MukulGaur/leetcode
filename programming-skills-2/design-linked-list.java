// 707. Design Linked List

class MyLinkedList {
    
    Node head;
    int size;
    
    public class Node{
        int val;
        Node next;
        
        Node(int val){
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head=null;
        this.size=0;
    }
    
    public int get(int index) {
        if(index>=size)
            return -1;
        
        Node currNode = head;
        
        for(int i=0; i<index; i++)
            currNode = currNode.next;
        
        return currNode.val;
            
    }
    
    public void addAtHead(int val) {
        
        Node newNode = new Node(val);
        
        if(head==null){
            head = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
        
        size++;
        
    }
    
    public void addAtTail(int val) {
        
        Node newNode = new Node(val);
        
        if(head==null){
            head=newNode;
        } else{
            Node currNode = head;
            while(currNode.next!=null)
                currNode = currNode.next;

            currNode.next=newNode;
        }
        
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index>size) return;
        
        if(index==0){
            addAtHead(val);
        } else if(index==size){
            addAtTail(val);
        } else{
            
            int counter=1;
            Node temp = head;
            while(counter<index){
                temp = temp.next;
                counter++;
            }  
            
            Node next = temp.next;
            Node newNode = new Node(val);
            temp.next=newNode;
            newNode.next=next;
            size++;
            
        }
        
    }
    
    public void deleteAtIndex(int index) {
        
        if(index>size-1)
            return;
        
        if(index==0){
            head=head.next;
        } else{
            int counter=1;
            
            Node temp = head;
            
            while(counter<index){
                temp = temp.next;
                counter++;
            }
            
            temp.next = temp.next.next;
        }
        
        size--;
        
    }
}
