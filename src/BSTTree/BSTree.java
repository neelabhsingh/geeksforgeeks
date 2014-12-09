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
public class BSTree {
    Node root;
    public Node insertNode(Node root, int data){
        if(root==null){
            return new Node(data);
        }
            
        if(root.data>data){
            root.left=insertNode(root.left,data);
        }
        else
            root.right=insertNode(root.right,data);
        return root;
    }
    //
    public void inOrderTraversal(Node root){
        if(root==null)
            return ;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right); 
    }
    public void preOrderTraversal(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left); 
        preOrderTraversal(root.right);
    }
}
