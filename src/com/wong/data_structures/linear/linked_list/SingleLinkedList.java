package com.wong.data_structures.linear.linked_list;

public class SingleLinkedList {

    public CustomNode headNode = new CustomNode();

    // add node to single linked list
    //1. get current linked list last node
    //2. set last node next to new node
    public void add(CustomNode customNode)
    {
        //because head node cannot move, we need one assistance temp to traverse
        CustomNode temp = headNode;
        while (true)
        {
            if(temp.next == null)
            {
                break;
            }
            temp = temp.next;
        }

        temp.next = customNode;

    }

    // add node to node list specific position by no
    public void addByOrder(CustomNode customNode)
    {
        // because single linked list only can traverse to next but cannot previous node, we must add to position node last node
        CustomNode temp = headNode;
        boolean flag = false;

        while(true)
        {
            if(temp.next == null)
            {
                break;
            }

            if(temp.next.no > customNode.no)
            {
                break;
            }
            else if(temp.next.no == customNode.no)
            {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag)
        {
            System.out.println("There is already existing node no, cannot add to single linked list");
        }
        else
        {
            // notice order, assign current node.next to temp.next first
            customNode.next = temp.next;
            temp.next = customNode;
        }

    }

    public void update(CustomNode customNode)
    {
        if(headNode.next == null)
        {
            System.out.println("node list is empty");
            return;
        }

        CustomNode temp = headNode.next;
        boolean flag = false;

        while(true)
        {
            if(temp == null)
            {
                break;
            }

            if(temp.no == customNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag == true)
        {
            temp.name = customNode.name;;
            temp.nickName = customNode.nickName;
        }
        else
        {
            System.out.println("didn't find this no in the node list " +customNode.no);
        }
    }

    public void delete(CustomNode customNode)
    {
        if(headNode.next == null)
        {
            System.out.println("node list is empty");
            return;
        }

        CustomNode temp = headNode.next;
        boolean flag = false;

        while(true)
        {
            if(temp.next == null)
            {
                break;
            }

            if(temp.next.no == customNode.no)
            {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag)
        {
            temp.next = temp.next.next;
        }
        else
        {
            System.out.println("delete node not exists in node list");
        }

    }

    public void list()
    {
        // check the linked list is it empty
        if(headNode.next == null)
        {
            System.out.println("linked list empty");
            return;
        }

        CustomNode temp = headNode.next;
        while (true)
        {
            if(temp == null)
            {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    public static void main(String[] args)
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        CustomNode node1 = new CustomNode(1,"wong","edward");
        CustomNode node2 = new CustomNode(2,"lee","Zero");
        CustomNode node3 = new CustomNode(3,"lee","leon");

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);

        singleLinkedList.update(new CustomNode(3,"Lee","Leon"));
        singleLinkedList.update(new CustomNode(4,"Lee","Leon"));

        singleLinkedList.delete(new CustomNode(3,"Lee","Leon"));

        singleLinkedList.list();

    }
}

class CustomNode{

    public int no;
    public String name;
    public String nickName;
    public CustomNode next; // point to next node

    public CustomNode() {
    }

    public CustomNode(int no, String name, String nickName)
    {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "CustomNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

