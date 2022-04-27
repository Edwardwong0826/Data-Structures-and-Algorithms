package com.wong.data_structures.linear.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args){

        // 后缀表达式的计算方法：遍历整个表达式，如果为数字则入栈，如果为符号则将前面两个数字出栈，先出栈的在右边后出栈的在左边符号放中间算出来结果再扔到栈中即可
        // loop through the whole expression, if number then push, if operator then pop two numbers, calc the result with the operator, push res back to stack

        String[] tokens = {"3","4","+","5","*","6","-"};

        int a,b;
        Stack<Integer> s = new Stack<Integer>();

        for(String c:tokens){

            if(c.equals("+")){
                s.push(s.pop() + s.pop());
            }
            else if(c.equals("-")){
                b = s.pop();
                a = s.pop();
                s.push(a - b);
            }
            else if(c.equals("*")){
                s.push(s.pop() * s.pop());
            }
            else if(c.equals("/")){
                b = s.pop();
                a = s.pop();
                s.push(a - b);
            }
            else
                s.push(Integer.parseInt(c));
        }

        System.out.println((s).pop());

    }
}
