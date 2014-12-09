/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class ValidParentheses {
    public static void main(String [] args){        
        Scanner scan=new Scanner(System.in);
        String exp=scan.next();
        boolean result=isValidParesthesis(exp);
        if(result)
            System.out.println("Parenthesis Is Valid");
        else
            System.out.println("Parenthesis Is not Valid ");
    }   
    public static boolean isValidParesthesis(String exp){        
        int len=exp.length();        
        int i=0;
        Stack<Character> stack=new Stack<>();  
        while(i<len){
            char parenthesis=exp.charAt(i);
            if(isRightParethesis(parenthesis)){
                if(stack.isEmpty())
                    return false;
                else {
                    char popChar=stack.pop();                    
                    if(isValidPairs(popChar,parenthesis))
                        i++;
                }                
            }
            else{                
                stack.push(parenthesis);
                i++;
            }            
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    public static boolean isValidPairs(char leftParenthesis, char rightParenthesis){
        if(leftParenthesis=='(' && rightParenthesis==')'|| leftParenthesis=='{' && rightParenthesis=='}' ||
                leftParenthesis=='[' && rightParenthesis==']')
            return true;
        else
            return false;
    }
    public static boolean isRightParethesis(char parenthesis){
        if(parenthesis=='}'||parenthesis==']'||parenthesis==')')
            return true;
        else
            return false;
    }
}
