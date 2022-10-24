package cn.bistu.qus.evday;

public class partitionDisjoint_915 {
    // 915 分割数组
    /**
     * @Description: 给定数组，划分为left和right，使得left.max <= right.min
     * @Param: [nums]
     * @return: int
     * @Author: Alon
     * @Date: 2022/10/24
     * @Time:
     **/
    public int partitionDisjoint(int[] nums) {
        // 思路，用记录数组存储，正向遍历区间最大值、逆向遍历区间最小值
        // 比较相邻对位上的值，满足则返回下标
        // 3n，2n
//        int[] n_min = new int[nums.length];
//        int[] n_max = new int[nums.length];
//
//        int t = Integer.MIN_VALUE;
//        for(int i = 0;i<nums.length;i++){
//            if(nums[i]>t)
//                t= nums[i];
//            n_max[i] = t;
//            System.out.printf("%d,",n_max[i]);
//        }
//        System.out.printf("\n");
//        t= Integer.MAX_VALUE;
//        for (int i = n_max.length-1;i>=0;i--){
//            if(nums[i]<t)
//                t = nums[i];
//            n_min[i] = t;
//            System.out.printf("%d,",n_min[i]);
//        }
//
//
//        for (int i = 1;i<n_max.length;i++){
//            if(n_max[i-1]<=n_min[i])
//                return i;
//        }
//        return n_max.length-1;





        // 一个n，1的思路，真他妈妙啊！！！！！

        // 一次遍历但是，维护上次遍历最大值的下标
        // 其实就是实际只用到两个值，当前下表最大值，以及当前下表的数组内数
        // 是否属于left，属于则更新，否则就往后走
        int curMax = nums[0];
        int lefMax = nums[0];   // 存储
        int ans = 0;
        for(int i = 1; i<nums.length;i++){
            // curMax表示[0,i]内的最大值
            curMax = Math.max(curMax,nums[i]);
            // 如果有小于左区间最大值的元素，修改下表和最大值。
            if(nums[i] < lefMax){
                lefMax  = curMax;
                ans = i;
            }
        }

        return ans+1;
    }
}
