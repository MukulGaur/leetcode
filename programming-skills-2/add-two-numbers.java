// 2. Add Two Numbers

class Solution {
    public ListNode add(ListNode l1, ListNode l2) {
        
        int carry=0;
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        
        while(l1!=null && l2!=null){
            int sum=carry+l1.val+l2.val;
            carry = sum/10;
            int digit = sum%10;
            res.next = new ListNode(digit);
            res=res.next;
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
            int sum = carry + l1.val;
            carry=sum/10;
            int digit = sum%10;
            res.next = new ListNode(digit);
            res=res.next;
            l1=l1.next;
        }
        
        while(l2!=null){
            int sum = carry + l2.val;
            carry=sum/10;
            int digit = sum%10;
            res.next = new ListNode(digit);
            res=res.next;
            l2=l2.next;
        }
        
        while(carry!=0){
            int sum = carry;
            carry=sum/10;
            int digit = sum%10;
            res.next = new ListNode(digit);
            res=res.next;
        }
        
        return dummy.next;
        
    }
    
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode ans = add(first, second);
        return ans;
    }
}
