package cn.bistu.qus.evday;

import java.util.ArrayList;
import java.util.Arrays;

public class StockSpanner_901 {

    // 定义差分数组
//    Arrays arr[][] = new Arrays[][];
    public int last;
    public ArrayList<Integer> num = new ArrayList<>();
    public ArrayList<Integer> len= new ArrayList<>();
    public StockSpanner_901() {

        //初始化
        last=0;
        num.add(Integer.MAX_VALUE);
        len.add(1);
    }

    public int next(int price) {
        // 存储价格
        num.add(price);
        // 往前查找比自己小的连续长度累和
        int t = 1;
        last++;
        int i = num.size()-1;
        while (num.get(i-t)<=price){
            t+=len.get(i-t);
        }

        len.add(t);
        return t;
    }

    public static void main(String[] args) {
        StockSpanner_901 solu = new StockSpanner_901();
        int[] price = {100,80,60,60,60,75,85};
        for (int i : price) {
            System.out.println(solu.next(i));
        }
    }
}
