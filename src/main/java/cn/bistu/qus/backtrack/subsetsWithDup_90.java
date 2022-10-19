package cn.bistu.qus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class subsetsWithDup_90 {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> l = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums){
        // 排序
        Arrays.sort(nums);
        backtr(nums,0);
        return ans;
    }

    public void backtr(int[] nums,int index){
        //base case 子集问题加入所有遍历结点
        ans.add(new ArrayList<>(l));

        // 遍历num数组，跳过重复情况
        for(int i = index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1])
                continue;
            l.add(nums[i]);
            backtr(nums,i+1);
            l.remove(l.size()-1);
        }

    }

    public static void main(String[] args) {
        subsetsWithDup_90 sulo = new subsetsWithDup_90();
        int[] nums = {1,2,2};
        System.out.println(sulo.subsetsWithDup(nums));

    }

}
