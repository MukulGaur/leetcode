// 445. Add Two Numbers II

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int s1 = size(l1), s2 = size(l2);
        
        ListNode resHead=null, n=null;
        
        while(l1!=null || l2!=null){
            int v1=0, v2=0;
            
            if(s1>=s2){
                v1 = l1!=null ? l1.val : 0;
                l1=l1.next;
                s1--;
            }
            
            if(s2>=s1+1){
                v2 = l2!=null ? l2.val : 0;
                l2=l2.next;
                s2--;
            }
            
            n = new ListNode(v1+v2);
            n.next = resHead;
            resHead=n;
        }
        
        int carry=0;
        resHead=null;
        
        while(n!=null){
            n.val += carry;
            if(n.val >= 10){
                n.val %= 10;
                carry=1;
            } else
                carry=0;
            
            ListNode buf = n.next;
            n.next=resHead;
            resHead=n;
            n=buf;
        }
        
        if(carry>0){
            n = new ListNode(1);
            n.next=resHead;
            resHead=n;
        }
        
        return resHead;
        
    }
    
    private int size(ListNode node){
        int s=0;
        while(node!=null){
            node=node.next;
            s++;
        }
        return s;
    }
}
