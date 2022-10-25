package cn.bistu.qus.doubl;

import java.util.Arrays;

public class searchRange_34 {
    /**
      * @Description: 给定非递减数组，返回target的上下边界
      * @Param: [nums, target]
      * @return: int[]
      * @Author: Alon
      * @Date: 2022/10/25
      * @Time:
      **/
    public int[] searchRange(int[] nums, int target){
        int le = 0;
        int ri = nums.length-1;
        // 先找左侧边界
        while (le<=ri){
            int mid = le+(ri-le)/2;
            if(target <= nums[mid])
                ri = mid-1;
            else if(target>nums[mid])
                le = mid+1;
        }
        // 如果左侧边界不存在，则返回错误
        if(le==nums.length||nums[le]!=target) return new int[]{-1, -1};

        // 找到左侧边界，再找右侧边界
        ri = nums.length-1;
        int[] ans = new int[2];
        ans[0] = le;
        while (le<=ri){
            int mid = le+(ri-le)/2;
            if(nums[mid]<=target)
                le = mid+1;
            else
                ri = mid-1;
        }
        ans[1] = ri;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        searchRange_34 solu = new searchRange_34();
        System.out.println(Arrays.toString(solu.searchRange(nums, target)));
    }
}
