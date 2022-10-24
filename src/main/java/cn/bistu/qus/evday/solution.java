package cn.bistu.qus.evday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] wo1 = word1.toCharArray();
        char[] wo2 = word2.toCharArray();
        int w1 = wo1.length;
        int w2 = wo2.length;
        int i = 0;
        for(;i<w1&&i<w2;i++) {
            sb.append(wo1[i]);
            sb.append(wo2[i]);
        }
        for (;i<w1;i++){
            sb.append(wo1[i]);
        }
        for (;i<w2;i++){
            sb.append(wo2[i]);
        }

        return sb.toString();
    }



    public static void main(String[] args) {
        solution solution = new solution();
        int[] nums = {1,1,1,0,6,12};
    }
}
