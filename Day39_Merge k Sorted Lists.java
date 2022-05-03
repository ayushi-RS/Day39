class Solution {
public ListNode mergeKLists(ListNode[] lists) {
ListNode out = new ListNode(0);
ListNode curr = out;

    for(int i = 0 ; i < lists.length ; i++){
            ListNode x = lists[i];
            
            ListNode temp = new ListNode(0);
            temp.next = x;
            
            lists[i] = temp;
            
    }
    
    boolean stop = false;
    while(!stop){
        // stop = true;
        
        ListNode min = null;
        int val = -1;
    
        
        for(ListNode x : lists){
            
            if(min == null && x.next != null){
                min = x;
                val = x.next.val;
            }
            
            if(min != null && min.next != null && x.next != null && x.next.val < val){
                min = x;
                val = x.next.val;
            }
            
        }
        
        if(min == null){
            break;
        }
        
        curr.next = min.next;
        curr = curr.next;
        
        if(min.next != null){
            min.next = min.next.next;
        }
        
        
    }
    
    
    return out.next;

}
}