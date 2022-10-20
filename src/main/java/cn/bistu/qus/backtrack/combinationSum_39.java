package cn.bistu.qus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum_39 {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> l = new ArrayList<>();
    public int sum = 0;
    /**
      * @Description: 无重复元素但可重复使用，返回所有满足和为target的集合
     *  思路：回溯法，对所有选择进行排序，满足和大于则返回
      * @Param: [candidates, target]
      * @return: java.util.List<java.util.List<java.lang.Integer>>
      * @Author: Alon
      * @Date: 2022/10/20
      * @Time:
      **/
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        backtr(candidates,target,0);
        System.out.println(ans);
        return ans;
    }

    public void backtr(int[] nums, int target,int index){
        // base case
        if(sum>target)
            return;
        if (sum==target){
            ans.add(new ArrayList<>(l));
            return;
        }

        // 尝试所有选择
        for(int i = index;i<nums.length;i++){
            sum+=nums[i];
            l.add(nums[i]);
            backtr(nums,target,i);
            l.remove(l.size()-1);
            sum-=nums[i];
        }
    }


    public static void main(String[] args) {
        combinationSum_39 solu = new combinationSum_39();
        int[] num={2,3,4,7};
        solu.combinationSum(num,7);
    }
}
