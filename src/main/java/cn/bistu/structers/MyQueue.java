package cn.bistu.structers;

import java.util.Stack;

class MyQueue {

    // 输入栈+输出栈
    public Stack<Integer>  ins;
    public Stack<Integer>  outs;
    public MyQueue() {
        ins = new Stack<>();
        outs = new Stack<>();
    }

    // 正常放置进入
    public void push(int x) {
        ins.push(x);
    }

    public int pop() {
        // 出的时候先判断输出栈是否为空
        check();
        return outs.pop();
    }

    public int peek() {
        // 原理同pop，这里需要注意与push相同的判断原理，抽取公共函数功能check()
        check();
        return outs.peek();
    }

    public boolean empty() {
        return ins.empty()&&outs.empty();
    }

    public void check(){
        // 检查输出栈是否为空，若为空则转换
        if(outs.empty()){
            while (!ins.empty()){
                outs.push(ins.pop());
            }
        }
    }


    public static void main(String[] args) {

    }
}