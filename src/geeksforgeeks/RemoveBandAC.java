/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeksforgeeks;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class RemoveBandAC{ 
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        char [] array=str.toCharArray();
        int size=str.length();
        int j=0;
        for(int i=0;i<size;i++){
            if(array[i]!='b'){
                array[j]=array[i];
                j++;
            }
            else if(array[i]=='c'){                
               while(j>=0 && array[i]=='c' && array[j]=='a' && i<size){
                j--;
                i++;            
               } 
            } 
            else if(array[i]=='b'){
                i++;
            }
        }
        for(int i=0;i<=j;i++){
            System.out.print(array[i]);
        }
    }
}








