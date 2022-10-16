package cn.bistu.qus.List;

import cn.bistu.common.ListNode;

public class deleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head){
        // 快慢指针
        if(head.next==null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        // 快指针遍历
        while (fast.next!=null){
            fast=fast.next;
            // 快指针寻找下个新值
            while (slow.val==fast.val){
                // 若没有找到
                if(fast.next==null) {
                    slow.next = null;
                    return head;
                }
                fast=fast.next;
            }
            slow.next=fast;
            slow=slow.next;
        }
        slow.next=null;
        return head;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode();
        int[] num = {1,1,2,3,3,3,3,3,3};
        node = node.createList(num);

        deleteDuplicates_83 soluiton = new deleteDuplicates_83();
        node = soluiton.deleteDuplicates(node);

        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }


    }
}
