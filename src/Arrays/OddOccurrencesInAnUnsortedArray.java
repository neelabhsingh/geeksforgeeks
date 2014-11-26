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
public class OddOccurrencesInAnUnsortedArray {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] array=new int[size];
        for(int i=0;i<size;i++){
            array[i]=scan.nextInt();
        }
        printTwoOdd(array);
    }
    public static void printTwoOdd(int []array){
        int xor=array[0];
        int size=array.length;
        int setBit=0;
        for(int i=1;i<size;i++)
            xor^=array[i];
        int x=0, y=0;
        setBit=xor&~(xor-1);
        for(int i=0;i<size;i++){
            if((array[i] & setBit)!=0){
                x^=array[i];
            }
            else
                y^=array[i];
        }
        System.out.println("Odd numbers are x="+x+" y="+y);
    }
}
