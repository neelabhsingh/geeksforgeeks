package Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Neelabh
 * http://geeksquiz.com/stack-set-4-evaluation-postfix-expression/
 */
import java.util.*;
public class EvaluationOfPostfix {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        System.out.println(evaluatePostfix(str));
    }
    public static int evaluatePostfix(String str){
        Stack<Integer> stack=new Stack<>();
        int len=str.length();
        for(int i=0;i<len;i++){
            if(isDigit(str.charAt(i))){ 
                
                stack.push(str.charAt(i)-'0');
            }
            else{
                int val1=stack.pop();
                int val2=stack.pop();
                switch(str.charAt(i)){
                    case '+':
                        stack.push(val2+val1);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '/':
                        stack.push(val2/val1);                            
                }
            }
        }
        return stack.pop();
    }
    public static boolean isDigit(char x){
        if(x>='0'&& x<='9')
            return true;
        else
            return false;
    }
}
