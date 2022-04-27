package com.wong.data_structures.linear.queue;

public class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize)
    {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;

    }

    public boolean isFull()
    {
        return rear == maxSize-1;
    }

    public boolean isEmpty()
    {
        return this.front == this.rear;

    }

    public void addQueue(int n)
    {
        if(!isFull())
        {
            this.rear++;
            this.arr[this.rear] = n;
        }
        else
        {
            return;
        }

    }

    public int getQueue()
    {
        int result;
        if(!isEmpty())
        {
            this.front++;
            result = this.arr[this.front];

        }
        else
        {
            throw new RuntimeException("empty queue, cannot get queue");
        }
        return result;
    }

    public int showHeadQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("empty queue, cannot show queue");
        }
        else
        {
            return this.arr[this.front+1];
        }
    }

    public static void main(String[] args)
    {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(10);
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.showHeadQueue());
    }

}
