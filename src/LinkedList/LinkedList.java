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
public class LinkedList {
    Node head;
    public Node insertNode(Node head, int data){
        if(head==null)
            head=new Node(data);
        else 
            head.next=insertNode(head.next,data);
        return head;
    }
    public Node reverseList(Node head){
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
    public void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }   
}

