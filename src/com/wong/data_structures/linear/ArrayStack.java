package com.wong.data_structures.linear.stack;

import java.util.Stack;

public class ArrayStack
{
    // Stack is Last in First out structure, added at the end of the stack. However, pop will always remove the last element
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int num){

        if(isFull())
        {
            System.out.println("stack is full already");
            return;
        }

        top++;
        stack[top] = num;

    }

    public int pop(){

        if(isEmpty())
        {
            throw new RuntimeException("stack is empty");
        }

        return stack[top--];

    }

    public int peek(){

        if(isEmpty())
        {
            throw new RuntimeException("stack is empty");
        }

        return stack[top];
    }

    public static void main(String[] args){

        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println((stack).peek());
        System.out.println(stack.pop());
        System.out.println((stack).peek());

    }
}
