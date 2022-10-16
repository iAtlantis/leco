package cn.bistu.qus.List;

public class removeElement_27 {
    /**
      * @Description: 不适用额外空间，原地删除所指数据
      * @Param: [nums]
      * @return: int
      * @Author: Alon
      * @Date: 2022/10/16
      * @Time:
      **/
    public int removeElement(int[] nums,int val){
        // 快慢指针
        int i=0,j=0;
        // 快指针负责找不相等
        // 慢指针找相等
        while (j<nums.length){
            // 找到要更新的值
            while (nums[j]==val){
                j++;
                if(j==nums.length){
                    return i;
                }
            }
            nums[i]=nums[j];
            i++;
            j++;
        }

        return i;
    }


    public static void main(String[] args) {
        int[] nums = {};
        removeElement_27 solution = new removeElement_27();
        int i = solution.removeElement(nums,3);
        for(int j = 0;j<i;j++){
            System.out.println(nums[j]);
        }
    }
}
