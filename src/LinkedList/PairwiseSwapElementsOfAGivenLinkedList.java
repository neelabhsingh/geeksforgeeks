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
public class PairwiseSwapElementsOfAGivenLinkedList {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        LinkedList ll=new LinkedList();
        Node head=ll.head;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            head=ll.insertNode(head, data);
        }
        
        Node result=pairWiseSwap(head);
        ll.printLinkedList(result);
        System.out.println();
        //To run the following approach comment the above approach, because list has been changed
//        Node result1= pairWiseRecursiveApproach(head);
//        ll.printLinkedList(result1); 
    }
    //PairWiseSwap of the using iterative approcach
    public static Node pairWiseSwap(Node head){
        if(head==null|| head.next==null)
            return head;
        Node prev=head;
        Node curr=head.next;
        head=curr;
        while(true){
            Node next=curr.next;
            curr.next=prev;
            if(next==null|| next.next==null){
                prev.next=next;
                break;
            }
            prev.next=next.next;
            prev=next;
            curr=prev.next;
        }
        return head;
    }
    //Pairwise swap using recursive approach
    public static Node pairWiseRecursiveApproach(Node head){
        if(head==null|| head.next==null)
            return head; 
        Node remaining=head.next.next;
        Node newHead=head.next;
        System.out.println(newHead.data);
        head.next.next=head;
        head.next=pairWiseRecursiveApproach(remaining);
        return newHead;
    }
}
