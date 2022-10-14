package cn.bistu.qus.List;

import cn.bistu.common.ListNode;

public class getIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode dummy = new ListNode(-1,headA);
        // AB链接
        ListNode tail = dummy;
        // 找到最后一个节点
        while(tail.next!=null) tail=tail.next;
        tail.next= headB;
        // System.out.println(tail.next.next.val);
        //看成有环链表,快慢指针寻找相交位置

        ListNode p = dummy;
        ListNode q = dummy;
        while(p.next!=null){
            p=p.next;
            if(p.next!=null)
                p=p.next;
            q=q.next;

            // 有环，找相交位置
            // 这里注意找到相交节点时仅仅找到了环的长度，也就是说p走了2k步，比q快k步
            // 需要让q回到开头，两者同速前进，再次碰头既是相交节点
            if(p == q){
                q=dummy;

                while(p!=q){
                    q=q.next;
                    p=p.next;
                }
                tail.next=null;
                return q;
            }
        }

        tail.next=null;
        return null;

    }
}
