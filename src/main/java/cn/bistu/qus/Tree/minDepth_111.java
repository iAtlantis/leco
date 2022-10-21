package cn.bistu.qus.Tree;

import cn.bistu.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth_111 {
    public int minDepth(TreeNode root){
        if(root==null)
            return 0;

        int ans =1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int l = 1;

        // 队列中只要有节点
        while (!queue.isEmpty()){
            // 对该层的所有孩子遍历，用l_now 记录该层所有的节点，l表示下层的节点
            int l_now = l;
            l = 0;
            for(int i = 0;i<l_now;i++){
                // 判断出队节点是否还有孩子
                TreeNode t = queue.poll();
                // 如果是孩子节点
                if(t.left==null&&t.right==null){
                    return ans;
                }else {
                    // 不是则继续加入
                    if(t.left!=null) {
                        queue.offer(t.left);
                        l++;
                    }
                    if(t.right!=null) {
                        queue.offer(t.right);
                        l++;
                    }
                }
            }

            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        minDepth_111 solu = new minDepth_111();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4,null,n5);
        TreeNode n3 = new TreeNode(3,null,n4);
        TreeNode n2 = new TreeNode(2,null,n3);
        TreeNode n1 = new TreeNode(1,null,n2);

        System.out.println(solu.minDepth(n1));

    }
}
