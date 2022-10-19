package cn.bistu.qus.backtrack;


import java.util.ArrayList;
import java.util.List;

// 组合问题
public class combine_77 {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> l = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        backtr(n,k,1);
        return ans;
    }

/**
  * @Description: 递归写法，搜索结果树中长度为k的节点，这种写法开销比较大，空间和时间
  * @Param: [n, k, index]
  * @return: void
  * @Author: Alon
  * @Date: 2022/10/19
  * @Time: 
  **/
    public void backtr(int n,int k,int index){
        // base
        if(l.size()==k)
            ans.add(new ArrayList<>(l));


        for(int i = index;i<=n;i++){
            l.add(i);
            backtr(n,k,i+1);
            l.remove(l.size()-1);
        }
    }
    /**
      * @Description: 另一种思路就是，有序排列组合可以利用二进制的组合的特点=。=不会写
      * @Param: []
      * @return: void
      * @Author: Alon
      * @Date: 2022/10/19
      * @Time: 
      **/
    public void bin2ans(){
        
    }

    public static void main(String[] args) {
        combine_77 solu = new combine_77();

        List<List<Integer>> anst = solu.combine(3,2);

        System.out.println(anst);
    }
}
