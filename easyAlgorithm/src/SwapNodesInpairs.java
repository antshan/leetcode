/**
 * 24 链表中数位置的交换
 */
public class SwapNodesInpairs {

    public ListNode swapPairs(ListNode head) {

        if (head==null || head.next==null){
            return head;
        }
        ListNode dumpy= new ListNode(0);
        dumpy.next= head;
        ListNode l1= dumpy;
        ListNode l2= head;
        while (l2!=null && l2.next!=null){
            ListNode nextStart= l2.next.next;
            l1.next= l2.next;
            l2.next.next= l2;
            l2.next= nextStart;
            l1=l2;
            l2=l2.next;
        }

        return dumpy.next;
    }
}
