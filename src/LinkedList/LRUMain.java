/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.HashMap;

/**
 *
 * @author Neelabh
 */
public class LRUMain {
    public static void main(String args []){
        
    }
}
class LRUCache{
    private HashMap<Integer,DoubleLinkedListNode> map=new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private final int capacity;
    private int len;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        len=0;
    }
    public int get(int key){
        if(map.containsKey(key)){
            DoubleLinkedListNode latest=map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else{
            return -1;
        }
    }
    public void removeNode(DoubleLinkedListNode node){
        DoubleLinkedListNode cur=node;
        DoubleLinkedListNode pre=node.pre;
        DoubleLinkedListNode post=cur.next;
        if(pre!=null){
            pre.next=post;
        }  else{
            head=post;
        }
        if(post!=null){
            post.pre=pre;
        } else{
            end=pre;
        }
    }
    public void setHead(DoubleLinkedListNode node){
        node.next=head;
        node.pre=null;
        if(head!=null){
            head.pre=node;
        }
        head=node;
        if(end==null){
            end=node;
        }
    }
    public void set(int key, int value){
        if(map.containsKey(key)){
            DoubleLinkedListNode oldNode=map.get(key);
            oldNode.val=value;
            removeNode(oldNode);
            setHead(oldNode);
        } else{
            DoubleLinkedListNode newNode=new DoubleLinkedListNode(key,value);
            if(len<capacity){
                setHead(newNode);
                map.put(key, newNode);
                len++;
            } else{
                map.remove(end.key);
                end=end.pre;
                if(end!=null){
                    end.next=null;
                }
                setHead(newNode);
                map.put(key, newNode);
            }            
        }
    }
}
class DoubleLinkedListNode{
    public int val;
    public int key;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int val,int key) {
        this.val=val;
        this.key=key;
    }
    
}