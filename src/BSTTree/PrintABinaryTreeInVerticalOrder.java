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
public class PrintABinaryTreeInVerticalOrder {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        
        BSTree bst=new BSTree();
        bst.root=null;
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            bst.root=bst.insertNode(bst.root, data);
        }
        printVerticalOrderUtil(bst.root);
    }
    public static void printVerticalOrderUtil(Node root ){
        Map<Integer, List<Integer>> hashMap=new HashMap<Integer,List<Integer>>();
        printVerticalOrder(root,hashMap,0);
        Map<Integer, List<Integer>> treeMap=new TreeMap<Integer, List<Integer>>(hashMap);
        printMap(treeMap);        
    }
    public static void printMap(Map<Integer,List<Integer>> map){
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int key=entry.getKey();
            List<Integer> list=map.get(key);
            Iterator itr=list.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next()+" "); 
            }
            System.out.println();
        }
    }
    public static void printVerticalOrder(Node root, Map hashMap, int position){
        if(root==null)
            return;
        printVerticalOrder(root.left,hashMap,position-1);
        printVerticalOrder(root.right, hashMap, position+1);
        if(!hashMap.containsKey(position)){
            List<Integer> list=new ArrayList<Integer>();
            list.add(root.data);
            hashMap.put(position, list);
        } else{
            List<Integer> list=(List)hashMap.get(position);
            list.add(root.data);
            hashMap.put(position, list);
        }        
    }
}
