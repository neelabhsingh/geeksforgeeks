/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class FindIndexOfMajorityElement {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] array=new int[size];
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }
        int index=findStatingIndexOfMajarityElementUtil(array);
        System.out.println("index="+index);
    }
    public static int findStatingIndexOfMajarityElementUtil(int [] array){
        int start=0;
        int end=array.length-1;
        return binarySearchforMajority(array, start, end, end);            
    }
    
    public static int binarySearchforMajority(int [] array, int start, int end, int x){
        if(end>=start){
            int mid=(start+end)/2;
            if((mid==0||array[mid-1]<x)&& array[mid]==x)
                return mid;
            if(array[mid]<x)
                return binarySearchforMajority(array, mid+1, end, x);
            else 
                return binarySearchforMajority(array, start, mid-1, x);
        }
        return -1;  
    }
}
