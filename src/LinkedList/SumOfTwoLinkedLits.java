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
public class SumOfTwoLinkedLits {
    SLinkedList sum;
    int carry;
    
    public ListNode addListSameSize(ListNode head1, ListNode head2){
        if(head1==null)
            return null;
        ListNode result=new ListNode();
        
        result.next=addListSameSize(head1.next, head2.next);
        int sumValue=head1.val+head2.val+carry;
        carry=sumValue/10;
        result.val=sumValue%10;
        return result;
    }
    public void swap( ListNode head1, ListNode head2){
        ListNode temp=head1;
        head1=head2;
        head2=temp;
    }
    public void add(SLinkedList list1, SLinkedList list2){
        if(list1.getSize()==0){
            sum.head=list2.head;
            return;
        } else if(list2.getSize()==0){
            sum.head=list1.head;
            return;
        }
        int size1=list1.getSize();
        int size2=list2.getSize();
        if(size1==size2)
            sum.head=addListSameSize(list1.head,list2.head);
        else{
            int diff=Math.abs(size1-size2);
            if(size1<size2){
                swap(list1.head,list2.head);
            }
            ListNode list11=list1.head;
            while(diff>0){
                list11=list11.next;
                diff--;
            }
            sum.head=addListSameSize(list11, list2.head);
            sum.head=addCarryToRemaining(list1.head, list11);
            if(carry>0){
                ListNode newHead=new ListNode(carry);
                newHead.next=sum.head;
                sum.head=newHead;
            }
        }
    }
    public ListNode addCarryToRemaining(ListNode head1, ListNode head2){
        
        if(head1==head2){// when Larger list meets to smaller list 
            return sum.head;
        }
        ListNode result=new ListNode();
        
        result.next=addCarryToRemaining(head1.next, head2.next); 
        int sumVal=head1.val+carry;
        carry=sumVal/10;
        result.val=sumVal%10;
        return result;
    }
    public void printSum(){
        sum.printListNode(sum.head);  
    }
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size of first list");
        int size1=scan.nextInt();
        SLinkedList sll1=new SLinkedList();
        sll1.head=null;
        for(int i=0;i<size1;i++){
            int data=scan.nextInt();
            sll1.head=sll1.insertNode(sll1.head, data);
        }
        sll1.printListNode(sll1.head); 
        
        System.out.println("Enter the size of second list");
        SLinkedList sll2=new SLinkedList();
        int size2=scan.nextInt();
        for(int i=0;i<size2;i++){
            int data=scan.nextInt();
            sll2.head=sll2.insertNode(sll2.head, data);
        }
        sll1.printListNode(sll2.head); 
        SumOfTwoLinkedLits sList=new SumOfTwoLinkedLits();
        sList.add(sll1, sll2);
        sList.printSum();
    }  
    
}
 class ListNode{
        public int val;
        public ListNode next;
        public ListNode(){
            next=null;
            val=0;
        }
        public ListNode(int val){
            this.val=val;
            this.next=null;
        }
}
 class SLinkedList{
        public ListNode head;
        public int count;
        public int size(){
            return count;
        }
        public SLinkedList(){
            head=null;
            count=0;
        }
        public ListNode insertNode(ListNode head,int data){
            if(head==null){
                count++;
                head=new ListNode(data);
            }else{
                head.next=insertNode(head.next,data);
            }
            return head;
        }
        public int getSize(){
            return count;
        }
        public void printListNode(ListNode head){
            while(head!=null){
                System.out.print(head.val +" ");
                head=head.next;
            }
        }
 }