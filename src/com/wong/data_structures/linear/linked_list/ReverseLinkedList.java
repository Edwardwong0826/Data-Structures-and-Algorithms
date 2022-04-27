package com.wong.data_structures.linear.linked_list;

class ReverseLinkedlist {
    public ListNode listNode;

    public ListNode reverseList(ListNode head) {
        // iterative solution

        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main (String[] args)
    {

        ReverseLinkedlist reverse = new ReverseLinkedlist();

        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        reverse.listNode = node1;

        System.out.println(reverse.reverseList(node1).toString());

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                "next" + next +
                '}';
    }
}
