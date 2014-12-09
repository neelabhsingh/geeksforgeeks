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
public class CheckTwoSetAreDisJoin {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size1=scan.nextInt();        
        int [] array1=new int[size1];
        for(int i=0;i<size1;i++){
            int data=scan.nextInt();
            array1[i]=data;
        }
        int size2=scan.nextInt();
        int [] array2=new int[size2];
        for(int i=0;i<size2;i++){
            int data=scan.nextInt();
            array2[i]=data;
        }
        //boolean result=isDisjoin(array1, array2);
        boolean result=areDisjoint(array1,array2);
        if(result)
            System.out.println("Two sets are disjoint");
        else
            System.out.println("Two sets are not disjoint");
    }
    public static boolean isDisjoin(int [] array1, int [] array2){
        Arrays.sort(array1);
        //printArray(array1);
        //System.out.println();
        Arrays.sort(array2);
        //printArray(array2);
        //System.out.println();
        int i=0, j=0;
        int size1=array1.length;
        int size2=array2.length;        
        while(i<size1 && j<size2){
            if(array1[i]<array2[j])
                i++;
            else if(array2[j]<array1[i])
                j++;
            else
                return false;
        }
        return true;
    }
    public static void printArray(int [] array){        
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static boolean areDisjoint(int [] array1, int [] array2){
        HashSet<Integer> set=new HashSet<>();
        int size1=array1.length;
        int size2=array2.length;
        for(int i=0;i<size1;i++)
            set.add(array1[i]);
        for(int i=0;i<size2;i++){
            return !set.contains(array2[i]);
        }
        return true;
    }
}
