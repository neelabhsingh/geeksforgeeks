/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreedyAlgorithm;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class ActivitySelectionProblem {
    public static void main(String [] args){
        Scanner scan=new Scanner(System.in);
        int numberOfActivity=scan.nextInt();
        Activity[] activities=new Activity[numberOfActivity];
        for(int i=0;i<numberOfActivity;i++){
            
            int startTime=scan.nextInt();
            int finishTime=scan.nextInt();
            activities[i]=new Activity(startTime,finishTime,i);
        }
        
//        for(Activity activity: activities){
//            System.out.print(activity.startTime+" "+activity.finishTime+", ");
//        }
        //System.out.println();
        ArrayList activitiesList=printMaxActivities(activities, numberOfActivity);
        Iterator itr=activitiesList.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");
    }
    public static ArrayList printMaxActivities(Activity []activities, int numberOfActivity){
        //Sort activities according to increasing order of finish time
        Arrays.sort(activities, new Comparator<Activity>(){
            @Override
            public int compare(Activity o1, Activity o2) {
                if(o1.finishTime>o2.finishTime)
                    return 1;
                else
                    return -1;
            }
        });
        for(Activity activity: activities){
            System.out.print(activity.startTime+" "+activity.finishTime+", ");
        }
        ArrayList<Integer> activitiesList=new ArrayList<Integer>();
        int i=0;
        activitiesList.add(activities[i].activityNumber);
        for(int j=1;j<numberOfActivity;j++){
            if(activities[j].startTime>=activities[i].finishTime){                
                activitiesList.add(activities[j].activityNumber);
                i=j;
            }
        }
        return activitiesList;
    }
}
class Activity{
    int activityNumber;
    int startTime;
    int finishTime;
    Activity(int startTime,int finshTime, int number){
        this.activityNumber=number;
        this.startTime=startTime;
        this.finishTime=finshTime;
    }
}