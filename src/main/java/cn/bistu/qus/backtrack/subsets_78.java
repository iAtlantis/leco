package cn.bistu.qus.backtrack;

import java.util.ArrayList;
import java.util.List;

public class subsets_78 {
    List<List<Integer>> list= new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        backtr(nums,0);
        return list;
    }

    /**
      * @Description: 回溯法解决子集问题。用数组内的**相对顺序start**来保证生成子集的不重复。
     *                  也就是说，每次的开始遍历节点位置依次向后
      * @Param: [list, l, nums]
      * @return: void
      * @Author: Alon
      * @Date: 2022/10/18
      * @Time:
      **/
    public void backtr(int[] nums,int start){
        // 没有回溯条件，因为每一个节点的路径都需要记录
        list.add(new ArrayList<>(l));

        for(int i = start;i<nums.length;i++){
            // 做选择
            l.add(nums[i]);
            backtr(nums,i+1);
            l.remove(l.size()-1);
        }

    }

    public static void main(String[] args) {
        subsets_78 solution = new subsets_78();
        int[] nums={1,2,3};
        List<List<Integer>> lists=solution.subsets(nums);
        System.out.println(lists);
        System.out.printf("%d", lists.size());
    }
}
