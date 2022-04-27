package com.wong.data_structures.linear.linked_list;

public class DoubleLinkedList {

    public CustomNode2 headNode = new CustomNode2();

    // add node to double linked list
    //1. get current linked list last node
    //2. set last node next to new node
    public void add(CustomNode2 customNode)
    {
        //because head node cannot move, we need one assistance temp to traverse
        CustomNode2 temp = headNode;
        while (true)
        {
            if(temp.next == null)
            {
                break;
            }
            temp = temp.next;
        }

        // assign both to become double linked list
        temp.next = customNode;
        customNode.prev = temp;

    }

    public CustomNode2 getHeadNode(){
        return headNode;
    }

    // add node to node list specific position by no
    public void addByOrder(CustomNode2 customNode)
    {
        // because single linked list only can traverse to next but cannot previous node, we must add to position node last node
        CustomNode2 temp = headNode;

//        while(true)
//        {
//            if(temp.next == null)
//            {
//                break;
//            }
//
//            temp = temp.next;
//        }

            // notice order, assign current node.next to temp.next first
            temp.next = customNode;
            customNode.prev = temp;


    }

    public void update(CustomNode2 customNode2)
    {
        if(headNode.next == null)
        {
            System.out.println("node list is empty");
            return;
        }

        CustomNode2 temp = headNode.next;
        boolean flag = false;

        while(true)
        {
            if(temp == null)
            {
                break;
            }

            if(temp.no == customNode2.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag == true)
        {
            temp.name = customNode2.name;;
            temp.nickName = customNode2.nickName;
        }
        else
        {
            System.out.println("didn't find this no in the node list " + customNode2.no);
        }
    }

    public void delete(int no)
    {
        if(headNode.next == null)
        {
            System.out.println("node list is empty");
            return;
        }

        CustomNode2 temp = headNode.next;
        boolean flag = false;

        while(true)
        {
            // already reach linked list node next
            if(temp == null)
            {
                break;
            }

            if(temp.no == no)
            {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag)
        {
            temp.prev.next = temp.next;

            if(temp.next != null)
            {
                temp.next.prev = temp.prev;
            }

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

        CustomNode2 temp = headNode.next;
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
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        CustomNode2 node1 = new CustomNode2(1,"wong","edward");
        CustomNode2 node2 = new CustomNode2(2,"lee","Zero");
        CustomNode2 node3 = new CustomNode2(3,"lee","leon");

        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);

        doubleLinkedList.update(new CustomNode2(3,"Lee","Leon"));
        doubleLinkedList.update(new CustomNode2(4,"Lee","Leon"));

        doubleLinkedList.delete(node3.no);

        doubleLinkedList.list();

    }

    static class CustomNode2 {

        public int no;
        public String name;
        public String nickName;
        public CustomNode2 next; // point to next node
        public CustomNode2 prev; // point to prev node

        public CustomNode2() {
        }

        public CustomNode2(int no, String name, String nickName) {
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
}
