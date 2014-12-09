/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class IsListIsPalindromeOrNot {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        ListNode head=null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            head=insertNewNode(head, data);
        }
        printList(head);
        System.out.println();
        boolean result=isPalindrome(head);
        if(result)
            System.out.println("Linked List is palindrome");
        else
            System.out.println("Linked List not is palindrome");
        printList(head);
    }
    public static ListNode insertNewNode(ListNode head, int data){
        if(head==null)
            head=new ListNode(data);
        else
            head.nextNode=insertNewNode(head.nextNode, data);
        return head;
    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.nextNode;
        }
    }
    public static boolean isPalindrome(ListNode head){
        ListNode slow,fast;
        slow=head;
        fast=head;
        ListNode prev=head;
        boolean result;
        ListNode midNode=null;// This Node is used when number of node is odd.
        while(fast!=null&&fast.nextNode!=null){
            prev=slow;
            slow=slow.nextNode;
            fast=fast.nextNode.nextNode;
        }
        prev.nextNode=null;
        
        if(fast!=null){
            midNode=slow;
            slow=slow.nextNode;
        }
        ListNode head2=reverseList(slow);
        printList(head);
        System.out.println();
        printList(head2);
        result=compareList(head, head2);
        if(midNode!=null){
            prev.nextNode=midNode;
            midNode.nextNode=reverseList(head2);
        }
        else{
            prev.nextNode=reverseList(head2);
        }
        return result;
    }
    public static ListNode reverseList(ListNode head){
        ListNode next, prev=null;
        ListNode curr=head;
        while(curr!=null){
            next=curr.nextNode;
            curr.nextNode=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static boolean compareList(ListNode head1,ListNode head2){
        while(head1!=null && head2!=null){
            if(head1.data!=head2.data){
                return false;
            }
            head1=head1.nextNode;
            head2=head2.nextNode;
        }
        if(head1!=null||head2!=null)
            return false;
        return true;
    }
}
