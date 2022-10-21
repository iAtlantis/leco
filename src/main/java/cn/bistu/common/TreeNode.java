package cn.bistu.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(){}
    public TreeNode(int val){this.val = val;}
    public TreeNode(int val,TreeNode le, TreeNode ri){
        this.val = val;
        left = le;
        right = ri;
    }

    // 用数组建立树，若为-1则标记null
    public TreeNode createTree(int[] num){
        return null;
    }

}
