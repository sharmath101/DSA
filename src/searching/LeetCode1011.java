package searching;

public class LeetCode1011 {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low , weights[i]);
            high += weights[i];
        }
        while(low <= high){
            int middle = low + (high - low)/2;
            int count = countDays(0 , weights.length , middle , weights);
            if(count <= days){
                high = middle - 1;
            }else{
                low = middle + 1;
            }

        }

        return low;


    }

    private int countDays(int start, int end, int middle, int[] weights) {
        int count = 1;
        int totalWeight = 0;
        for (int j = 0; j < end ; j++) {
            totalWeight += weights[j];
            if (totalWeight > middle) {
                count++;
                totalWeight = weights[j];
            }
        }
        return count;
    }
}
