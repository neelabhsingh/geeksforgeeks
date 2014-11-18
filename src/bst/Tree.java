/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author neelabh
 */
import java.util.*;
public class Tree {
    TreeNode root;
    
    public static void main(String [] args){
        Tree tree=new Tree();
        tree.root=null;
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            tree.root=tree.insertChild(data, tree.root);
        }
        tree.inOrderTrversal(tree.root);
        
    }
    private  TreeNode insertChild(int data, TreeNode root){
        if(root==null){
            root=new TreeNode(data);
        }
        else
        {
            if(root.data>data)
                root.lChild=insertChild(data, root.lChild);
            else
                root.rChild=insertChild(data,root.rChild);
        }
        return root;
    }
    //Inorder traversal
    private void inOrderTrversal(TreeNode root){
        if(root==null)
            return;
        inOrderTrversal(root.lChild);
        System.out.print(root.data+" ");
        inOrderTrversal(root.rChild);
    }
}
