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
public class TreeNodeVersion2 {
    
    int data;
    TreeNodeVersion2 lChild;
    TreeNodeVersion2 rChild;
    TreeNodeVersion2(int data){
        this.data=data;
    }
    private static TreeNodeVersion2 insertChild(int data, TreeNodeVersion2 root){
        if(root==null){
            root=new TreeNodeVersion2(data);
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
    private static void inOrderTrversal(TreeNodeVersion2 root){
        if(root==null)
            return;
        inOrderTrversal(root.lChild);
        System.out.print(root.data+" ");
        inOrderTrversal(root.rChild);
    }
//    public static void main(String [] args){
//        Scanner scan=new Scanner(System.in);
//        int size=scan.nextInt();
//        TreeNode root=null;
//        for(int i=0;i<size;i++){
//            int data=scan.nextInt();
//            root=insertChild(data, root);
//        }
//        inOrderTrversal(root);
//    }
}
