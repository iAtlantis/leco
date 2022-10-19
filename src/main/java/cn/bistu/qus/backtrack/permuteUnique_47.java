package cn.bistu.qus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique_47 {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> l = new ArrayList<>();
    public boolean[] f;

    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        f = new boolean[nums.length];
        backtr(nums,0);
        return ans;
    }

    public void backtr(int[] nums, int index){
        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = index;i<nums.length;i++){
            // 如果用过了
            if(f[i])
                continue;
            if(i>0&&nums[i]==nums[i-1]&&!f[i-1])
                continue;

            l.add(nums[i]);
            f[i] = true;
            backtr(nums,0);
            f[i] = false;
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        permuteUnique_47 sulo = new permuteUnique_47();
        int[] nums = {1,1,2};
        System.out.println(sulo.permuteUnique(nums));
    }
}
