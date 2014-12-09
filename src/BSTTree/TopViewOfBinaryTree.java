/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTTree;

/**
 *
 * @author Neelabh
 */
Not completed
import java.util.*;
public class TopViewOfBinaryTree {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        
        BSTree bst=new BSTree();
        bst.root=null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            bst.root=bst.insertNode(bst.root, data);
        }
        
    }
    public static void printTopViewUtil(Node root){
        Queue<Node> queue=new LinkedList<>();
        Set<Integer> set=new HashSet<>();    
        queue.add(root);
        int position=0;
        while(!queue.isEmpty()){
            Node curr=queue.remove();
            
        }        
    }    
}
