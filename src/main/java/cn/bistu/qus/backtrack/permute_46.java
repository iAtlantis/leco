package cn.bistu.qus.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute_46 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<>();
        boolean[] f = new boolean[nums.length];
        Arrays.fill(f,false);
        backtr(list,l,nums,f);
        return list;
    }
    /**
      * @Description: 回溯法实际上就是对结果树进行遍历，记录遍历过程中的路线选择
      * @Param: [l, nums]
      * @return: void
      * @Author: Alon
      * @Date: 2022/10/18
      * @Time:
      **/
    public void backtr(List<List<Integer>> list, List<Integer> l,int[] nums,boolean[] f){
        // 回溯条件
        if(l.size()==nums.length) {
            // 这里加入的新的对象拷贝
            list.add(new ArrayList<>(l));
            return;
        };

        // 做选择,使用f[i]==true做标记使用过
        for (int i =0;i<nums.length;i++) {
            if (f[i]) continue;
            l.add(nums[i]);
            f[i] = true;
            backtr(list,l,nums,f);
            // 移除选择
            l.remove(l.size()-1);
            f[i] = false;
        }

    }


    public static void main(String[] args) {
        permute_46 solution = new permute_46();
        int[] nums = {1,2,3};
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        list = solution.permute(nums);
        System.out.println(list);
    }
}
