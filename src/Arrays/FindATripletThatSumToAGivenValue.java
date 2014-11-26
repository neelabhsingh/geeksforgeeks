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
public class FindATripletThatSumToAGivenValue {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] array=new int[size];
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }
        int sum=scan.nextInt();
        boolean result=findTriplet(array,sum);
        if(result)
            System.out.println("Triplets are available");
        else
            System.out.println("Triplets are not available");
        
    }
    public static boolean findTriplet(int [] array, int sum){
        int size=array.length;
        Arrays.sort(array);
        for(int i=0;i<size-2;i++){
            int l=i+1;
            int r=size-1;
            while(l<r){
                if(array[i]+array[l]+array[r]==sum){
                    System.out.println("Triplets are "+array[i]+", " +array[l]+", "+array[r]);
                    return true;
                }
                if(array[i]+array[l]+array[r]<sum)
                    i++;
                else
                    r--;
            }
        }
        return false;
    }
}
