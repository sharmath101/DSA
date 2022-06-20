package TwoPointer;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        if(t == ""){
            return "";
        }
        int frequencyS[] = new int[256];
        int frequencyT[] = new int[256];
        int distChars = t.length();
        for (int i = 0; i < t.length(); i++) {
            frequencyT[t.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int countChars = 0;
        for(int i = 0 ; i < s.length() ; i++){
            frequencyS[s.charAt(i)]++;
            if(frequencyT[s.charAt(i)] != 0 && frequencyT[s.charAt(i)] < frequencyS[s.charAt(i)]){
                countChars++;
            }
            if(countChars == distChars){
                end = i;
                break;
            }
        }
        if(countChars < distChars){
            return "";
        }
        int ansStart = start;
        int ansEnd = end;
        int minValue = end - start + 1;
        while(end < s.length()){
            while(frequencyS[s.charAt(start)] > frequencyT[s.charAt(start)]){
                frequencyS[s.charAt(start)]--;
                start++;
                if(end - start + 1 < minValue) {
                    minValue = end - start + 1;
                    ansStart = start;
                    ansEnd = end;
                }

            }
            end++;
            if(end < s.length()){
                frequencyS[s.charAt(end)]++;
            }
        }
        return s.substring(start , end);
    }
}
