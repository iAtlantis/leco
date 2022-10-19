package cn.bistu.qus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2_40 {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> l = new ArrayList<>();
    public int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        if (candidates.length==0)
            return ans;
        Arrays.sort(candidates);
        backtr(candidates,target,0);
        return ans;
    }

    public void backtr(int[] nums,int target,int index){
        // basecase
        if(trackSum == target){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(trackSum>target)
            return;

        for(int i = index;i<nums.length;i++){
            // 减枝重复项
            if(i>index&&nums[i]==nums[i-1])
                continue;
            //加入
            l.add(nums[i]);
            trackSum+=nums[i];
            backtr(nums,target,i+1);
            trackSum-=nums[i];
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        combinationSum2_40 solu = new combinationSum2_40();
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(solu.combinationSum2(nums,8));
    }
}
