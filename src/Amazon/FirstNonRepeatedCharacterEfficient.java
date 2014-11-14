/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import java.util.Scanner;

/**
 *
 * @author Neelabh
 */

public class FirstNonRepeatedCharacterEfficient {
    public static void main(String [] args){
        CharCountAndPosition [] array=new CharCountAndPosition[256];
        for(int i=0;i<256;i++)
        {
            array[i]=new CharCountAndPosition();
        }
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int len=str.length();
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            int index=c-'a';            
            int frequency=array[index].frequencyOfchar;
            if(frequency==0)
                array[index].firstIndex=i;
            array[index].frequencyOfchar=frequency+1;    
            //System.out.println(c+" "+array[index].frequencyOfchar);
        }
        boolean flag=false;
        int firstPosition=Integer.MAX_VALUE;
        for(int i=0;i<256;i++){            
            if(array[i].frequencyOfchar==1){
                //System.out.println("character="+(char)(i+(int)'a'));
                if(firstPosition> array[i].firstIndex){                    
                    firstPosition=array[i].firstIndex;
                    flag=true;
                }
            }            
        }
        if(flag==true)
            System.out.println(str.charAt(firstPosition));
        else
            System.out.println("There is no such type of character");
    } 
}
class CharCountAndPosition{
    int firstIndex;
    int frequencyOfchar;
}