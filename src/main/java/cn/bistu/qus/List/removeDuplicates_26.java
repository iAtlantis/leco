package cn.bistu.qus.List;

public class removeDuplicates_26 {
    public int removeDuplicates(int[] num){

        // 快慢指针删除重复项
        int i=1,j = 0;
        // j指针负责遍历，i负责更新
        while (j!=num.length-1){
            // 相等则j指针后移,j指的是新数
            do {
                j++;
                // 这里需要多注意
                // 每次更新j值的时候都需要做额外判断，
                // 否则会造成边界溢出
                if(j==num.length)
                    return i;
            }while (num[j]==num[j-1]);

            // 找到不相等的，赋值给num【i】
            num[i]=num[j];
            i++;
        }


        return i;
    }

    public static void main(String[] args) {
        int[] num = {1,1};
        removeDuplicates_26 solution = new removeDuplicates_26();
        System.out.printf("%d", solution.removeDuplicates(num));
        for(int i =0;i< solution.removeDuplicates(num);i++){
            System.out.printf("%d",num[i]);
        }
    }
}
