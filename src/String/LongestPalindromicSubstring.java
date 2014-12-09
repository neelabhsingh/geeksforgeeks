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
public class LongestPalindromicSubstring {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        System.out.println(longestPalindrom(str));
    }
    public static String longestPalindrom(String str){
        int n=str.length();
        boolean [][] table=new boolean[n][n];
        int maxLength=1;
        for(int i=0;i<n;i++){
            table[i][i]=true;
        }
        int start=0;
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                table[i][i+1]=true;
                start=i;
                maxLength=2;
            }                
        }
        for(int k=3;k<=n;k++){
            System.out.println("k= "+k);
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                System.out.print("j="+j+", i"+i);
                if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    table[i][j]=true;
                    if(k>maxLength){
                        maxLength=k;
                        start=i;
                    }               
                }
            }
        }
        return str.substring(start, start+maxLength);
    }
}
