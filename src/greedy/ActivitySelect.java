package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActivitySelect {

    class Activity implements Comparable<Activity>{
        int start;
        int finish;

        @Override
        public int compareTo(Activity o) {
            return this.finish - o.finish;
        }

        public  Activity(int s,int f){
            this.start = s;
            finish = f;
        }
    }

    public static int getMaxActivity(int[] s, int[] f,int n){
        int i = 0;
        int c =1;
        for(int j =1;j<n;j++){
            if(s[j] > f[i]){
                i =j;
                c++;
            }
        }
        return c;

    }

    public static void findActivity(int[] s, int[] f,int n){
        int i = 0;
        int c =1;
        System.out.print(i);
        for(int j =1;j<n;j++){
            if(s[j] > f[i]){
                System.out.print(j);
                i =j;
                c++;
            }
        }

    }
//6
//        1 3 0 5 8 5
//        2 4 6 7 9 9
    public static void findMaxActivity(List<Activity> activities){
        int n= activities.size();
        Collections.sort(activities);
        int i=0;
        System.out.print(i);
        for(int j =1;j<n;j++){
            if(activities.get(j).start > activities.get(i).finish){
                i =j;
                System.out.print(j);
            }
        }


    }
    public static void printActivity(List<Activity> activity){
        activity.forEach(activity1 -> System.out.print(activity1.finish+" "));

    }
    public static int getMaxActivity2(List<Activity> activities){
        Collections.sort(activities);
        printActivity(activities);
        int n= activities.size();
        int i = 0;
        int c =1;
        for(int j =1;j<n;j++){
            if(activities.get(j).start > activities.get(i).finish){
                i =j;
                c++;
            }
        }
        return c;




    }

//    1
//            6
//            1 3 2 5 8 5
//            2 4 6 7 9 9

//    8
//            50 74 59 31 73 45 79 24
//            70 75 65 44 76 73 103 32

    private List<Activity> prepareActivityList(int[] s,int[] f ,int n){
        List<Activity> activities = new ArrayList<>();
        for(int i=0;i<n;i++){
            activities.add(new Activity(s[i],f[i]));
        }
        return activities;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int[] s= new int[n];
            int[] f = new int[n];
            int i =0;
            while(i < n){
                s[i] = scanner.nextInt();
                i++;
            }
            i =0;
            while (i< n){
                f[i] = scanner.nextInt();
                i++;
            }
            ActivitySelect ob = new ActivitySelect();
            List<Activity> activities = ob.prepareActivityList(s,f,n);
            //printActivity(activities);
            //getMaxActivity2(activities);
            findMaxActivity(activities);
            //findActivity(activities);
            //System.out.println(getMaxActivity(s,f,n));


        }
    }
}
