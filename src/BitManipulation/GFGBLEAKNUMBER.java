package BitManipulation;

public class GFGBLEAKNUMBER {
    int convert(int decimal)
    {
        int result = 0;
        int multiplier = 1;
        int count =0;
        while(decimal > 0)
        {
            int residue = decimal % 2;
            if(residue==1)
                count++;
            decimal     = decimal / 2;
            result      = result + residue * multiplier;
            multiplier  = multiplier * 10;
        }
        return count;
    }
    public int is_bleak(int n)
    {
        for(int i = 1 ; i <= n ; i++){
            if(convert(n - i) == i){
                return 0;
            }
        }
        return 1;
    }
}
