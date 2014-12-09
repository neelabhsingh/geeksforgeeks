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
//here we are taling the BST, because it is easy to implement
import java.util.*;
public class LowestCommonAncestorInBinaryTree {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();        
        BSTree bst=new BSTree();
        bst.root=null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            bst.root=bst.insertNode(bst.root, data);
        }
        int value1=scan.nextInt();
        int value2=scan.nextInt();
        int result=findLCA(bst.root,value1,value2);
        if(result==-1)
            System.out.println("n1 or n2 is not present");
        else{
            System.out.println("Result is "+result);
        } 
    }
    public static boolean findPath(Node root, List<Integer> list, int value){
        if(root==null)
            return false;
        list.add(root.data);
        if(root.data==value)
            return true;
        if(findPath(root.left, list,value)||findPath(root.right,list,value))
            return true;
        list.remove(list.size()-1); 
        return false;
    }
    public static int findLCA(Node root, int n1, int n2){
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        if(!findPath(root, list1, n1)||!findPath(root, list2, n2))
            return -1;
        int i=0;
        for( ;i<list1.size() && i<list2.size();i++)
            if(list1.get(i)!=list2.get(i))
                break;
        return list1.get(i-1);
    }
}
