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
public class AddOneToLinkedList {
    static int  carry=1;
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        LinkedList linkedList=new LinkedList();
        Node head=linkedList.head;
        head=null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            head=linkedList.insertNode(head, data);
        }
        head=addOneToLinkedList(head);
        
        if(carry>0){
            Node node=new Node(carry);
            node.next=head;
            head=node;
        }
        linkedList.printLinkedList(head);
    }
    public static Node addOneToLinkedList(Node head){
        if(head==null)
            return null;
        head.next=addOneToLinkedList(head.next);
        int sum=head.data+carry;
        head.data=sum%10;
        carry=sum/10;
        return head;
    }
}
