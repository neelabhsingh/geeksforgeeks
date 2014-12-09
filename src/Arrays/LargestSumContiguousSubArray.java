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
public class LargestSumContiguousSubArray {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] array=new int[size];
        for(int i=0;i<size;i++)
            array[i]=scan.nextInt();
        System.out.println(maxSumArray(array)); 
    }
    public static int maxSumArray(int [] array){
        int size=array.length;
        int maxSumSoFar=array[0];
        int currSum=array[0];
        for(int i=0;i<size;i++){
            currSum=Math.max(array[i],currSum);
            maxSumSoFar=Math.max(maxSumSoFar,currSum);
        }
        return maxSumSoFar;
    }
}
