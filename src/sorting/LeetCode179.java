package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    public class sortComprator implements Comparator<String>{

        @Override
        public int compare(String x, String y) {
            String a = x + y;
            String b = y + x;
            return  b.compareTo(a);
        }

    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] result = new String[n];
        for(int i = 0 ; i < n ; i++){
            result[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(result , new sortComprator());
        if (result[0].equals("0")) {
            return "0";
        }
        StringBuilder resultStringBuilder = new StringBuilder("");
        for(int i = 0 ; i < n ; i++){
            resultStringBuilder.append(result[i]);
        }
        return resultStringBuilder.toString();
    }
}
