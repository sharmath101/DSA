package TwoPointer;

import java.util.*;

public class GFGUNIONOFTWOSORTEDARRAY {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> resultList = new ArrayList<>();
        Set<Integer> resultSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            resultSet.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            resultSet.add(arr2[i]);
        }

        for(int i : resultSet){
            resultList.add(i);
        }
        return resultList;
    }
}
