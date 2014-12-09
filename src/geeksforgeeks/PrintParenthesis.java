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
public class PrintParenthesis {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        char [] parenthesis=new char[n];
       // printParenthesis(0, n,0,0,parenthesis);
        _printParenthesis(0, n,0,0,parenthesis);
    }
    public static void printParenthesis(int pos, int n, int open, int close, char [] parenthesis){
        if(close==n){
            System.out.println("pos1="+pos);
            print(parenthesis);
            return;
        }
        else{
            if(open>close){
                System.out.println("pos2="+pos);
                parenthesis[pos]='}';
                printParenthesis(pos+1, n, open, close+1, parenthesis); 
            }
            if(open<n){
                System.out.println("pos="+pos);
                parenthesis[pos]='{';
                printParenthesis(pos+1, n, open+1, close, parenthesis); 
            }
        }
    }
    public static void _printParenthesis(int pos, int n, int open, int close, char [] parenthesis ){       
        if(close == n) 
        {
          print(parenthesis);
          return;
        }
      else
      {
        if(open > close) {
            parenthesis[pos] = '}';
            _printParenthesis(pos+1, n, open, close+1,parenthesis);
        }
        if(open < n) {
           parenthesis[pos] = '{';
           _printParenthesis(pos+1, n, open+1, close,parenthesis);
        }
      }
    }
    public static void print(char [] parenthesis){
        int n=parenthesis.length;
        for(int i=0;i<n;i++)
            System.out.print(parenthesis[i]+" "); 
    }
}
