//{ Driver Code Starts
//

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        head = tail = new Node(val);
        
        size--;
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Solution obj = new Solution();
            
            Node result = obj.findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

*/

/*
=> initialize a hash set and add all the data of second list to the set
=> have a start node and a temp node to traverse and start node to return
=> initialize start to 0 and temp to start
=>iterate through the 1st list and check if any data is in the hash set 
=> if so then add it to the temp else move to the next data
=> return start
*/
class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        HashSet<Integer> h = new HashSet<>();
        Node cur2 = head2;
        while(cur2 != null)
        {
            h.add(cur2.data);
            cur2 = cur2.next;
        }
        Node start = new Node(0);
        Node cur1 = head1;
        Node temp = start;
        while(cur1 != null)
        {
            if(h.contains(cur1.data))
            {
                temp.next = new Node(cur1.data);  // temp = start = 0
                temp = temp.next;
            }
            cur1 = cur1.next;
        }
        return start.next;
    }
}