/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;



import java.util.*;


/**
 *
 * @author Neelabh
 */
public class Question_140_Round1 {
    public static void main(String args[]) {
        Scanner scan=new Scanner(System.in);
        int xyProduct=scan.nextInt();
        int size=scan.nextInt();
        int [] intArray=new int[xyProduct];
        for(int i=0;i<size;i++){
            intArray[i]=scan.nextInt();
        }
        HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
        int countPairs=0;
        int frequencyOfX=0,frequencyOfY=0;
        for(int i=0;i<size;i++){
            int x=intArray[i];
            int y=xyProduct/x;
            if(!hashMap.containsKey(x)){
                hashMap.put(x,1);
                if(hashMap.containsKey(y)){
                   hashMap.remove(x);
                   frequencyOfY=hashMap.get(y);
                   if(frequencyOfY>1)
                       hashMap.put(y, frequencyOfY-1);
                   else
                       hashMap.remove(y);
                   System.out.println("x= "+x+"y= "+y);
                   countPairs++;
                }
            }
            else{
                if(hashMap.containsKey(y)){
                    frequencyOfY=hashMap.get(y);
                    frequencyOfX=hashMap.get(x);
                    
                    if(frequencyOfY>1)
                       hashMap.put(y, frequencyOfY-1);
                   else
                       hashMap.remove(y);
                    
                   if(frequencyOfX>1)
                       hashMap.put(x, frequencyOfX-1);
                   else
                       hashMap.remove(x);
                   System.out.println("x= "+x+"y= "+y);                   
                   countPairs++;                }
                frequencyOfX=hashMap.get(x);
                hashMap.put(x,frequencyOfX+1);
            }   
        }  
        System.out.println("Total numbers of Y and Y pairs "+countPairs);
    }
}
