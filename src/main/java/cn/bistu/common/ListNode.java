package cn.bistu.common;


import java.util.List;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    /**
      * @Description: 通过Int数组创建链表
      * @Param: [list]
      * @return: cn.bistu.common.ListNode
      * @Author: Alon
      * @Date: 2022/10/14
      * @Time:
      **/

    public ListNode createList(int[] list){
        ListNode head = new ListNode(-1);
        ListNode tail = new ListNode(-1,head);
        // 尾插法创建链表
        for (int i : list) {
            ListNode node = new ListNode(i);
            tail.next.next=node;
            tail.next = node;
        }

        // 测试
        printList(head.next);
        return head.next;
    }

    public void printList(ListNode listNode){
        ListNode p = listNode;
        System.out.printf("List");
        while (p!=null){
            System.out.printf("->%d", p.val);
            p=p.next;
        }
        System.out.printf("\n");
    }
}

