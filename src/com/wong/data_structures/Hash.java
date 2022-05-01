package com.wong.data_structures;

public class Hash
{
    // simple hash class to demonstrate the principle of hash table or hash map implementation
    public static void main(String[] args)
    {
        HashTable hashTable = new HashTable(5);
        hashTable.add(new Emp(0,"wong"));
        hashTable.add(new Emp(2,"Lee"));

        hashTable.list();

        hashTable.findEmpById(1);
        hashTable.findEmpById(2);
    }


}

class HashTable
{
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size)
    {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];

        for(int i=0; i<size; i++)
        {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp)
    {
        int no = hashFunction(emp.id);
        empLinkedLists[no].add(emp);
    }

    public void list()
    {
        for(int i=0; i<size; i++)
        {
            empLinkedLists[i].list();
            System.out.println();
        }
    }

    public void findEmpById(int id)
    {
        int no = hashFunction(id);
        Emp emp = empLinkedLists[no].findEmpById(id);

        if(emp == null)
        {
            System.out.println("in hash linked list, cannot find such employee");
            System.out.println();
        }
        else
        {
            System.out.println("found employee: "+ emp.toString() +" in - no " + no++ +" linked list");
        }
    }

    public  int hashFunction(int id)
    {
        // return id & size;
        return id % size;
    }


}


class Emp
{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

}

class EmpLinkedList{

    private Emp head;

    public EmpLinkedList()
    {

    }

    public void add (Emp emp)
    {
        if(head == null)
        {
            this.head = emp;
            return;
        }

        Emp curEmp = head;

        while(true)
        {
            if(curEmp.next == null)
            {
                break;
            }
            curEmp = curEmp.next;
        }

        curEmp.next= emp;

    }

    public void list()
    {
        if(head == null)
        {
            System.out.println("current link list empty");
            return;
        }

        Emp curEmp = head;
        while(true)
        {
            System.out.printf("=> id=%d name=%s\t",curEmp.id, curEmp.name);
            if(curEmp.next == null)
            {
                break;
            }
            curEmp = curEmp.next;
        }

    }

    public Emp findEmpById(int id)
    {
        if(head == null)
        {
            System.out.println("linkedlist empty");
            return null;
        }

        Emp curEmp = head;
        while(true)
        {
            if(curEmp.id ==id)
            {
                break;
            }

            if(curEmp.next == null)
            {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return  curEmp;
    }
}
