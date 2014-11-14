/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Neelabh
 */
public class FirstNonRepeatedCharacter {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        String string=scan.next();
        int len=string.length();
        HashMap<Character, Integer> hashMap=new HashMap<Character, Integer>();
        //First Scan
        for(int i = 0; i <len;i++){
            char currentCharacter=string.charAt(i);
            if(!hashMap.containsKey(currentCharacter)){
                hashMap.put(currentCharacter, 1);
            }
            else{
                hashMap.put(currentCharacter, hashMap.get(currentCharacter)+1);
            }
        }
        // Second Scan
        boolean flag=false;
        char firstNonRepeatingChar = 0;
        for(int i=0;i<len;i++){
                char c=string.charAt(i);
                if(hashMap.get(c)==1){
                    flag=true;
                    firstNonRepeatingChar=c;
                    break;
                }
        }
        if(flag==true)
            System.out.println("firstNonRepeatingChar is "+firstNonRepeatingChar);
        else
            System.out.println("There is no such type of character");
    }    
}
