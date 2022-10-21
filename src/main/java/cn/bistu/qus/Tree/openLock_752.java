package cn.bistu.qus.Tree;

import java.util.*;

public class openLock_752 {
    public String upPlus(String t,int j){
        char[] chars = t.toCharArray();
        if(chars[j]=='9')
            chars[j]='0';
        else chars[j]++;

        return new String(chars);
    }
    public String downPlus(String t,int j){
        char[] chars = t.toCharArray();
        if(chars[j]=='0')
            chars[j]='9';
        else chars[j]--;

        return new String(chars);
    }

    public int openLock(String[] deadends, String target){
        // 存储deadends和标记
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        Set<String> visited = new HashSet<>();
        visited.add("0000");


        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Map<String, Integer> map = new HashMap<>();
        // 记录步数
        int num = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i =0;i<sz;i++){
                String t = queue.poll();
                if(dead.contains(t)){
                    continue;
                }
                if (t.equals(target))
                    return num;

                // 尝试拨转盘
                for(int j = 0;j<4;j++){

                    String s=upPlus(t,j);
                    if(!map.containsKey(s)) {
                        queue.offer(s);
                        map.put(s,1);
                    }
                    s = downPlus(t,j);
                    if(!map.containsKey(s)){
                        queue.offer(s);
                        map.put(s,1);
                    }

                }
//                System.out.printf("%s\t",t);
            }
//            System.out.printf("\n第%d次循环\n",num);
            num++;
        }
        return -1;
    }

    public static void main(String[] args) {
        openLock_752 sulo = new openLock_752();
        String[] dead = {"0201","0101","0102","1212","2002"};
        String tar = "0202";
        System.out.println(sulo.openLock(dead, tar));
    }
}
