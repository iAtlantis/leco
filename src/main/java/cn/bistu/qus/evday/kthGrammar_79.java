package cn.bistu.qus.evday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthGrammar_79 {
    public int[] ans=new int[31];
    /**
      * @Description: 0=>01,1=>10，求从0开始第n层，第k个字符的数字
     *  思路：第i+1层=第i层数左移2**(i-1)位+第i层数的反，迭代求解
      * @Param: [n, k]
      * @return: int
      * @Author: Alon
      * @Date: 2022/10/20
      * @Time:
      **/
    public int kthGrammar2(int n, int k){
        if(n==1)
            return 0;

        Arrays.fill(ans,0);
        // 迭代求值
        for(int i = 2;i<=n;i++){
            int t = (int) Math.pow(2,i-2);
            int le = ans[i-1]<<t;
            int oo = -(~ans[i-1]);
            int ooo = (int) Math.pow(2,i-1);
            int ri = (oo%ooo);
            ans[i] = le+ri;
        }

        int p = (int) (Math.pow(2,n-1)-k);
        p = (int) Math.pow(2,p);
        return ans[n]/p%2;
    }
    /**
      * @Description: 使用数学规律
      * @Param: [n, k]
      * @return: int
      * @Author: Alon
      * @Date: 2022/10/20
      * @Time: 
      **/
    public int kthGrammar(int n,int k){
        if(n==1)
            return 0;
        // 思路：从低向上开始判断左右部分
            //      如果左则同序，
            //      如果右则反序，控制k序号
        //      直到最顶层
        int nn = n;
        boolean flag = false;
        while (nn>1){
            // 判断左右
            if(k>Math.pow(2,nn-2)){
                k = (k-1)%(int)Math.pow(2,nn-2)+1;
                flag = !flag;
            }
            nn--;
        }
        // flag标记负责表示与上层是否相反
        if(flag)
            return 1;
        else return 0;
    }


    public static void main(String[] args) {
        kthGrammar_79 sulo = new kthGrammar_79();
        int n = 4;
        int k = 2;
        for(int i = 0;i<(int)Math.pow(2,n-1);i++){
            System.out.printf("%d",sulo.kthGrammar(n, i+1));
        }
    }
}
