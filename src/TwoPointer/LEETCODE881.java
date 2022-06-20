package TwoPointer;

import java.util.Arrays;

public class LEETCODE881 {
    public int numRescueBoats(int[] people, int limit) {
        int start = 0;
        int end = people.length - 1;
        int answer = 0;
        Arrays.sort(people);
        while(start <= end){
            answer++;
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
        }
        return  answer;

    }
}
