package TwoPointer;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int answer = 1;
        int frequency[] = new int[256];
        int end = 1;
        int start = 1;
        frequency[s.charAt(0)] = 1;
        while(end < s.length() - 1){
            if(frequency[s.charAt(end + 1)] == 0){
                end++;
                frequency[s.charAt(end + 1)]++;
            }else{
                frequency[s.charAt(end + 1)]--;
                start++;
            }
            answer = Math.max(answer , end - start + 1);
        }


        return answer;
    }
}
