package Replit.ArrayList_Sorting;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the minimum value: ");
        int min = in.nextInt();
        System.out.print("Enter the maximum value: ");
        int max = in.nextInt();

        int size = rand.nextInt(15)+1;
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            int randomList = rand.nextInt(max - min + 1) + min;
            list.add(randomList);
        }
        System.out.println("Unsorted list: "+list);
        Sort.sortArrayList(list);
        System.out.println("Sorted list: "+ list);

        in.close();
    }
}
