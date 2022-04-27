package com.wong.data_structures.linear.queue;

public class CircularArrayQueue {

    private int maxSize; // array max size
    private int front; // queue head, point to first element, init value = 0
    private int rear; // queue rear, point to last element after one position, init =0
    private int[] arr;  // simulate queue

    public CircularArrayQueue(int maxSize)
    {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];

    }

    public boolean isFull()
    {
        return (rear+1) % maxSize ==front;
    }

    public boolean isEmpty()
    {
        return this.front == this.rear;

    }

    public void addQueue(int n)
    {
        if(isFull())
        {
            System.out.println("full");
            return;
        }
        arr[rear] = n;
        // move rear backward, need to consider mod
        rear = (rear + 1) % maxSize;

    }

    public int getQueue()
    {
        if(isEmpty())
        {
            System.out.println("empty queue, cannot get");
        }
        // 1.store front value to temp variable
        // 2.move front backward
        // 3.return temp variable
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("empty queue, cannot show queue");
        }

        for(int i = front; i<front+size() ;i++)
        {
            System.out.printf("arr[%d]=%d\n", i % maxSize,arr[i % maxSize]);
        }

    }

    public int size()
    {
        // example
        // rear = 1
        // front = 0
        // maxsize = 3
        // (1 + 3 -0) % 3 = 1, hence size = 1
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("empty queue, cannot get head");
        }
        return arr[front];
    }

    public static void main(String[] args)
    {
        // maxsize will be -1 in CircularArrayQueue, need to reserve 1 position to mod and count
        CircularArrayQueue circularArrayQueue = new CircularArrayQueue(4);
        circularArrayQueue.addQueue(5);
        circularArrayQueue.addQueue(10);
        circularArrayQueue.addQueue(15);
        circularArrayQueue.addQueue(20);
        circularArrayQueue.showQueue();
        System.out.println(circularArrayQueue.getQueue());
        circularArrayQueue.addQueue(20);
        circularArrayQueue.showQueue();


    }
}
