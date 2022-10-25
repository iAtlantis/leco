package cn.bistu.qus.doubl;

import java.util.HashMap;
import java.util.Map;

public class checkInclusion_567 {
    /**
      * @Description: s2字符串中是否包含s1中的一种排列，连续
      * @Param: [s1, s2]
      * @return: boolean
      * @Author: Alon
      * @Date: 2022/10/25
      * @Time:
      **/
    public boolean checkInclusion(String s1, String s2) {
        // 无效情况
        if(s1.length()>s2.length())
            return false;

        Map<Character,Integer>need = new HashMap<>();
        Map<Character,Integer>window = new HashMap<>();
        // 初始化
        int le=0,ri=0,valid = 0;
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        while (ri<s2.length()){
            char c1 = s2.charAt(ri);
            ri++;
            // 更新窗口
            if(need.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1,0)+1);
                if(window.get(c1).intValue() == need.get(c1).intValue())
                    valid++;
            }

            // 收缩窗口
            while (ri-le >= s1.length()){
                // 先判断是否满足
                if(valid == need.size())
                    return true;
                // 不满足则更新窗口
                char c2 = s2.charAt(le);
                le++;
                if(need.containsKey(c2)){
                    if(window.get(c2).intValue()==need.get(c2).intValue())
                        valid--;
                    window.replace(c2,window.get(c2)-1);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion_567 solu = new checkInclusion_567();
        System.out.println(solu.checkInclusion("ab", "dsagfkjlagfyausdbfysadyfioasicvobdayvo"));
    }
}
