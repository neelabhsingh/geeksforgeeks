/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

/**
 *
 * @author Neelabh
 */
import java.util.*;

public class SubsequenceOfString {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        String str1=scan.next();
        String str2=scan.next();
        int m=str1.length();
        int n=str2.length();
        boolean result=isASubsequenceOfOther(str1,str2,m,n);
        if(result)
            System.out.println("Str1 is SubString of other");
        else
            System.out.println("Str1 is not substring of other");
    }
    public static boolean isASubsequenceOfOther(String str1, String str2, int m, int n){
            
        if(m>n)
            return false;
        if(m==0)
            return true;
       if(str1.charAt(m-1)==str2.charAt(n-1))
           return isASubsequenceOfOther(str1, str2,m-1,n-1);
       return isASubsequenceOfOther(str1, str2,m,n-1);
    }
}
