package cn.bistu.qus.evday;

public class countStudents_1700 {
    // =====纯纯没看懂题目=====
    // 栽坑。。。
    // 纯纯模拟题，双指针模拟循环队列
    public int countStudents2(int[] students, int[] sandwiches){
        // 双指针表示循环队列，队空判断p==q
        int p = 0;
        int q = students.length-1;
        int top = 0; // 表示sand栈顶

        int t = p;
        // 当栈空或者再无匹配
        while(top<sandwiches.length){
            // 队首取栈顶,若匹配
            if(students[p] == sandwiches[top]){
                top++;
                // 做标记，如果下次未匹配，防止一直遍历
                t = (q+1)%students.length;
            }else {
                q = (q+1)%students.length;
            }

            p = (p+1)%students.length;

            if(p == t)  // 如果循环过了一遍还没找到
                return (q-p+students.length+1)%students.length;
        }

        return 0;



    }
    // 转成统计问题
    public int countStudents(int[] students, int[] sandwiches){
        // 统计01个数
        int st_1 =0;
        for (int student : students) {
            if(student==1)
                st_1++;
        }
        int st_0 = students.length-st_1;

        // 遍历栈，看是否够用，因为结束情况只有队列内没有匹配栈顶元素的了
        for(int top = 0;top<sandwiches.length;top++){
            // 如果栈顶元素匹配
            if(sandwiches[top]==1)
                if(st_1>0)
                    st_1--;
                else return sandwiches.length-top;
            if(sandwiches[top]==0)
                if(st_0>0)
                    st_0--;
                else return sandwiches.length-top;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] st =  {1,1,1,0,0,1};
        int[] sa = {1,0,0,0,1,1};
        countStudents_1700 sulo = new countStudents_1700();
        System.out.println(sulo.countStudents(st,sa));
    }
}
