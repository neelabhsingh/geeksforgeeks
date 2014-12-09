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
public class AddTwoLinkedList {
    static int  carry=0;
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size1=scan.nextInt();
        int size2=scan.nextInt();
        ListNode head1=null;
        ListNode head2=null;
        for(int i=0;i<size1;i++){
            int data=scan.nextInt();
            head1=insertNewNode(head1,data);
        }
        
        for(int i=0;i<size1;i++){
            int data=scan.nextInt();
            head2=insertNewNode(head2,data);
        }
        ListNode headOfFinalList=addTwoLinkedList(head1,head2);
        printList(headOfFinalList);
    }
    public static ListNode insertNewNode(ListNode head1, int data){
        if(head1==null){
            head1=new ListNode(data);
        }
        else
            head1.nextNode=insertNewNode(head1.nextNode, data);
        return head1;
    }
    public static ListNode addTwoLinkedList(ListNode head1, ListNode head2){
        ListNode headOfNewList=null;
        if(head1==null && head2==null)
            return null;
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        int lengthOfList1=countNodesOfList(head1);
        int lengthOfList2=countNodesOfList(head2);
        if(lengthOfList1==lengthOfList2)
            return addTwoListOfSameSize(head1,head2);
        if(lengthOfList1<lengthOfList2)
            swapHeadsOfLists(head1,head2);
        int diff=Math.abs(lengthOfList1-lengthOfList2);
        int i=0;
        ListNode currNode=head1 ;
        while(i<diff){           
            i++;
            currNode=currNode.nextNode;
        }
        headOfNewList=addTwoLinkedList(currNode,head2); 
        ListNode finalHead=addToRemainingList(head1, currNode);
        finalHead.nextNode=finalHead;
        return headOfNewList;
    }
    public static int countNodesOfList(ListNode head){
        int length=0;
        while(head!=null){
            head=head.nextNode;
            length++;
        }
        return length;
    }
    public static ListNode addTwoListOfSameSize(ListNode head1, ListNode head2){
        
        if(head1==null)
            return null; 
        ListNode headOfNewList=new ListNode();
        headOfNewList.nextNode=addTwoLinkedList(head1, head2);
        int midSum=head1.data+head2.data+carry;
        headOfNewList.data=midSum/10;
        carry=midSum%10;
        return headOfNewList;
    }
    public static void swapHeadsOfLists(ListNode head1, ListNode head2){
        ListNode temp=head1;
        head1=head2;
        head2=temp;
    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.nextNode;
        }
    }
    public static ListNode addToRemainingList(ListNode head1, ListNode head2 ){
        if(head1==head2)
            return null;
        ListNode result=new ListNode();
        result.nextNode=addToRemainingList(head1, head2);
        int sum=head1.data+carry;
        result.data=sum%10;
        carry=sum/10;
        return result;
    }
}
