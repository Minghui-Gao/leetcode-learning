package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NineTwo {

    /*
    Given the head of a singly linked list and two integers left and right where left <= right,
    reverse the nodes of the list from position left to position right, and return the reversed list.

    创建一个队列存储不需要改变顺序的值，一个栈存储需要改变顺序的值。创建一个ListNode result和一个ListNode temp,
    改变temp的顺序通过获取stack的值改变，无需改变就获取队列的值，然后期间将temp作为 next给result
     */

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        Queue<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();
        int leftCounter=1;
        ListNode root = head;
        while (root!=null){
            if(leftCounter<left){
                queue.add(root);
            } else if (left<=leftCounter && leftCounter<=right) {
                stack.add(root);
            }else {
                queue.add(root);
            }
            leftCounter++;
            root=root.next;
        }
        ListNode result;
        ListNode temp;
        if(left==1){
            result=stack.pop();
            temp=result;
            while(!stack.isEmpty()){
                temp.next=stack.pop();
                temp=temp.next;
            }
            while (!queue.isEmpty()){
                temp.next=queue.poll();
                temp=temp.next;
            }
        }else {
            int counter=2;
            result=queue.poll();
            temp=result;
            while (counter<left){
                temp.next=queue.poll();
                temp=temp.next;
                counter++;
            }
            while (!stack.isEmpty()){
                temp.next=stack.pop();
                temp=temp.next;
            }
            while (!queue.isEmpty()){
                temp.next=queue.poll();
                temp=temp.next;
            }

        }
        temp.next=null;
        return result;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int left = 2;
        int right = 4;
        reverseBetween(head, left, right);
    }
}
