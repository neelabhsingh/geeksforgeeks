/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class CheckLinkedListIsPalindrome {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int  size=scan.nextInt();
        LinkedList linkedList=new LinkedList();
        Node head=linkedList.head;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            head=linkedList.insertNode(head, data);
        }
        //linkedList.printLinkedList(head);
        head=linkedList.reverseList(head);
        boolean result=isLinkedListIsPalindrome(head);
        if(result)
            System.out.println("Linked List is Palindrome");
        else
            System.out.println("Linked List is not Palindrome");
    }
    public static boolean isLinkedListIsPalindrome(Node head){
        Node slow,fast;
        slow=fast=head;
        Node previous=null;
        Node head2=null;
        Node midNode=null;
        while(fast!=null && fast.next!=null){
            previous=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)// This will happen in case of odd number of nodes
        {
            midNode=slow;
            head2=slow.next;            
        }
        else
            head2=slow;
        previous.next=null;           // This is very important stapes     
        head2=reverseList(head2);       
        boolean result=compareList(head,head2);        
        head2=reverseList(head2);
        if(midNode!=null)
        {
            previous.next=midNode;
            midNode.next=head2;
        }
        else{
            previous.next=head2;
        }
        return result;
    }
    public static void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    } 
    public static boolean compareList(Node head1, Node head2){
        while(head1!=null && head2!=null){
            if(head1.data==head2.data){
                head1=head1.next;
                head2=head2.next;
            }
            else
              return false;
        }
        if(head1==null && head2==null)
            return true;
        return false;
    }
    public static Node reverseList(Node head){
        Node prev=null;
        Node current=head;
        Node next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
