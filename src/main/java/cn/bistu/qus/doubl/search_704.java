package cn.bistu.qus.doubl;

public class search_704 {
    public int search(int[] nums, int target){
        int le = 0;
        int ri = nums.length-1;

        while (le<=ri){
            int mid = le+(ri-le)/2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid]<target)
                le = mid+1;
            else
                ri = mid-1;
        }

        return -1;
    }

}
