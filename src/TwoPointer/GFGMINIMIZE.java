package TwoPointer;

public class GFGMINIMIZE {
    //https://www.geeksforgeeks.org/minimize-maxai-bj-ck-minai-bj-ck-three-different-sorted-arrays/
    public static void main(String []args)
    {

        int[] D = { 5, 8, 10, 15 };
        int[] E = { 6, 9, 15, 78, 89 };
        int[] F = { 2, 3, 6, 6, 8, 8, 10 };
        System.out.println(solve(D, E, F));

    }

    private static int solve(int[] d, int[] e, int[] f) {
        int result = 1;
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        int ans = Integer.MAX_VALUE;
        while(i < d.length && j < e.length && k < f.length ){
            int value = Math.max(d[i] , Math.max(e[j] , f[k])) - Math.min(d[i] , Math.min(e[j] , f[k]));
            ans = Math.min(value , ans);
            int minValue = Math.min(d[i] , Math.min(e[j] , f[k]));
            if(d[i] == minValue){
                i++;
            }else if(e[j] == minValue){
                j++;
            }else{
                k++;
            }
        }
        return  ans;
    }
}
