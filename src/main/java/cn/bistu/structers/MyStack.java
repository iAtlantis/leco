package cn.bistu.structers;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    // 一个队列实现栈
    Queue<Integer> myQue;
    public MyStack() {
        myQue = new ArrayDeque<>();
    }

    public void push(int x) {
        // 入栈的时候，当成队尾入队
        myQue.add(x);
    }

    public int pop() {
        // 出栈的时候 将前n-1个元素重新填入队尾巴
        int n = myQue.size();
        for(int i = 0; i<n-1; i++){
            myQue.add(myQue.poll());
        }
        return myQue.poll();
    }

    public int top() {
        // 就是做pop操作，然后把当前top元素再插入
        // 出栈的时候 将前n-1个元素重新填入队尾巴
        int n = myQue.size();
        for(int i = 0; i<n-1; i++){
            myQue.add(myQue.poll());
        }
        Integer ans = myQue.peek();
        myQue.add(myQue.poll());
        return ans;
    }

    public boolean empty() {
        return myQue.isEmpty();
    }

    public static void main(String[] args) {

    }
}
