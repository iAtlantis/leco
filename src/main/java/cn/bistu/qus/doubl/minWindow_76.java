package cn.bistu.qus.doubl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class minWindow_76 {
    /**
      * @Description: s中寻找满足t内所有字符出现次数的，最短字符串
      * @Param: [s, t]
      * @return: java.lang.String
      * @Author: Alon
      * @Date: 2022/10/25
      * @Time:
      **/
    public String minWindow(String s, String t){    // 滑动窗口
        Map<Character, Integer> need = new HashMap<>();
        char[] ts = t.toCharArray();
        for (char c : ts) {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        // 注意这里是Integer是个对象，是会使用缓存值的，所以如果数据量太多会直接new对象的
        Map<Character, Integer> window = new HashMap<>();
        // char[] ss = s.;
        // 记录变量
        int le = 0;
        int ri = 0;
        int start = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;

        // 右窗口移动
        while (ri < s.length()){
            char s1 = s.charAt(ri);
            ri++;
            // 更新窗口
            if(need.containsKey(s1)){
                window.put(s1,window.getOrDefault(s1,0)+1);
                if(window.get(s1).intValue()==need.get(s1).intValue())
                    valid++;
            }

            // 当数量满足后，开始缩小左窗口
            while (valid == need.size()){
                // 找最小包含字串
                if(ri-le<len){
                    len = ri-le;
                    start = le;
                }

                char s2= s.charAt(le);
                le++;
                // 更新窗口
                if(need.containsKey(s2)){
                    if(window.get(s2).intValue()== need.get(s2).intValue())
                        valid--;
                    window.put(s2,window.get(s2)-1);
                }
            }
        }

        if (len==Integer.MAX_VALUE)
            return "";
        else return s.substring(start,start+len) ;

    }

    public static void main(String[] args) {
        minWindow_76 solu = new minWindow_76();
        System.out.println(solu.minWindow("ADOBECODEBANC", "ABC"));
    }
}
