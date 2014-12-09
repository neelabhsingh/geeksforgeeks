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
public class LengthOfTheLargestSubarrayWithContiguousElements {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] array=new int[size];
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }
        System.out.println(findMaxLength(array)); 
    }
    public static int findMaxLength(int [] array){
        int maxLength=1;
        
        int size=array.length;
        for(int i=0;i<size-1;i++){
            int max=array[i];
            int min=array[i];
            for(int j=i+1;j<size;j++){
                max=Math.max(array[j], max);
                min=Math.min(array[j],min);
                if(max-min==j-i)
                    maxLength=Math.max(maxLength,j-i);
            }
        }
        return maxLength;
    }
}
