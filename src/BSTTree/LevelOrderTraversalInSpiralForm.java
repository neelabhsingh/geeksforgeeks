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
import java.util.*;
public class LevelOrderTraversalInSpiralForm {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();        
        BSTree bst=new BSTree();
        bst.root=null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            bst.root=bst.insertNode(bst.root, data);
        }
        
        levelOrderTraversalInSpiral(bst.root);
        
    }
    public static void levelOrderTraversalInSpiral(Node root){
        if(root==null)
            return;
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
           
            while(!stack1.isEmpty()){
                Node current=stack1.pop();
                System.out.print(current.data+" ");
                
                if(current.right!=null)
                    stack2.push(current.right);
                if(current.left!=null)
                    stack2.push(current.left);
            }
            while(!stack2.isEmpty()){
                Node current=stack2.pop();
                System.out.print(current.data+" ");
                if(current.left!=null)
                    stack1.push(current.left);
                if(current.right!=null)
                    stack1.push(current.right);
            }
        }      
    }
}
