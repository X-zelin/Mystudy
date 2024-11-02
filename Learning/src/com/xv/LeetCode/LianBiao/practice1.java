package com.xv.LeetCode.LianBiao;

public class practice1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode crs = new ListNode(2,head);
        ListNode precrs = crs;
        while(crs.next!=null&&crs.next.next!=null){
            if(crs.next.val == crs.next.next.val){
                int m = crs.next.val;
                while(crs.next!=null&&crs.next.val == m){
                    crs.next = crs.next.next;
                }

            }else{
                crs = crs.next;
            }
        }
        return precrs.next;

}
