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
public class BalancedParenthesis {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        String exp=scan.next();
        if(isParenthesisBalance(exp))
             System.out.println("Parenthesis is balanced");
        else
            System.out.println("Parenthesis is not balanced");
    }
    public static boolean isParenthesisBalance(String exp){
        Stack<Character> stack=new Stack<Character>();
        int size=exp.length();
        int i=0;
        char popChar;
        while(i<size){
            if(exp.charAt(i)=='{'||exp.charAt(i)=='('||exp.charAt(i)=='['){
                stack.push(exp.charAt(i));
                i++;
            }
            else if(exp.charAt(i)=='}'||exp.charAt(i)==']'||exp.charAt(i)==')'){
                if(stack.isEmpty())
                    return false;
                else
                    popChar=stack.pop();
                if(isSamePairsOfParenthesis(popChar,exp.charAt(i))){
                    i++;
                }
                else
                    return false;
            }
        }
        if(stack.isEmpty())
           return true;
        else
            return false;
    }
    public static boolean isSamePairsOfParenthesis(char left, char right){
        if(left=='(' && right==')' || left=='{' && right=='}'|| left=='[' && right==']')
            return true;
        else
            return false;
    }
}
