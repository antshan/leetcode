/**
 * 21 Merge Two Sorted Lists 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {

    //1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(0);
        ListNode curr= dumpy;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1= l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2= l2.next;
            }
            curr= curr.next;
        }
        if (l1!=null){
            curr.next= l1;
        }else {
            curr.next= l2;
        }
        return dumpy.next;

    }

    //2s
    public ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<l2.val){
            l1.next= mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next= mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }
}
