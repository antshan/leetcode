import java.util.PriorityQueue;

/**
 * 23 合并K个有序的链表
 */
public class MergeKSortedLists {

    //1
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> priorityQueue= new PriorityQueue<>(lists.length,(a,b)->a.val-b.val);
        ListNode dumpy= new ListNode(0);
        ListNode curr= dumpy;

        for (ListNode listNode:lists){
            if (listNode!=null){
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()){
            curr.next= priorityQueue.poll();
            curr= curr.next;
            if (curr.next != null){
                priorityQueue.add(curr.next);
            }
        }

        return dumpy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists){

        if (lists==null || lists.length==0) return null;
        return sort(lists,0,lists.length-1);
    }

    public ListNode sort(ListNode[] lists,int lo,int hi){
        if (lo>=hi) return lists[lo];
        int mid = (hi-lo)/2+lo;
        ListNode l1 = sort(lists,lo,mid);
        ListNode l2 = sort(lists,mid+1,hi);
        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<l2.val){
            l1.next= merge(l1.next,l2);
            return l1;
        }
        l2.next= merge(l1,l2.next);
        return l2;
    }

    public static void main(String[] args){
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode list1= new ListNode(1);
        ListNode list2= new ListNode(4);
        ListNode list3= new ListNode(5);

        list1.next=list2;
        list2.next=list3;

        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(3);
        ListNode l3= new ListNode(4);
        l1.next= l2;
        l2.next= l3;

        ListNode l11= new ListNode(2);
        ListNode l12= new ListNode(6);
        l11.next=l12;

        ListNode[] lists= {l1,list1,l11};
        ListNode listNode = mergeKSortedLists.mergeKLists(lists);
        System.out.println(listNode);


    }



}
