package cn.bistu.qus.List;


import cn.bistu.common.ListNode;

import java.util.ArrayList;
import java.util.List;

class mid_listnode_876 {
    /**
      * @Description: 找到给定链表的中间节点
      * @Param: [head]
      * @return: com_github_leetcode.ListNode
      * @Author: Alon
      * @Date: 2022/10/14
      * @Time:
      **/
    public ListNode middleNode(ListNode head) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1,head);
        // 定义快慢节点
        ListNode p = new ListNode(-1,dummy);
        ListNode q =new ListNode(-1,dummy);
        while (p.next!=null){
            p=p.next;
            //防止两步走过
            if (p.next!=null) {
                p=p.next;
            }
            q=q.next;
        }

        return q.next;
    }



    public static void main(String[] args) {
        ListNode test = new ListNode();
        int[] data={1,2,3,4,5,6};
        ListNode head = test.createList(data);
        mid_listnode_876 mid_listnode_876 = new mid_listnode_876();
        System.out.printf("%d", mid_listnode_876.middleNode(head).val);
    }
}
