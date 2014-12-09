/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

/**
 *
 * @author Neelabh
 * http://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
 */
import java.util.*;
public class SmallestPositiveInteger {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] array=new int[size];
        for(int i=0;i<size;i++){
            int data=scan.nextInt();
            array[i]=data;
        }
        System.out.println(findMinNumber(array)); 
    }
    public static int findMinNumber(int [] array){
        int n=array.length;
        int result=1;
        for(int i=0;i<n&&array[i]<=result;i++){ // Here = very important.
            result+=array[i];
        }
        return result;
    }
}
