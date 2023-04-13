package Replit.ArrayList_Sorting;

import java.util.ArrayList;
public class Sort {
    public static void sortArrayList(ArrayList<Integer> arr){
        //Bubble Sort Algorithm
        int n = arr.size();
        for (int i = 0; i < n-1; i++){
            for(int j = 0; j < n - i -1; j++){
                if (arr.get(j) > arr.get(j+1)){
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
    }
}
