package com.ec.core.prueba;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PruebaTech {
    public static int findMaxSum(List<Integer> list) {
    	List<Integer> sortedList = new ArrayList<>(list);
   	    Collections.sort(sortedList);
    	return sortedList.get(sortedList.size()-1) + sortedList.get(sortedList.size()-2);
    	
    /*	 int j = 0;
         int max = list.size() == 1 ? list.get(0) +list.get(1) : list.get(0);
         for (int i = 0; i < list.size(); i++) {
             int sum = list.get(j) + list.get(i);
             if (sum > max) {
                 max = sum;
                 if (list.get(j) < list.get(i)) {
                     j = i;
                 }
             }
         }
         return max;*/
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        // Should return 20, since 9 and 11 are the largest elements
        // and their sum is 20
        System.out.println(findMaxSum(list));
    }
}