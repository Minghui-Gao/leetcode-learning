package org.example;

public class TwoOne {
    /*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
     */

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        // If both Nodes are not null, choose the Node
        // with the lesser value and recall the function
        // in a recursive way by *decreasing* n by 1.
        // The decrease is done by recalling the function and
        // changing the parameter referring to the chosen Node
        // to its .next
        if(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                // list1's val is lesser than list2's
                // Next call I will check the lesser one between
                // its .next Node and the same list2 Node
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }
            else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        // BASE CASE    O(1)
        // At least one Node is null: return the non-null Node
        // even if that node is not the last of its chain, the
        // next nodes are already connected to it by its .next
        // method, so there is no need to continue.
        if(list1 == null)
            return list2;
        return list1;
        
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        mergeTwoLists(list1, list2);
    }
}
