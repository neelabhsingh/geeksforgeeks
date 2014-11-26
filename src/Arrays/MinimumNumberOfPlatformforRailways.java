/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class MinimumNumberOfPlatformforRailways {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        int [] arrivalTime=new int[size];
        int [] departureTime=new int[size];
        for(int i=0;i<size;i++){
            arrivalTime[i]=scan.nextInt();
            departureTime[i]=scan.nextInt();
        }
        Arrays.sort(arrivalTime);
        Arrays.sort(departureTime);
        int numberOfPlateform=1;
        int maxPlateform=1;
        int i=1,j=0; 
        while(i<size && j<size){
            if(arrivalTime[i]<departureTime[j]){
                numberOfPlateform++;
                i++;
                if(numberOfPlateform > maxPlateform)
                    maxPlateform=numberOfPlateform;
            }
            else{
                numberOfPlateform--;
                j++;
            }
        }
        
        System.out.println("minimum number of plateform is "+maxPlateform);
    }
    
}
