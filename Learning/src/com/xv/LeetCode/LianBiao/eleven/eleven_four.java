package com.xv.LeetCode.LianBiao.eleven;

public class eleven_four {
    //measure 1/leetcode 206
    static class NodeList{
        NodeList next;
        int val;
        public NodeList(int val,NodeList next){
            this.val = val;
            this.next = next;
        }
    }
    public static NodeList reverselist(NodeList n){
        NodeList n1 = null;
        NodeList p = n;
        while(p!=null){
            n1 = new NodeList(p.val,n1);
            p = p.next;
        }
        return n1;
    }
    public static void main(String[] args){

        NodeList o5 = new NodeList(5,null);
        NodeList o4 = new NodeList(4,o5);
        NodeList o3 = new NodeList(3,o4);
        NodeList o2 = new NodeList(2,o3);
        NodeList o1 = new NodeList(1,o2);
        System.out.println(o1);
        System.out.println(reverselist(o1));
    }
    //measuer 2(factorial)

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode p1 = new ListNode(-1,head);
        ListNode p2 = head;
        while(p2 !=null){
            if(p2.val == val){
                p1.next = p2.next;
                p2 = p2.next;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }

        }
        return head;
    }

    public static int recursion(ListNode p,int n){
        if(p == null){
            return 0;
        }
        int nth = recursion(p.next,n);
        if(nth == n){
            p.next = p.next.next;
        }
        return nth+1;
    }
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next!=null&&p2!=null){
            p2 = p2.next.next;
            p1 = p1.next;
        }
        return p1;

    }
    public boolean isPalindrome(ListNode head) {
        ListNode middle = Middle(head);
        ListNode newhead = reversion(middle);
        while(newhead !=null){
            if(newhead.val != head.val){
                return false;
            }
            newhead = newhead.next;
            head = head.next;
        }
        return true;


    }
    public ListNode Middle(ListNode p){
        ListNode p1 = p;
        ListNode p2 = p;
        while(p2!=null&&p2.next!=null){
            p2 = p2.next.next;
            p1 = p1.next;
        }
        return p1;
    }
    public ListNode reversion(ListNode head){
        ListNode n1 = null;
        while(head !=null){
            ListNode l = head.next;
            head.next = n1;
            n1 = head ;
            head = l;
        }
        return n1;
    }
}



